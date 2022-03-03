abstract class Shape {

    abstract double getArea();

}

 class Rectangle extends Shape{
    double h, w;

    public Rectangle(double h, double w){

        this.h = h;
        this.w = w;
    }

    public double getArea(){
        return h*w;
    }
}

class Circle extends Shape{
    double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * Math.sqrt(radius);
    }
}

class Triangle extends Shape{
    double b, h;

    public Triangle(double b, double h){
        this.b = b;
        this.h = h;
    }

    public double getArea(){
        return (b*h)/2;
    }


}

public class ShapeT{
    public static void main(String args[]){

    //USAGE
    //Without polymorphism
    Triangle t = new Triangle(3, 2);
    Circle c = new Circle(3);
    Rectangle r = new Rectangle(2,3);

    System.out.println(t.getArea());
    System.out.println(c.getArea());
    System.out.println(r.getArea());

    //USAGE with Polymorphism
	Shape s[] = new Shape[3];
    s[0] = new Triangle(3, 2);
    s[1] = new Circle(3);;
    s[2] = new Rectangle(2,3);

	  for(int i=0;i<s.length;i++){
        System.out.println(s[i].getArea());
    }

    }
}
