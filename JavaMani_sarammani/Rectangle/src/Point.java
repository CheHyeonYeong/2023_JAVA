public class Point {
    private int x,y;

    //객체 생성 초기화 하는 방법 생성자 사용?
    void setX(int x){
        this.x=x;
    }
    void setY(int y){
        this.y=y;
    }
    void setXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    int getX() {
        return x;
    }

    int getY() {

        return y;
    }

    void show() {
        System.out.println("("+x+", "+y+")");
    }
}
