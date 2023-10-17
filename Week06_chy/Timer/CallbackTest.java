package Week06_chy.Timer;
import javax.swing.Timer;

public class CallbackTest {
    public static void main(String[] args){
        Timer t = new Timer(1000, e->System.out.println("Beep"));
        //람다식으로 쓰면 가능하다~
        t.start();
        for(int i=0;i<1000;i++){
            try{Thread.sleep(1000);}
                catch(InterruptedException e){

                }
        }
    }
}
