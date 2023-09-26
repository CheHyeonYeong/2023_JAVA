package Week_04_chy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JLabel;

//자동차 정비 어플리케이션

public class Week04_02_chy extends JFrame {
        private int charge = 0;
        public JLabel label;

        public Week04_02_chy() {
            setTitle("수리 메뉴판");
            setSize(300, 150);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            label = new JLabel("현재까지의 가격은 " + charge + "입니다.");

            JCheckBox engineOilCheckbox = createCheckbox("엔진 오일 변환", 45000);
            JCheckBox autoTransmissionOilCheckbox = createCheckbox("자동 변속기 오일 교환", 80000);
            JCheckBox airFilterCheckbox = createCheckbox("에어컨 필터 교환", 30000);
            JCheckBox tireReplacementCheckbox = createCheckbox("타이어 교환", 100000);

            add(label);
            add(engineOilCheckbox);
            add(autoTransmissionOilCheckbox);
            add(airFilterCheckbox);
            add(tireReplacementCheckbox);

            setLayout(new GridLayout(0, 1));
            setVisible(true);
        }

        private JCheckBox createCheckbox(String Label, int price)  {
            JCheckBox checkBox = new JCheckBox(Label);
            checkBox.addItemListener(new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent e) {
                    if (checkBox.isSelected()) {
                        charge += price;
                    } else {
                        charge -= price;
                    }
                    label.setText("현재까지의 가격은 " + charge + "입니다.");
                }

            });
            return checkBox;
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Week04_02_chy();
                }
            });
        }
}