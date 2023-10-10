package Week03_chy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//버튼으로 움직이는 자동차 표시 프로그램 만들어보기
//left 버튼 -> 왼 쪽
//right -> 오른 쪽
public class Week03_03 extends JFrame {
    JButton btnLeft = new JButton("Left");
    JButton btnRight = new JButton("Right");
    JButton btn = new JButton("");
    int x=50,y=50;
    private Image img;
    private int carX =100;
    public Week03_03(){

        setTitle("Car Moving");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        add(panel);


        ImageIcon icon = new ImageIcon("Week03_chy/5899542.png");
        btn.setIcon(icon);


        panel.setLayout(null);
        btn.setLocation(50,50);
        btn.setSize(100,100); //사진이 크롭되는 것이 아쉽다.
        
        btnLeft.setSize(80, 30);
        btnRight.setSize(80, 30);

        btnLeft.setLocation(100,200);
        btnRight.setLocation(210,200); //한 번 location, size 해줬으면 다른 것들도 해줘야함

        panel.add(btn);
        panel.requestFocus();
        panel.setFocusable(true);

        panel.add(btnLeft);
        panel.add(btnRight);


        btnLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCar(-10);  // Move car to the left by 10 pixels
            }
        });

        btnRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moveCar(10);  // Move car to the right by 10 pixels
            }
        });


        setVisible(true);

    }
    private void moveCar(int deltaX) {
        x+=deltaX;
        btn.setLocation(x,50);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Week03_03::new);
    }
}
