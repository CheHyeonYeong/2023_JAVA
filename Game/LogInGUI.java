package Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class LogInGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    // 사용자 정보를 저장하는 Map
    private Map<String, String> users;

    // 로그인 GUI 생성자
    public LogInGUI() {
        // GUI 창 설정
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // 사용자명 입력 필드
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField();

        // 비밀번호 입력 필드
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField();

        // 로그인 버튼
        JButton loginButton = new JButton("Login");

        // 로그인 버튼 클릭 이벤트 처리
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 사용자명과 비밀번호 입력
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // 사용자 인증
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
                    // 인증 실패 시 메시지 표시
                    JOptionPane.showMessageDialog(LogInGUI.this, "Login failed. Please check your username and password.");
                }
            }
        });

        // GUI에 컴포넌트 추가
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);

        // 사용자 정보 초기화 (예시 사용자 -> DB 구현까지는 x)
        users = new HashMap<>();
        users.put("user1", "password1");
    }

    // 사용자 인증 메서드
    private boolean authenticateUser(String username, String password) {
        // 저장된 비밀번호 가져오기
        String storedPassword = users.get(username);
        // 사용자명이 존재하고 입력 비밀번호와 일치하면 true 반환
        return storedPassword != null && storedPassword.equals(password);
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
