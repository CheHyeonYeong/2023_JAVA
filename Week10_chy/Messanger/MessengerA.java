package Week10_chy.Messanger;

import MiddleTest.chy_01.MyFrame;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MessengerA {
    protected JTextField textField;
    protected JTextArea textArea;
    DatagramSocket socket;
    DatagramPacket packet;
    InetAddress address = null;
    final int myPort = 5000;
    final int otherPort = 6000;

    public MessengerA() throws IOException{
        MyFrame f = new MyFrame();
        address = InetAddress.getByName("127.0.0.1");
        socket = new DatagramSocket(myPort);
    }
    public void process(){
        while(true){
            try{
                byte[] buf = new byte[256];
                packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                textArea.append("RECIEVED:"+new String(buf)+"\n");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
