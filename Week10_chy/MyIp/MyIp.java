package Week10_chy.MyIp;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIp {
    public static void main(String[] args) {
        try{
            InetAddress local = InetAddress.getLocalHost();
            System.out.println("내 컴퓨터 IP 주소 : "+ local.getHostAddress());
        }catch (UnknownHostException e){
            e.printStackTrace();
            //아니 왜 전 것으로 자꾸!!!!!
        }
    }
}

