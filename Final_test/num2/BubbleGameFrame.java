package Final_test.num2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BubbleGameFrame extends JFrame {

    public BubbleGameFrame() {
        setTitle("버블 게임"); // 프레임 제목 설정
        GamePanel p = new GamePanel();  //실제 동작하는 곳 -> class로 둬서 만듦
        setContentPane(p);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500); // 프레임 크기 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        new BubbleGameFrame();
    }
}

class GamePanel extends JPanel {

    JButton start, finish;
    public GamePanel() {

        setLayout(null);

        start = new JButton("시작");
        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        new BubbleThread(e.getX(), e.getY()).start(); // 마우스 클릭 시 버블 스레드 시작
                    }
                });
            }
        });

        start.setBounds(20, 5, 70, 30);

        add(start);

        finish = new JButton("종료");
        finish.addActionListener(e->{
            System.exit(0);
        });

        finish.setBounds(90, 5, 70, 30);

        add(finish);

    }

    class BubbleThread extends Thread {
        private JLabel bubble;
        private static final int BUBBLE_MOVE = 5; // 버블 이동 속도 상수 (조절 가능)

        public BubbleThread(int bubbleX, int bubbleY) {
            ImageIcon img = new ImageIcon("bubble.jpg"); // 이미지 아이콘 생성
            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconHeight());
            bubble.setLocation(bubbleX, bubbleY);
            add(bubble);

            repaint();
        }

        @Override
        public void run() {
            while (true) {
                int y = bubble.getY();

                bubble.setLocation(bubble.getX(), y - BUBBLE_MOVE);

                if (bubble.getY() + bubble.getHeight() < 0) {
                    remove(bubble); // 화면을 벗어난 버블 제거
                    break; // 루프 종료
                }

                try {
                    Thread.sleep(20); // 20밀리초 동안 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
