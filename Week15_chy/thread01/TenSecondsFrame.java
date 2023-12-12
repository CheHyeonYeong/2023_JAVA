package Week15_chy.thread01;

import javax.swing.*;
import java.awt.*;

public class TenSecondsFrame extends JFrame{
    public TenSecondsFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,150);
        setVisible(true);
        TenSecondsThread th = new TenSecondsThread();
        th.start();
    }
    class TenSecondsThread extends Thread{
        @Override
        public void run(){
            System.out.println("실행시작");
            getContentPane().setBackground(Color.yellow);

            //10초 뒤에 자동 종료
            try {
                Thread.sleep(10000);
            }
            catch(InterruptedException e) { return; }
            System.out.println("실행 종료");
            getContentPane().setBackground(Color.BLUE);


        }
    }

    public static void main(String[] args) {
        new TenSecondsFrame();
    }
}
