import java.util.Scanner;

public class Circle{

    public double pie = 3.14159;
    private double radius;
    void setRadius(double r){
        //반지름 값 얻어오기
        radius=r;
    }
    double getRadius(){
        //input 받기

        Scanner sc = new Scanner(System.in);
        System.out.println("반지름 값을 입력하시오. : ");
        radius = Double.parseDouble(sc.next());

        return radius;
    }
    double getArea(){
        double area= radius*radius*pie;
        return area;
    }
    
    public static void main(String[] args) {

        Circle c= new Circle();
        c.getRadius();
        double area1= c.getArea();
        System.out.println("The circle's area is "+area1);

        Circle c1 = new Circle();
        c.setRadius(area1);
        double area2= c.getArea();
        System.out.println("The circle's area is "+area2);
    }
}
