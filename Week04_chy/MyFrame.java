package Week04_chy;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

//성적 입력 Frame 만들기

public class MyFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    ArrayList<Integer> list = new ArrayList<> ();

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyFrame frame = new MyFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 154); //X좌표, Y좌표, 가로(폭), 세로(높이)
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("성적");
        lblNewLabel.setBounds(61, 13, 57, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(170, 10, 97, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel addtxt = new JLabel("");
        addtxt.setBounds(61, 100, 200, 21);
        contentPane.add(addtxt);

        JButton btnNewButton = new JButton("입력");
        btnNewButton.addActionListener(e->{
            list.add(Integer.parseInt(textField.getText()));

            addtxt.setText("현재 입력 값은 "+textField.getText()+", "+list.size()+"명 째 입력중입니다.");
        });

        btnNewButton.setBounds(61, 38, 97, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("평균계산");
        btnNewButton_1.setBounds(170, 38, 97, 23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("모든 학생의 평균 ");
        lblNewLabel_1.setBounds(61, 80, 122, 15);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(170, 77, 97, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10);
        btnNewButton_1.addActionListener(e->{
            int sum=0;
            for(int s:list) {
                sum += s;
            }
            textField_1.setText(""+(sum/list.size()));
            addtxt.setText("");
        });
    }

}