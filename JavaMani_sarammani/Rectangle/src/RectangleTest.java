
public class RectangleTest {

    static void show(Rectangle r) {
        r.show();
        System.out.print("넓이 : " + r.getArea());
        System.out.print(" , ");
        System.out.println("둘레 : " + r.getPerimeter());
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(0,0,10,5);
        RectangleTest.show(rect1);

        Point k = new Point();
        Point j = new Point();
        k.setXY(1,1);
        j.setXY(5,6);

        Rectangle rect2 = new Rectangle(k,j);
        RectangleTest.show(rect2);


        System.out.println();

        //Rectangle rect2 = new Rectangle(new Point(0,0) , new Point(5,10));
        //RectangleTest.show(rect2);
    }

}