

//문제 1 : RectangleTest에서 Point, Point를 호출하여 초기값을 부르는 방법은 알겠는데... 이걸 Rectangle에서 어떻게 정의해놓아야하는지 모르겠어요
public class Rectangle {

    private int x1=0;
    private int y1=0;
    private int x2=0;
    private int y2=0;


    Point lt = new Point();
    Point rb = new Point();
    public Rectangle (int x1, int y1 ,int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    public Rectangle (Point k, Point j) {
        this.x1 = k.getX();
        this.y1 = k.getY();
        this.x2 = j.getX();
        this.y2 = j.getY();
    }

    private int w,h,p,a;
    /* 방법이 몇가지가 있냐
     * 1. x2 -x1
     * 2. rb.getX() - lt.getX()
     * 3. this.x2- this.x2
     * 일단 밑에는 x1,x2로 먹힌다 .. 이건 private 인데도 먹혀 왜냐면 public 처리 해줬고 .. this그럼*/

    public int getWidth() {
        w = x2-x1;
        return w;
    }

    public int getHeight() {
        h = this.y2 - this.y1;
        return h;
    }

    public int getPerimeter() {
        p = w*2+h*2;
        return p;
    }

    public int getArea() {
        a = w*h;
        return a;
    }

    public void show() {
        System.out.println("직사각형 "+w+"x"+h+": ("+x1+","+y1+"),("+x2+","+y2+")");
    }

}