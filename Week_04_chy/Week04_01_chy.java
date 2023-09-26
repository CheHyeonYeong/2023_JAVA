package Week_04_chy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class Week04_01_chy {
    String name;
    String tel;
    String address;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getTel(){
        return tel;
    }
    public void setTel(String tel){
        this.tel = tel;
    }
    public String getAddress(){
        return address;
    }public void setAddress(String address){
        this.address = address;
    }
    public Week04_01_chy(String name, String tel, String address){
        //person
        super();
        this.name = name;
        this.tel = tel;
        this.address = address;

    }
    public static void main(String[] args){
        //Event
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try{
                    TelNumber frame = new TelNumber();
                    frame.setVisible(true);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
    public static class TelNumber extends JFrame{
        ArrayList<Week04_01_chy> list = new ArrayList<>();
        private JPanel contentpane;
        private JTextField textField;
        private JTextField textField_1;


        public TelNumber(){
            setTitle("Addrss Book");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100,100,360,252);
            contentpane = new JPanel();
            contentpane.setBorder( new EmptyBorder(5,5,5,5));
            setContentPane(contentpane);
            contentpane.setLayout(null);

            JLabel Name = new JLabel("이름");
            Name.setBounds(12,10,57,15);
            contentpane.add(Name);

            JLabel tel = new JLabel("전화번호");
            tel.setBounds(12,42,57,15);
            contentpane.add(tel);

            JLabel address = new JLabel("주소");
            address.setBounds(12,79,57,15);
            contentpane.add(address);

            textField = new JTextField();
            textField.setBounds(81,7,243,21);
            contentpane.add(textField);
            textField.setColumns(10);

            textField_1 = new JTextField();
            textField_1.setBounds(81,39,243,21);
            textField_1.setColumns(10);
            contentpane.add(textField_1);

            JTextArea textArea = new JTextArea();
            textArea.setBounds(12,104,312,67);
            contentpane.add(textArea);

            JButton save = new JButton("저장");
            save.setBounds(12,181,97,23);
            contentpane.add(save);

            save.addActionListener(e->{
                String name = textField.getText();
                String Tel = textField_1.getText();
                String Address = textArea.getText();
                list.add(new Week04_01_chy(name, Tel, Address));
            });

            JButton search = new JButton("검색");
            search.setBounds(117,181,97,23);
            contentpane.add(search);
            search.addActionListener(e->{
                String name = textField.getText();
                String Tel = textField_1.getText();
                String Address = textArea.getText();
                for (Week04_01_chy p : list){
                    if(name!=null){
                        if(p.getName().equals(name)){
                            textField_1.setText(p.getTel());
                            textArea.setText(p.getAddress());
                        }
                    }
                    if(Tel!=null){
                        if(p.getTel().equals(Tel)){
                            textField.setText(p.getName());
                            textArea.setText(p.getAddress());
                        }
                    }
                    if(Address!=null){
                        if(p.getAddress().equals(Address)){
                            textField.setText(p.getName());
                            textField_1.setText(p.getTel());
                        }
                    }

                }
            });

            JButton exit = new JButton("종료");
            exit.setBounds(227,181,97,23);
            contentpane.add(exit);
            exit.addActionListener(e->{
                System.exit(0);
            });

        }

    }


}
