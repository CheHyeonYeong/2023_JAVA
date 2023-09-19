package Week_03;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

//버튼으로 움직이는 자동차 표시 프로그램 만들어보기
//left 버튼 -> 왼 쪽
//right -> 오른 쪽
public class Week03_03 extends JFrame {
    private JButton btnLeft = new JButton("Left");
    private JButton btnRight = new JButton("Right");
    private Image img;
    private int carX =100;
    public Week03_03(){
        setTitle("Car Moving");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load the car image
        ImageIcon icon = new ImageIcon("C:/Users/hyeonyeong/Downloads/5899542.png");
        img = icon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);

        // Create a custom JPanel to draw the car image
        JPanel carPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
            }
        };
        // Set up the panel with the car image
        carPanel.setPreferredSize(new Dimension(100, 100));

        // Add action listeners for the buttons to move the car left and right
        btnLeft.addActionListener(e -> moveCar(-10));
        btnRight.addActionListener(e -> moveCar(10));

        // Create a panel to hold the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnLeft);
        buttonPanel.add(btnRight);

        // Add components to the main frame
        add(carPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);


    }
    private void moveCar(int deltaX) {
        // Update the x-coordinate of the car
        //안움직여~!~!!~!!
        carX += deltaX;

        // Repaint the panel to update the car's position
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Week03_03::new);
    }
}
