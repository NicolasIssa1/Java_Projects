import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author YOUR NAME
 */
public class Track {
  private List<Point> points;
  // TODO: Create a stub for the constructor
  public Track(String filename) throws IOException{
    points = new ArrayList<>();
    readFile(filename);
  }

  // TODO: Create a stub for readFile()
  private void readFile(String filename) throws IOException{
    
  }

  // TODO: Create a stub for add()

  // TODO: Create a stub for get()

  // TODO: Create a stub for size()

  // TODO: Create a stub for lowestPoint()

  // TODO: Create a stub for highestPoint()

  // TODO: Create a stub for totalDistance()

  // TODO: Create a stub for averageSpeed()
}
