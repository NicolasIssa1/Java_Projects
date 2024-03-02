package EXX;

public class CircleDemo{
    public static void main(String[] args){
        double radius = 4.5;

        Circle myCircle = new Circle(radius);

        System.out.println("Radius = " + myCircle.getRadius());
        System.out.println("Perimeter = " + myCircle.perimeter());
        System.out.println("Area = " + myCircle.area());
    }
}