package Week05_chy.HashSet;
import java.util.HashSet;

public class HashSetTest {
    public static void main(String[] args){
        HashSet<String> HashSet = new HashSet<String>();
        HashSet.add("ccc");
        HashSet.add("zzz");
        HashSet.add("aaa");
        HashSet.add("bbb");
        HashSet.add("ddd");
        HashSet.add("ccc");

        System.out.println(HashSet);

    }
}
