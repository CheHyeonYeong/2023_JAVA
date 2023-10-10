package Week05_chy.Map;

import java.util.HashMap;
import java.util.Scanner;

public class Nation {
    public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<String, String>();
        map.put("USA", "washington");
        map.put("Japan", "Tokyo");
        map.put("China", "Veiging");
        map.put("UK", "London");
        map.put("Korea", "Seoul");

        Scanner scanner = new Scanner(System.in);

        System.out.println("국가의 이름을 입력하시오 : ");
        String center= scanner.nextLine();
        System.out.println(center+"의 수도 : "+map.get(center));

        scanner.close();
}
}
