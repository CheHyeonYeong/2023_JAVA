package Week06_chy.Function;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args){
        Function<Integer,Integer>f1 = i->i*4;
        System.out.println(f1.apply(3)); //3*4=12 -> 12가 출력된다

        Function<String,Integer>f2 = s->s.length();
        //매개변수와 반환값
        System.out.println(f2.apply("Hello"));
    }
}
