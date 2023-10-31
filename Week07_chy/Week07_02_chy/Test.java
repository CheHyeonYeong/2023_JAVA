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

/*
*
* import java.io.*;
import java.util.*;

public class UserInform {
    public static void main(String[] args) throws IOException {
        int num2;
        String search;
        String num, name, tel, email;
        Scanner scan = null;
        PrintWriter in = new PrintWriter(new FileWriter("user.txt"));
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("사용자 번호를 입력하세요 ");
            num = s.next();
            System.out.println("사용자 이름을 입력하세요 ");
            name = s.next();
            System.out.println("사용자 전화번호를 입력하세요 ");
            tel = s.next();
            System.out.println("사용자 이메일을 입력하세요 ");
            email = s.next();
            System.out.println("입력이 끝났으면 1, 계속 입력하시려면 0");
            num2 = s.nextInt();
            in.print(num + "," + name + "," + tel + "," + email + "\n"); // 각 사용자 정보를 개행으로 구분
            in.flush();
            if (num2 == 1)
                break;
        }
        in.close(); // 파일 쓰기 완료 후 PrintWriter를 닫습니다.

        System.out.println("검색하실 사용자 번호를 입력하세요");
        num2 = s.nextInt();
        search = num2 + "";
        scan = new Scanner(new BufferedReader(new FileReader("user.txt")));
        scan.useDelimiter("\n"); // 각 사용자 정보를 개행으로 구분
        boolean found = false;
        PrintWriter findUserWriter = new PrintWriter(new FileWriter("find_user.txt"));
        while (scan.hasNext()) {
            String userInfo = scan.next();
            String[] userInfoParts = userInfo.split(",");
            num = userInfoParts[0];
            name = userInfoParts[1];
            tel = userInfoParts[2];
            email = userInfoParts[3];
            if (num.equals(search)) {
              //  System.out.println("사용자 번호 " + num2 + "의 전화번호는 " + tel + "입니다.");
            	found = true;
                // 검색 결과를 find_user.txt 파일에 저장
                findUserWriter.print(num + "," + name + "," + tel + "," + email + "\n");
                break; // 해당 사용자를 찾았으면 검색 종료
            }
        }
        if (!found) {
            System.out.println("사용자 번호 " + num2 + "을 찾을 수 없습니다.");
        }
        findUserWriter.close(); // find_user.txt 파일을 닫습니다.

        if (scan != null)
            scan.close();
    }
}

//한글 입력시 깨지는 문제가 발생하여, 이름 입력할때, 반드시 영문으로 입력해야 함
* */
