package Week06_chy.Week06_02_chy;

//최대 최소 평균

public class LamdaTest {

    public static final ArrayProcessing maxin = array -> {
        if (array.length == 0) return Double.NaN;
        double maxV=array[0];
        for(double value : array){
            if (value > maxV) {
                maxV = value;
            }
        }
        return maxV;
    }; //세미콜론 필요하다
    public static final ArrayProcessing minin = array -> {
        if (array.length == 0) return Double.NaN;
        double minV=array[0];
        for(double value : array){
            if (value < minV) {
                minV = value;
            }
        }
        return minV;
    };
    public static final ArrayProcessing avg = array -> {
        if (array.length == 0) return Double.NaN;
        double sum=0.0;
        for(double value : array){
            sum+=value;
        }
        return sum/array.length;
    };
    public static void main(String[] args) {
        double[] array = {1.2, 3.4, 2.0, 5.7, 0.8};

        System.out.println("Maximum value: " + maxin.apply(array));
        System.out.println("Minimum value: " + minin.apply(array));
        System.out.println("Average value: " + avg.apply(array));
    }
}
