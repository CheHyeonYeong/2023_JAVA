package Week10_chy.TCPserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        ServerSocket severSocket = null;
        Socket clientSocket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        Scanner sc = new Scanner(System.in);

        try{
            severSocket = new ServerSocket(5000);
            System.out.println("연결을 기다리고 있습니다");
            clientSocket = severSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream());
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("클라이언트와 연결 성공");
            while (true){
                String msg = in.readLine();
                if(msg.equalsIgnoreCase("quit")){
                    System.out.println("클라이언트에서 연결을 종료하였습니다");
                    break;
                }
                System.out.println("클라이언트가 보낸 문자열"+msg);
                System.out.println("클라이언트로 보낼 문자열을 입력하고 엔터키를 치세요");
                String omsg = sc.nextLine();
                out.write(omsg+"\n");
                out.flush();
            }
            out.close();
            clientSocket.close();
            severSocket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
