package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LogInGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    private Map<String, String> users;

    public LogInGUI() {
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    // 로그인 성공 시 BrickBreakerGame 호출
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            new BrickBreakerGame();
                        }
                    });

                    // 로그인 창 닫기
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LogInGUI.this, "Login failed. Please check your username and password.");
                }
            }
        });

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        users = new HashMap<>();
        users.put("user1", "password1"); // 예시 사용자 -> DB 구현까지는 x
    }

    private boolean authenticateUser(String username, String password) {
        // 사용자 인증을 위한 메서드
        String storedPassword = users.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogInGUI().setVisible(true);
            }
        });
    }
}
