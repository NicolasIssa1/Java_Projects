import java.util.Scanner;

public class miles_to_km {
    public static void main(String[] args) {
        Scanner myDist = new Scanner(System.in);
        System.out.println("Enter a distance in miles: ");

        float userDistance = myDist.nextFloat();
        float distanceInKilometers = userDistance * 1.60934f;
        System.out.printf("Distance in kilometres is: %f", distanceInKilometers);
        myDist.close();
    }
    
}
