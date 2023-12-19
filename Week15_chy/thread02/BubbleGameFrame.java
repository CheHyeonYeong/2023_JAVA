package Week15_chy.thread02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BubbleGameFrame extends JFrame {
    public BubbleGameFrame() {
        setTitle("버블 게임"); // 프레임 제목 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GamePanel p = new GamePanel();  //실제 동작하는 곳 -> class로 둬서 만듦
        setContentPane(p);
        setSize(300, 300); // 프레임 크기 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        new BubbleGameFrame();
    }
}

class GamePanel extends JPanel {
    public GamePanel() {
        setLayout(null);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                new BubbleThread(e.getX(), e.getY()).start(); // 마우스 클릭 시 버블 스레드 시작
            }
        });
    }

    class BubbleThread extends Thread {
        private JLabel bubble;
        private static final int BUBBLE_MOVE = 2; // 버블 이동 속도 상수 (조절 가능)

        public BubbleThread(int bubbleX, int bubbleY) {
            ImageIcon img = new ImageIcon("bubble.jpg"); // 이미지 아이콘 생성
            bubble = new JLabel(img);
            bubble.setSize(img.getIconWidth(), img.getIconHeight());
            bubble.setLocation(bubbleX, bubbleY);
            add(bubble);
            repaint();
        }

        @Override
        public void run() {
            while (true) {
                int y = bubble.getY();

                bubble.setLocation(bubble.getX(), y - BUBBLE_MOVE);

                if (bubble.getY() + bubble.getHeight() < 0) {
                    remove(bubble); // 화면을 벗어난 버블 제거
                    break; // 루프 종료
                }

                try {
                    Thread.sleep(20); // 20밀리초 동안 대기
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
