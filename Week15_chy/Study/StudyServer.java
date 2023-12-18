package Week15_chy.Study;


import Week15_chy.Network.SpellCheckerServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class StudyServer {
    private StudyServer StudyServer;

    public StudyServer() { }
    public void run(){
        System.out.println("Study 서버입니다.");
        new ServerThread().start(); // 서비스 시작
    }

    class ServerThread extends Thread {
        // 클라이언트의 접속을 받는 서버 스레드
        @Override
        public void run() {
            ServerSocket listener = null;
            Socket socket = null;
            try {
                listener = new ServerSocket(5000);
                while(true) {
                    socket = listener.accept();
                    System.out.println("클라이언트 연결됨");
                    new ServiceThread(socket).start(); // 접속한 클라이언트를 전담하여 서비스하는 스레드 생성
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(listener != null)
                    listener.close();
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    class ServiceThread extends Thread{
        //`ServiceThread` 클래스는 각 클라이언트를 전담하여 단어를 수신하고 스펠링을 체크한 결과를 전송하는 역할을 합니다.
        //클라이언트로부터 단어를 수신하고, `SpellChecker` 클래스를 이용하여 스펠링을 체크한 후 결과를 클라이언트에게 전송합니다.

        private Socket socket = null;
        private BufferedReader in = null;
        private BufferedWriter out = null;
        public ServiceThread(Socket socket) { // 클라이언트와 통신할 소켓을 전달받음
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            while(true) {
                try {
                    String word = in.readLine(); // 단어 수신
                    //실제 로직이 들어갈 곳
                    out.flush();
                } catch (IOException e) {
                    System.out.println("클라이언트 연결 종료");
                    try {
                        socket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    return; // 스레드 종료
                }
            }
        }
    }

    class readDB{
        //실제 로직이 들어갈 곳

    }
    public static void main(String[] args) {
        StudyServer studyServer = new StudyServer();
        studyServer.run();
    }
}