public class Rectangle {
    Point lt;
    Point rb;

    public Rectangle(){

    }
    public Rectangle (int x1, int y1 ,int x2, int y2) {
        lt = new Point(x1,y1);
        rb=new Point(x2, y2);
    }
    public Rectangle (Point lp, Point rp) {
        this.lt=lp;
        this.rb=rp;
    }

    public int getWidth() {
        int width = rb.getX()-lt.getX();
        return width;
    }

    public int getHeight() {
        int height =rb.getY()-lt.getY();
        return height;
    }

    public int getPerimeter() {
        int perimeter = 2*(getWidth()+getHeight());
        return perimeter;
    }
    public int getArea() {
        int Area = getHeight()*getWidth();
        return Area;
    }
    public void show() {
        System.out.println("직사각형 "+getArea()+"x"+getPerimeter()+": ("+lt.getX()+","+lt.getY()+"),("+rb.getX()+","+rb.getY()+")");
    }

}