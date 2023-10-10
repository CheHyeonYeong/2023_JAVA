package Week05_chy.Week05_02;

public class ContainerEx {
    public static void main(String[] args) {
        Week05_02<String, String> c1 = new Week05_02<String, String>();
        c1.set("홍길동", "도적");
        String name1 = c1.getKey();
        String job = c1.getValue();


        Week05_02<String, Integer> c2 = new Week05_02<String, Integer>();
        c2.set("홍길동", 35);
        String name2 = c2.getKey();
        int age = c2.getValue();

    }
}
