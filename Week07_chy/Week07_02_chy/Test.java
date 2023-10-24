package Week07_chy.Week07_02_chy;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException {
        int num2;
        PrintWriter in = new PrintWriter(new FileWriter("user.txt"));

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("번호 : ");
            String num = scanner.next();
            System.out.println("이름 : ");
            String name = scanner.next();
            System.out.println("전화번호 : ");
            String tel = scanner.next();
            System.out.println("이메일 : ");
            String email = scanner.next();
            System.out.println("입력이 끝났으면 1, 계속하려면 0 : ");
           num2 = scanner.nextInt();

            user user = new user(num, name, tel, email);
            in.println(user.num+", "+user.name+", "+user.tel+", "+user.email);
            in.flush();
            if(num2==1)
                break;
        }

        //번호를 입력 받아서 그 번호에 해당되는 전화번호를 출력하는 프로그램을 작성


        BufferedReader in1 = new BufferedReader(new FileReader("user.txt"));
        String line;


        String search;
        Scanner s1 = new Scanner(System.in);
        System.out.println("번호 : ");
        search = s1.next();

        while ((line = in1.readLine()) != null) {
            String[] parts = line.split(", ");
            if (parts.length == 4 && parts[0].equals(search)) {
                System.out.println("번호: " + parts[0]);
                System.out.println("이름: " + parts[1]);
                System.out.println("전화번호: " + parts[2]);
                System.out.println("이메일: " + parts[3]);
                break; // 해당 번호를 찾으면 루프 종료
            }
        }
        in.close();

    }
}
