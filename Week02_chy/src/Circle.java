public class Circle {
    protected int radius;
    public Circle(int r){radius =r;}
}
class Pizza extends Circle{
    String name;
    public Pizza(String name, int radius){
        super(radius);
        this.name = name;
    }
    void print(){
        System.out.println(name+" pizza is "+radius+" cm");
    }
}

class PizzaTest{
    public static void main(String[] args) {
        Pizza obj = new Pizza("Peppperoni", 20);
        obj.print();
    }

}