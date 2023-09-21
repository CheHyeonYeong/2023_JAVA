package Week_03;

import javax.swing.*;
import java.awt.*;

//마일을 입력하고 변환 버튼을 누르면 마일이 킬로미터에 변환되어 표시되는 프로그램
//k=t*1.609344
public class Week03_02 extends JFrame {
    public Week03_02(){
        //1. 프레임 만들기 -> 생략 가능
        JFrame f = new JFrame("mile to km");

        //2. 판넬 만들기
        JPanel p = new JPanel();
        f.add(p);

        //3. UI 만들기
        //여기에서는 라벨(마일을 입력하시오) -> 텍스트 필드 -> 라벨-> 버튼

        JLabel mile = new JLabel("Plz enter the Mile");
        JTextField Emile = new JTextField(15);

        JLabel km = new JLabel("");//km변환 값
        JButton change = new JButton("Change");

        //4. 추가하기
        p.add(mile);
        p.add(Emile);
        p.add(km);
        p.add(change);

        //5. 이벤트 만들기
        //이번엔 람다식으로 만들고 싶어
        change.addActionListener(e->{
            //try-catch 로 해보자
            try {
                // 예외가 발생할 수 있는 코드
                double m = Double.parseDouble(Emile.getText());
                double k=m*1.609344;
                km.setText("->"+k);

            } catch (NumberFormatException ex) {
                // 예외가 발생했을 때의 처리
                km.setText("->0");
            }
        });
        

        //6. frame에 이것저것 하기

        f.setTitle("mile->km");
        f.setSize(500,100);
        f.setVisible(true);

    }
    public static void main(String[] args){
        Week03_02 f = new Week03_02();
    }
}
