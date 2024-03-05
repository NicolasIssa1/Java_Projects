import java.io.IOException;
/**
 * Program to provide information on a GPS track stored in a file.
 *
 * @author Nicolas Issa
 */
public class TrackInfo {
  public static void main(String[] args) throws IOException {
    // TODO: Implementation TrackInfo application here
    try{
      if(args.length == 0)
      {
        System.err.println("Error: The file name is not specified in the command line");
        System.exit(0);
      }
      Track trackObj = new Track(args[0]);
  
      System.out.println(trackObj.size());
      System.out.println("Lowest point is " + trackObj.lowestPoint());
      System.out.println("Highest point is " + trackObj.highestPoint());
      System.out.println("Total distance = " + String.format("%.3f km", 
      trackObj.totalDistance()/1000));
      System.out.println("Average speed = " + String.format("%.3f m/s", trackObj.averageSpeed()));
    }
    catch (IOException e){
      System.err.println("Error accessing the file: " + e.getMessage());
      System.exit(1);
    }
    catch (GPSException e){
      System.err.println("Error processing track data: " + e.getMessage());
      System.exit(1);
    }
  }
}
