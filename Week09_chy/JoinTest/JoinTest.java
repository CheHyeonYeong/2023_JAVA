package Week09_chy.JoinTest;
public class JoinTest extends Thread {
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(getName() + " " + i);
        }
    }

    public static void main(String args[]) {
        JoinTest t1 = new JoinTest();
        JoinTest t2 = new JoinTest();

        t1.start(); // t1 스레드 시작
        try {
            t1.join(); // t1 스레드가 종료될 때까지 대기
        } catch (InterruptedException e) {
            System.out.println(e); // InterruptedException 처리
        }

        t2.start(); // t1 스레드가 종료된 이후에 t2 스레드 시작
    }

}