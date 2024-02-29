package EXX;
import java.util.Scanner;
import java.lang.Math;


public class Spheroid {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter value a: ");

        Double equatorial = input.nextDouble();

        if(equatorial <= 0)
        {
            System.out.println("Error: equatorial radius must be largent than 0");
            System.exit(1);

        }

        System.out.println("enter value b:");
        Double polar = input.nextDouble();

        if(polar <= 0)
        {
            System.out.println("Error: polar radius must be largent than 0");
            System.exit(1);
        }

        if(polar > equatorial)
        {
            System.out.println("Error: equatorial radius must be largent than polar radius");
            System.exit(1);
        }

        Double eccentricity = Math.sqrt((1-(polar*polar)/(equatorial*equatorial)));

        Double volume = (((4*Math.PI*equatorial*equatorial*polar))/3);

        System.out.printf("The eccentricity of the spheroid is : %.3f\n " , eccentricity);
        System.out.printf("Volume of the spheroid is : %g\n " , volume);

        input.close();


        
    }
}
