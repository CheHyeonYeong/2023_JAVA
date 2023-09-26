package Week_04_chy;

import javax.swing.*;
import java.awt.*;
//왜 안뜨지???
public class Week04_03_chy extends JFrame {
        public Week04_03_chy() {
            super("명함");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(500, 500);
            setVisible(true);

            // Load the image icon (ensure the path is correct)
            ImageIcon icon = new ImageIcon("image.png");

            JLabel label = new JLabel();
            label.setBounds(10, 77, 97, 21);
            label.setIcon(icon);
            add(label);

            // Name
            JLabel name = new JLabel("채현영");
            name.setBounds(170, 77, 97, 21);
            add(name);

            // Product Manager
            JLabel manager = new JLabel("프로덕트 매니저");
            manager.setBounds(170, 91, 150, 21);  // Adjusted width to fit the text
            add(manager);

            // DukSung Company
            JLabel company = new JLabel("덕성 주식 회사");
            company.setBounds(170, 101, 150, 21);  // Adjusted width to fit the text
            add(company);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new Week04_03_chy());
        }
    }

