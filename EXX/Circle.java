package EXX;
import java.lang.Math;
import java.lang.Override;

public class Circle {
    private double radius;

    public Circle() {
        this(1);
    }

    public Circle(double r){
        if(r <= 0){
            throw new IllegalArgumentException("Invalid radius");
        }
        else
        {
            radius = r;
        }
    }
 
    public double getRadius(){
        return radius;
    }

    public double area(){
        return Math.PI * radius * radius;
    }

    public double perimeter(){
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString(){
        return "Circle(radius=" + String.format("%.4f", radius) + ")";
    }

    @Override
    public boolean equals(Object obj) {
      if (obj == this) {
        return true;
      }
      if (obj instanceof Circle) {
        Circle circ = (Circle) obj;
        return Math.abs(radius - circ.radius) < 0.00005;
      }
      return false;
    }
  }