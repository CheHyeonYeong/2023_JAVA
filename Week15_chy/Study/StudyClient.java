package Week15_chy.Study;

import Week15_chy.Network.SpellCheckerClient;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class StudyClient {
    private Socket socket = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;

    public StudyClient() { }
    public void run() {
        System.out.println("Study 클라이언트입니다.");
        setupConnection();  //서버로 계속 전송
        System.out.println("Study 서버에 접속하였습니다.");

        Scanner scanner = new Scanner(System.in);
        String word;
        while(true) {
            try {
                //스레드 형식으로 우다다.
                System.out.print("단어 >> ");
                word = scanner.next(); // 단어 읽기
                if(word.equals("quit")) {
                    System.out.println("프로그램을 종료합니다...");
                    break;
                }
                out.write(word + "\n");
                out.flush();

                String result = in.readLine();
                System.out.println(result);

            } catch (IOException e1) {
                System.out.println("서버로부터 연결이 종료되었습니다...");
                break;
            }
        }
        scanner.close();
    }

    public void setupConnection() {
        //클라이언트가 서버에 연결될 수 있도록 Socket 및 입출력 스트림을 설정합니다.
        try {
            socket = new Socket("localhost", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        StudyClient StudyClient = new StudyClient();
        StudyClient.run();
    }



}
