public class Rectangle {

    private int x1=0;
    private int y1=0;
    private int x2=0;
    private int y2=0;

    private int w,h,p,a;
    public Rectangle(){
        setting();
    }
    public Rectangle (int x1, int y1 ,int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;

        setting();
    }
    public Rectangle (Point lp, Point rp) {

        this.x1 = lp.getX();
        this.y1 = lp.getY();
        this.x2 = rp.getX();
        this.y2 = rp.getY();
        setting();
    }

    public void setting(){
        this.w = x2-x1;
        this.h = y2-y1;

        this.p = w*2+h*2;
        this.a = w*h;
    }

    public int getWidth() {
        return w;
    }

    public int getHeight() {
        return h;
    }

    public int getPerimeter() {
        return p;
    }

    public int getArea() {
        return a;
    }

    public void show() {
        System.out.println("직사각형 "+w+"x"+h+": ("+x1+","+y1+"),("+x2+","+y2+")");
    }

}