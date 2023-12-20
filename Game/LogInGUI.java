package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LogInGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private Statement stmt;

    // 로그인 GUI 생성자
    public LogInGUI() {
        // GUI 창 설정
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // 사용자명 입력 필드
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(usernameField, gbc);

        // 비밀번호 입력 필드
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(passwordField, gbc);

        // 로그인 버튼
        JButton loginButton = new JButton("Login");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(loginButton, gbc);

        // 회원가입 버튼
        JButton signUpButton = new JButton("회원가입");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        panel.add(signUpButton, gbc);



        // 로그인 버튼 클릭 이벤트 처리
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자명과 비밀번호 입력
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                try {
                    String query = "SELECT * FROM users WHERE playerName LIKE '%" + username + "%'";
                    Connection con = makeConnection();
                    stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                    ResultSet searchResult = stmt.executeQuery(query);

                    if (searchResult.next()) {
                        String storedPassword = searchResult.getString("password");

                        if (password.equals(storedPassword)) {
                            // Passwords match, login successful
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    new BrickBreakerGame(username);
                                }
                            });
                        } else {
                            // Passwords don't match, login failed
                            System.out.println("비밀번호가 틀렸습니다.");
                            // 인증 실패 시 메시지 표시
                            JOptionPane.showMessageDialog(LogInGUI.this, "Login failed. Please check your username and password.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(LogInGUI.this, "없는 아이디 입니다. 회원가입을 진행해주세요.");
                    }
                } catch (SQLException event) {
                    event.printStackTrace();
                }
            }
        });

        // 회원가입 버튼 클릭 이벤트 처리
        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자명과 비밀번호 입력
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                Connection con = makeConnection();
                try {
                    Statement stmt = con.createStatement();
                    String s = "INSERT INTO users (playerName,score, password) VALUES ";
                    s += "('" + username + "', 0," + password + ")";
                    System.out.println(s);
                    int i = stmt.executeUpdate(s);
                    if (i == 1) System.out.println("레코드 추가 성공");
                    else System.out.println("레코드 추가 실패");
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    System.exit(0);
                }

            }
        });

        // Set content pane
        setContentPane(panel);
    }

    // 데이터베이스 연결을 수행하는 메서드
    public static Connection makeConnection() {
        String url = "jdbc:mysql://localhost:3306/game";
        String id = "root";
        String password = "";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, id, password);
            return con;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // 메인 메서드
    public static void main(String[] args) {
        // GUI 실행
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogInGUI().setVisible(true);
            }
        });
    }
}
