package EXX;

public class CircleDemo{
    public static void main(String[] args){
        Circle myCircle = new Circle();
        Circle myCircle1 = new Circle();

        System.out.println("Radius = " + myCircle.getRadius());
        System.out.println("Perimeter = " + myCircle.perimeter());
        System.out.println("Area = " + myCircle.area());
    }
}