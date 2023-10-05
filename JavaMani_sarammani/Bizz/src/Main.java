public class Main {
    public static void main(String[] args) {
        Child 어린이1 = new Child(15);
        Child 어린이2 = new Child(9);

        어린이1.you(어린이2);
        어린이2.you(어린이1);

        // 1차 게임
        어린이1.lose(2);
        System.out.println("1차 게임 결과\n" + 어린이1.show()+" 어린이 2 : "+어린이2.show());

        // 2차 게임
        어린이2.lose(7);
        System.out.println("2차 게임 결과\n" + 어린이2.show());

        // 3차 게임
        어린이2.lose(15);
        System.out.println("3차 게임 결과\n" + 어린이1.show());
    }

}