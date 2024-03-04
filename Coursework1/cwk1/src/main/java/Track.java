import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.time.format.DateTimeParseException;
import java.time.ZonedDateTime;

/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author Nicolas Issa
 */

public class Track {
  //Field to store a sequence of point objects :
  private List<Point> points = new ArrayList<>();

  // TODO: Create a stub for the constructor
  public Track(){
  }

  public Track(String filename){
    //and this is to initialize the list of point objects
    this.points = new ArrayList<>();
    // finally readFile within the consteuctor by calling it
    try{
      readFile(filename);
    }
    catch(IOException e){
      System.err.println("Error reading file: " + e.getMessage());
    }
  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) throws IOException {
    try
    {

      //i start by creating a new file for the given filename
      File file = new File(filename);

      //now to read the file line by line, : 
      Scanner scanner = new Scanner(file);

      while(scanner.hasNextLine())
      {
        String line = scanner.nextLine();

        //printing just to test
        System.out.println(line);

        String[] parts = line.split(",");

        //i then check if the line has exactly four parts required for the details of the Point.
        if(parts.length != 4)
        {
          throw new IOException("Invalid line format: " + line);
        }

      //I then parse the timestamp part of the line as a ZonedDateTime
      ZonedDateTime timestamp = ZonedDateTime.parse(parts[0]);
      //same for the longitude but as a double
      double longitude = Double.parseDouble(parts[1]);
      //same for the latitude as a double
      double latitude = Double.parseDouble(parts[2]);
      //Finally arse the elevation part of the line as a double
      double elevation = Double.parseDouble(parts[3]);

      //Create a new Point object with the parsed values
      Point point = new Point(timestamp, longitude, latitude, elevation);
      //and add it to the list of points
      points.add(point);
      }
      scanner.close();
    }
    catch (IOException | NumberFormatException | DateTimeParseException e)
    {
      //I throw an IOException if an error occurs during parsing
      throw new IOException("Error reading file: " + filename, e);
    }
  }

  // TODO: Create a stub for add()
  public void add(Point point){
  }

  // TODO: Create a stub for get()
  public Point get(int index){
    return null;
  }

  // TODO: Create a stub for size()
  public int size(){
    //this is the current number of points in the track
    return points.size();
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint(){
    return null;
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint(){
    return null;
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance(){
    return 0;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed(){
    return 0;
  }
}
