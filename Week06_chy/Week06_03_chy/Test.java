package Week06_chy.Week06_03_chy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

enum Type{
    MEAT,FISH, OTHERS
}
public class Test {
    public static void main(String[] args) {
        List<Food> foodList = Arrays.asList(
                new Food("Salad", true, 200, Type.OTHERS),
                new Food("Beef Steak", false, 400, Type.MEAT),
                new Food("Fish", false, 250, Type.FISH),
                new Food("Carrot", true, 100, Type.OTHERS)
        );
        List<String>sublist = foodList.stream()
                .filter(food->food.getCalories()<=300 && food.getType()==Type.OTHERS)
                .map(Food::getName)
                .collect(Collectors.toList());
        System.out.println(sublist);
    }
}

