package Week05_chy.Week05_01;

public class ContainerEx {
    public static void main(String[] args) {
        Week05_01<String> c = new Week05_01<String>();
        c.setT("홍길동");
        String str = c.getT();

        Week05_01<Integer> c2 = new Week05_01<Integer>();
        c2.setT(6);
        int value = c2.getT();

    }
}
