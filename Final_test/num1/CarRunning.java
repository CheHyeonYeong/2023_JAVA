package Final_test.num1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CarRunning extends JFrame{
    public CarRunning(){
        setTitle("자동차 달리기"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //실제 동작하는 곳 -> class로 둬서 만듦
        GamePanel p = new GamePanel();
        setContentPane(p);

        setSize(800, 300); // 프레임 크기 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        new CarRunning();
    }

}

class GamePanel extends JPanel {

    JLabel race;
    public GamePanel() {


        //선 그리기
        /*setLayout(null);

        //결승선 그리기
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(600, 20, 600, 300);
        */

        ImageIcon img = new ImageIcon("race.gif"); // 결승선 위치에 그림 고정
        race = new JLabel(img);
        race.setSize(img.getIconWidth(), img.getIconHeight());
        race.setLocation(600, 20);
        add(race);

        new CarThread().start(); //바로 시작
    }


    class CarThread extends Thread {
        private JLabel car1,car2,car3,snow4,snow5;
        public CarThread() {

            ImageIcon img1 = new ImageIcon("car1.gif"); // 이미지 아이콘 생성
            ImageIcon img2 = new ImageIcon("car2.gif"); // 이미지 아이콘 생성
            ImageIcon img3 = new ImageIcon("car3.gif"); // 이미지 아이콘 생성
            ImageIcon img4 = new ImageIcon("snow.jpg"); // 이미지 아이콘 생성
            ImageIcon img5 = new ImageIcon("snowman.jpg"); // 이미지 아이콘 생성

            car1 = new JLabel(img1);
            car2 = new JLabel(img2);
            car3 = new JLabel(img3);
            snow4 = new JLabel(img4);
            snow5 = new JLabel(img5);


            car1.setSize(img1.getIconWidth(), img1.getIconHeight());
            car2.setSize(img2.getIconWidth(), img1.getIconHeight());
            car3.setSize(img3.getIconWidth(), img1.getIconHeight());
            snow4.setSize(img4.getIconWidth(), img1.getIconHeight());
            snow5.setSize(img5.getIconWidth(), img1.getIconHeight());



            car1.setLocation(600, 20);
            car2.setLocation(600, 30);
            car3.setLocation(600, 40);
            snow4.setLocation(600, 50);
            snow5.setLocation(600, 60);

            add(car1);
            add(car2);
            add(car3);
            add(snow4);
            add(snow5);


            repaint();
        }

        @Override
        public void run() {
            while (true) {
                int MOVE = (int)((Math.random()*10000)%10); // 이동 속도 상수 (조절 가능)
                int MOVE1 = (int)((Math.random()*10000)%10); // 이동 속도 상수 (조절 가능)
                int MOVE2 = (int)((Math.random()*10000)%10); // 이동 속도 상수 (조절 가능)
                int MOVE3 = (int)((Math.random()*10000)%10); // 이동 속도 상수 (조절 가능)
                int MOVE4 = (int)((Math.random()*10000)%10); // 이동 속도 상수 (조절 가능)

                int x = car1.getX();
                int x1 = car2.getX();
                int x2 = car3.getX();
                int x3 = snow4.getX();
                int x4 = snow5.getX();

                car1.setLocation(x-MOVE, car1.getY());
                car2.setLocation(x1-MOVE1, car1.getY());
                car3.setLocation(x2-MOVE2, car1.getY());
                snow4.setLocation(x3-MOVE3, car1.getY());
                snow5.setLocation(x4-MOVE4, car1.getY());

                if(car1.getX()<0){
                    System.out.println(car1);
                    break;
                }
                else if(car2.getX()<0){
                    System.out.println(car2);
                    break;
                }
                else if(car3.getX()<0){
                    System.out.println(car3);
                    break;
                }
                else if(snow4.getX()<0){
                    System.out.println(snow4);
                    break;
                }
                else{
                    System.out.println(snow5);
                    break;
                }
/*
                try { //0.1초마다 한 번씩!!!
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }
}
