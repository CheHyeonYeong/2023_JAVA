package MiddleTest.chy_01;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;

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
     * Launch the application.
     */
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
        lblNewLabel_4.setFont(new Font(" ",Font.PLAIN, 16));
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

        btnNewButton_1.addActionListener(e->{
            //취소하면 끝

        });

        btnNewButton.addActionListener(e->{
            name = textField.getText();
            num = textField_1.getText();
            score = textField_2.getText();

            System.out.println("이름 : "+name+" 학번 : "+num+" 성적 : "+score); ;

        });
    }
}



/*
public class MyFrame extends JFrame {
    private JPanel contentPane;
    private JTextField textField;//이름
    private JTextField textField_1;//출력
    private JTextField textField_2;//성적
    private JTextField textField_3;//학번


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
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

    public MyFrame() {//인자없는 생성자
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 377, 154);
        contentPane = new JPanel();

        setContentPane(contentPane);
        contentPane.setLayout(null);

        //이름
        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(61,13,57,15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(170,10,97,21);
        contentPane.add(textField);
        textField.setColumns(10);

        //학번
        JLabel lblNewLabel1 = new JLabel("학번");
        lblNewLabel.setBounds(61,38,57,15);
        contentPane.add(lblNewLabel1);

        textField_3 = new JTextField();
        textField_3.setBounds(170,36,97,21);
        contentPane.add(textField_3);
        textField_3.setColumns(10);

        //성적

        JLabel lblNewLabel2 = new JLabel("성적");
        lblNewLabel.setBounds(61,58,57,15);
        contentPane.add(lblNewLabel2);

        textField_2 = new JTextField();
        textField_2.setBounds(170,55,97,21);
        contentPane.add(textField_2);
        textField_2.setColumns(10);


        JButton btnNewButton = new JButton("등록하기");

        btnNewButton.setBounds(61,78,97,23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("취소");
        btnNewButton_1.setBounds(170,78,97,23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("이름 학번 성적") ;
        lblNewLabel_1.setBounds(61,100,122,15);
        contentPane.add(lblNewLabel_1);

        textField_1 =new JTextField();
        textField_1.setBounds(170,100,97,21);
        textField_1.setColumns(10);


    }

}

*/