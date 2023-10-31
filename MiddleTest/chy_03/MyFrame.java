package MiddleTest.chy_03;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MyFrame extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JButton btnNewButton;
    private JButton btnNewButton_1;
    String name, num, score;


    /**
     * Create the frame.
     */
    public MyFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(100, 100, 450, 237);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(36, 45, 151, 15);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("학번");
        lblNewLabel_2.setBounds(36, 95, 113, 15);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("성적");
        lblNewLabel_3.setBounds(36, 120, 57, 15);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("학생 등록하기");
        lblNewLabel_4.setFont(new Font(" ", Font.PLAIN, 16));
        lblNewLabel_4.setBounds(152, 10, 151, 25);
        contentPane.add(lblNewLabel_4);

        textField = new JTextField();
        textField.setBounds(187, 45, 116, 21);
        contentPane.add(textField);
        textField.setColumns(10); //이름 텍스트필드

        textField_1 = new JTextField();
        textField_1.setBounds(187, 95, 116, 21);
        contentPane.add(textField_1);
        textField_1.setColumns(10); //학번 텍스트필드

        textField_2 = new JTextField();
        textField_2.setBounds(187, 120, 116, 21);
        contentPane.add(textField_2);
        textField_2.setColumns(10); //성적 텍스트필드


        btnNewButton = new JButton("등록하기");
        btnNewButton.setBounds(90, 165, 97, 23);
        contentPane.add(btnNewButton);

        btnNewButton_1 = new JButton("취소");
        btnNewButton_1.setBounds(206, 165, 97, 23);
        contentPane.add(btnNewButton_1);

        btnNewButton_1.addActionListener(e -> {
            //취소하면 끝

        });

        btnNewButton.addActionListener(e -> {
            name = textField.getText();
            num = textField_1.getText();
            score = textField_2.getText();
            Student student =new Student();
            student.setName(name);
            student.setNum(num);
            student.setScore(score);

        });
    }
}
