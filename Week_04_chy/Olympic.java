package Week_04_chy;

import javax.swing.*;
import java.awt.*;

public class Olympic extends JFrame {
    public Olympic(){
        super("오륜기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(210,150);
        setVisible(true);
    }
    class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.blue);
            g.drawOval(10,10,50,50);
            g.setColor(Color.black);
            g.drawOval(70,10,50,50);
            g.setColor(Color.red);
            g.drawOval(130,10,50,50);
            g.setColor(Color.yellow);
            g.drawOval(40,30,50,50);
            g.setColor(Color.green);
            g.drawOval(100,30,50,50);
        }
    }
    public static void main(String [] args){
        new Olympic();
    }
}
