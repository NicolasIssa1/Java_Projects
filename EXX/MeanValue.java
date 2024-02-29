package EXX;

public class MeanValue {
    public static double meanValue(double[] data) {
      double sum = 0;
      for ( int i = 0 ; i < data.length; i++){
        sum = sum + data[i];
      }
      if(data.length > 0){
        return sum / data.length;
      }
      
      else{
        return 0;
      }
    }
    public static void main(String[] args) {
      double[] numbers = new double[args.length];
        for(int i = 0;  i < args.length; i++ )
      {
        numbers[i] = Double.parseDouble(args[i]);
      }

      double mean = meanValue(numbers);

      if(numbers.length > 0){
        System.out.printf("Mean value = %.3f%n" , mean);
      }
      else{
        System.err.println("Usage: javaMeanValue <value...>");
        System.exit(1);
      }
      
    }
  }  

