
public class Rectangle {
    Point lt = new Point();
    Point rb = new Point();

    private int x1;
    private int y1;
    private int x2;
    private int y2;



    public Rectangle (int x1, int y1 ,int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
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
        p = w+w+h+h;
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