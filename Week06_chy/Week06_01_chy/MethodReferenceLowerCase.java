package Week06_chy.Week06_01_chy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceLowerCase {
    public static void main(String[] args) {
        List<String> listOfName = Arrays.asList(new String[]{
                "Apple", "Banana", "Cherry"
        });

        List<String>smallList = listOfName.stream()
                .map(String::toLowerCase)
                .collect(Collectors.toList());
        System.out.println(smallList);
    }
}
