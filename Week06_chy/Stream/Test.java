package Week06_chy.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args ){
        List<String> list = Arrays.asList("Kim", "Park", "Lee", "Choi", "Chee");
        List<String >sublist = list.stream()
                .filter(s->s.startsWith("C"))
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sublist);
    }
}
