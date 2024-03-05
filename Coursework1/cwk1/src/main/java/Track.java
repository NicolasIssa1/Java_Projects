import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;


/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author Nicolas Issa
 */

public class Track {
  //Field to store a sequence of point objects :
  private List<Point> points;

  // Constructor to initialize the Track object with an empty list of objects. 
  public Track(){
    this.points = new ArrayList<>();
  }

  public Track(String filename) throws IOException {
    this.points = new ArrayList<Point>();
    // finally readFile within the consteuctor by calling it
    readFile(filename);
  }

  // TODO: Create a stub for readFile()
  public void readFile(String filename) throws IOException {
    //and this is to initialize the list of point objects
    this.points = new ArrayList<Point>();
    //i start by creating a new file for the given filenam
    File file = new File(filename);

    //now to read the file line by line, : 
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(file);
    String line = scanner.nextLine();
    
    while(scanner.hasNextLine())
    {
      line = scanner.nextLine();

      String[] parts = line.split(",");

      //i then check if the line has exactly four parts required for the details of the Point.
      if(parts.length != 4)
      {
        throw new GPSException("Invalid line format: " + line);
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
  }

  // TODO: Create a stub for add()
  public void add(Point point){
    //adding the Point object to the points list. 
    points.add(point);
  }

  // TODO: Create a stub for get()
  public Point get(int index){
    if(index < 0 || index >= points.size()){
      throw new GPSException("Index " + index + " out of bounds for Track size" + points.size());
    }
    return points.get(index);
  }

  // TODO: Create a stub for size()
  public int size(){
    //this is the current number of points in the track
    return points.size();
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint(){
    if(points.size() < 1){
      throw new GPSException("Not enough points to find the lowest points.");
    }

    double maxValue = Integer.MAX_VALUE;
    Point lowestPoint = null;

    for(Point point : points){
      if(point.getElevation() < maxValue){
        maxValue = point.getElevation();
        lowestPoint = point;
      }
    }
    return lowestPoint;
  }

  // TODO: Create a stub for highestPoint()
  public Point highestPoint(){
    if(points.size() < 1){
      throw new GPSException("Not enough points to find the highest point. ");
    }

    double minValue = Integer.MIN_VALUE;
    Point highesPoint = null;

    for(Point point : points){
      if(point.getElevation() > minValue){
        minValue = point.getElevation();
        highesPoint = point;
      }
    }
    return highesPoint;
  }

  // TODO: Create a stub for totalDistance()
  public double totalDistance(){
    if(points.size() < 2){
      throw new GPSException("Not enough points to calculcate distance.");
    }
    double totalDistance = 0;
    //I start from the second points since we need to compare each points to the previous one.
    for(int i = 1; i < points.size(); i++){
      Point current = points.get(i);
      Point previous = points.get(i - 1);
      totalDistance += Point.greatCircleDistance(previous, current);
    }
    return totalDistance;
  }

  // TODO: Create a stub for averageSpeed()
  public double averageSpeed(){
    if(points.size() < 2){
      throw new GPSException("Not enough points to calculate average speed");
    }

    double totalDistance = totalDistance();
    ZonedDateTime startTime = points.get(0).getTime();
    ZonedDateTime endTime = points.get(points.size() - 1).getTime();

    long totalSeconds = ChronoUnit.SECONDS.between(startTime, endTime);

    if(totalSeconds == 0){
      throw new GPSException("Start time and end time are the same. Cannot calculate speed.");
    }

    return totalDistance / totalSeconds;
  }
}
