package Game;

import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.*;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class BrickBreakerGame extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 600;
    private static final int PADDLE_WIDTH = 60;
    private static final int PADDLE_HEIGHT = 10;
    private static final int BALL_SIZE = 20;
    private static final int BRICK_WIDTH = 40;
    private static final int BRICK_HEIGHT = 20;
    private static final int NUM_BRICKS = 10;
    private static final int BALL_SPEED = 5;

    private int paddleX, score = 0;
    private int ballX, ballY, ballSpeedX, ballSpeedY;
    private boolean isGameOver;

    private List<Rectangle> bricks;

    private Clip clip; // 게임 끝날 때 효과음


    private GamePanel gamePanel;

    public BrickBreakerGame() {
        setTitle("Brick Breaker Game");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        gamePanel = new GamePanel();
        add(gamePanel);

        setVisible(true);
        requestFocus();
    }

    private void initializeGame() {
        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
        ballX = WIDTH / 2 - BALL_SIZE / 2;
        ballY = HEIGHT - PADDLE_HEIGHT - BALL_SIZE;
        ballSpeedX = BALL_SPEED;
        ballSpeedY = -BALL_SPEED;
        isGameOver = false;

        initializeBricks(); // 초기 벽돌 생성

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
                    paddleX -= PADDLE_WIDTH / 2;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < WIDTH - PADDLE_WIDTH) {
                    paddleX += PADDLE_WIDTH / 2;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        // Load and play the sound
        loadSound();
        playSound();
    }

    public class GamePanel extends JPanel {
        // Game state variables
        private int paddleX;
        private int ballX, ballY, ballSpeedX, ballSpeedY;
        private boolean isGameOver;

        // Other game-related variables

        public GamePanel() {
            // Initialize the game state
            initializeGame();

            // Set focusable and request focus
            setFocusable(true);
            requestFocus();

            // Add the key listener
            addKeyListener(new KeyListener() {
                @Override
                public void keyTyped(KeyEvent e) {}

                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT && paddleX > 0) {
                        paddleX -= PADDLE_WIDTH / 2;
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && paddleX < WIDTH - PADDLE_WIDTH) {
                        paddleX += PADDLE_WIDTH / 2;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {}
            });


            // Start game threads
            GameLogicThread gameLogicThread = new GameLogicThread();
            GraphicsUpdateThread graphicsUpdateThread = new GraphicsUpdateThread();

            gameLogicThread.start();
            graphicsUpdateThread.start();
        }
    }


    // 데이터베이스 연결을 수행하는 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/game";
        String id = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버 적재 성공");
            con = DriverManager.getConnection(url, id, password);
            System.out.println("데이터베이스 연결 성공");
            return con; // Return the Connection object on success
        } catch (ClassNotFoundException e) {
            System.out.println("드라이버를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("연결에 실패하였습니다.");
            e.printStackTrace(); // Print the exception details for debugging
        }
        return con; // Return null in case of an exception
    }

    // 게임 오버 시 효과음을 로드하는 메서드
    private void loadSound() {
        try {
            // Load sound file
            File soundFile = new File("Ending.mp3");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // Get a sound clip resource.
            clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // 게임 오버 시 효과음을 재생하는 메서드
    private void playSound() {
        if (clip != null) {
            clip.setFramePosition(0);  // Rewind to the beginning
            clip.start();  // Start playing
        }
    }

    // 벽돌 초기화를 수행하는 메서드
    private void initializeBricks() {
        bricks = new CopyOnWriteArrayList<>();

        int numRows = 5; // 원하는 행의 수
        int numCols = 10; // 원하는 열의 수

        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                int brickX = col * (BRICK_WIDTH + 5);
                int brickY = row * (BRICK_HEIGHT + 5);
                bricks.add(new Rectangle(brickX, brickY, BRICK_WIDTH, BRICK_HEIGHT));
            }
        }
    }

    // 게임 로직을 처리하는 스레드
    private class GameLogicThread extends Thread {
        @Override
        public void run() {
            while (!isGameOver) {
                moveBall();
                checkCollisions();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 그래픽 업데이트를 수행하는 스레드
    private class GraphicsUpdateThread extends Thread {
        @Override
        public void run() {
            while (!isGameOver) {
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 공의 움직임을 처리하는 메서드
    private void moveBall() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;

        if (ballX < 0 || ballX > WIDTH - BALL_SIZE) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballY < 0) {
            ballSpeedY = -ballSpeedY;

        } else if (ballY > HEIGHT - BALL_SIZE - PADDLE_HEIGHT && ballX > paddleX && ballX < paddleX + PADDLE_WIDTH) {
            ballSpeedY = -ballSpeedY;

        } else if (ballY > HEIGHT - BALL_SIZE) {
            playSound();
            isGameOver = true;
            int choice = JOptionPane.showConfirmDialog(this, "Game Over! Do you want to restart?",
                    "Game Over", JOptionPane.YES_NO_OPTION);
            String playerName = JOptionPane.showInputDialog("Enter your name:");

            // Score를 어딘가에 저장 (파일, 데이터베이스 등)
            saveScore(playerName, score);

            if (choice == JOptionPane.YES_OPTION) {
                // 게임 재시작
                GamePanel newGamePanel = new GamePanel();

                // 기존의 GamePanel을 제거하고 새로운 GamePanel을 추가
                remove(gamePanel);
                gamePanel = newGamePanel;
                add(gamePanel);

                // 프레임을 다시 그리기
                revalidate();
                repaint();
            } else {
                // 사용자가 아니오를 선택한 경우

                Connection con = makeConnection();
                try {
                    Statement stmt = con.createStatement();
                    String query = "SELECT * FROM users ORDER BY score DESC LIMIT 10;";

                    // 쿼리 실행
                    ResultSet resultSet = stmt.executeQuery(query);
                    String finish = "";
                    int i = 1;

                    // 결과 출력
                    while (resultSet.next()) {
                        String username = resultSet.getString("playerName");
                        int userScore = resultSet.getInt("score");
                        finish += i + " place playerName: " + username + ", Score: " + userScore + "\n";
                        i++;
                    }

                    JOptionPane.showMessageDialog(this, finish + "Your Score: " + score + "\nGoodBye");

                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }

                System.exit(0); // 예시로 게임을 완전히 종료하는 동작을 수행함
            }
        }
    }

    // 게임 재시작을 처리하는 메서드


    // 데이터베이스에 점수를 저장하는 메서드
    public static void saveScore(String playerName, int score) {
        Connection con = makeConnection();
        try {
            Statement stmt = con.createStatement();
            String s = "INSERT INTO users (playerName, score) VALUES ";
            s += "('" + playerName + "'," + score + ")";
            System.out.println(s);
            int i = stmt.executeUpdate(s);
            if (i == 1) System.out.println("레코드 추가 성공");
            else System.out.println("레코드 추가 실패");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    // 충돌을 검사하는 메서드
    private void checkCollisions() {
        Rectangle ballRect = new Rectangle(ballX, ballY, BALL_SIZE, BALL_SIZE);

        // 벽돌과의 충돌 검사
        for (int i = 0; i < bricks.size(); i++) {
            Rectangle brickRect = bricks.get(i);
            if (brickRect.intersects(ballRect)) {
                // 벽돌과의 충돌 처리
                score += 1;
                bricks.remove(i);
                ballSpeedY = -ballSpeedY;
            }
        }

        // 패들과의 충돌 검사
        Rectangle paddleRect = new Rectangle(paddleX, HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);
        if (paddleRect.intersects(ballRect)) {
            ballSpeedY = -ballSpeedY;
        }

        // 하단 벽과의 충돌 검사
        if (ballY > HEIGHT - BALL_SIZE) {
            // 공 위치 초기화
            ballX = WIDTH / 2 - BALL_SIZE / 2;
            ballY = HEIGHT - PADDLE_HEIGHT - BALL_SIZE;
            ballSpeedY = -BALL_SPEED;

            // 새로운 벽돌 추가
            addNewBrick();
        }
    }

    // 새로운 벽돌 추가 메서드
    private void addNewBrick() {
        // 벽돌 목록에 새로운 벽돌 추가
        synchronized (bricks) {
            bricks.add(new Rectangle((int) (Math.random() * (WIDTH - BRICK_WIDTH)), 50, BRICK_WIDTH, BRICK_HEIGHT));
        }
    }

    // 그림을 그리는 메서드
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        g.setColor(Color.WHITE);
        g.fillRect(paddleX, HEIGHT - PADDLE_HEIGHT, PADDLE_WIDTH, PADDLE_HEIGHT);

        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        g.setColor(Color.GREEN);
        synchronized (bricks) {
            for (Rectangle brickRect : bricks) {
                g.fillRect((int) brickRect.getX(), (int) brickRect.getY(), (int) brickRect.getWidth(), (int) brickRect.getHeight());
            }
        }
    }

    // 메인 메서드
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> new BrickBreakerGame());
            }
        });
    }
}
