package EXX;
import java.util.Scanner;

public class Weight {
    public static void main(String[] args){
        Scanner myWeight = new Scanner(System.in);
        System.out.println("Enter a weight in kilograms : ");

        double userWeight = myWeight.nextDouble();
        double WeightInLbs = userWeight * 2.205;


        System.out.printf("Weights in pounds: %d lb %.1f oz ", (int)(WeightInLbs), ((WeightInLbs)-(int)WeightInLbs)*16);
        myWeight.close();

    }
    
}
