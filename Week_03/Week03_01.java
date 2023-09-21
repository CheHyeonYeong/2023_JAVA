package Week_03;

import javax.swing.*;
import java.awt.*;

public class Week03_01  extends JFrame{
    public Week03_01() {
        JPanel panel = new JPanel();
        JFrame f = new JFrame("Login");
        f.add(panel);

        //여기에 엔터를 넣고 싶어ㅜㅜㅜ 흐어엉

        panel.add(new JLabel("                                                                    회원 등록하기                                                                      "));
        JLabel label1 = new JLabel("�씠由�");
        JTextField field1 = new JTextField(15);
        JLabel label2 = new JLabel("�뙣�뒪�썙�뱶");
        JTextField field2 = new JTextField(15);
        JLabel label3 = new JLabel("�씠硫붿씪 二쇱냼");
        JTextField field3 = new JTextField(15);
        JLabel label4 = new JLabel("�쟾�솕踰덊샇");
        JTextField field4 = new JTextField(15);

        JButton btn1 = new JButton("�벑濡앺븯湲�");
        JButton btn2 = new JButton("痍⑥냼");

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

        f.setTitle("�쉶�썝 �벑濡앺븯湲�");
        f.setSize(300, 200);
        f.setVisible(true);
    }
    public static void main(String[] args) {

            Week03_01 f = new Week03_01();
    }
}
