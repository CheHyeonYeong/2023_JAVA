package Week03_chy;

import javax.swing.*;

public class Week03_01  extends JFrame{
    public Week03_01() {
        JPanel panel = new JPanel();
        JFrame f = new JFrame("Login");
        f.add(panel);

        //하고 싶은 것: 회원 등록하기를 최 상단에 넣고 싶음.
        //정렬을 하고 싶다! -> 나중에 다시 리코딩 해보자

        panel.add(new JLabel("                                                                    회원 등록하기                                                                      "));
        JLabel label1 = new JLabel("이름");
        JTextField field1 = new JTextField(20);
        JLabel label2 = new JLabel("패스워드");
        JPasswordField field2 = new JPasswordField(20);
        JLabel label3 = new JLabel("이메일 주소");
        JTextField field3 = new JTextField(20);
        JLabel label4 = new JLabel("전화번호");
        JTextField field4 = new JTextField(20);

        JButton btn1 = new JButton("회원가입");
        JButton btn2 = new JButton("취소");

        panel.add(label1);
        panel.add(field1);
        panel.add(label2);
        panel.add(field2);
        panel.add(label3);
        panel.add(field3);
        panel.add(label4);
        panel.add(field4);
        panel.add(btn1);
        panel.add(btn2);

        f.setTitle("회원관리 시스템");
        f.setSize(300, 200);
        f.setVisible(true);
    }
    public static void main(String[] args) {

            Week03_01 f = new Week03_01();
    }
}
