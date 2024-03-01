import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Paths;
import java.time.ZonedDateTime;
import java.nio.file.Files;

/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author Nicolas Issa
 */
public class Track {
  private List<Point> points;

  // TODO: Create a stub for the constructor
  public Track(String filename) throws IOException{
    points = new ArrayList<>();
    try {
      readFile(filename);
    } catch (IOException e){
      //I handle any ioexceptions here
      System.err.println("Error reading from file: " + e.getMessage());
    }
  }

  // TODO: Create a stub for readFile()
  private void readFile(String filename) throws IOException{
    //Start by reading all the lines feom the file.
    List<String> lines = Files.readAllLines(Paths.get(filename));
    for (String line : lines){
      String[] data = line.split(",");
      ZonedDateTime timestamp = ZonedDateTime.parse(data[0]);
      double longitude = Double.parseDouble(data[1]);
      double latitude = Double.parseDouble(data[2]);
      double elevation = Double.parseDouble(data[3]);

      // I then create a new Point object to add it to the list
      Point point = new Point(timestamp, longitude, latitude, elevation);
      points.add(point);
    }
    
  }

  // TODO: Create a stub for add()
  public void add(Point point){
    points.add(point);
  }

  // TODO: Create a stub for get()
  public Point get(int index){
    return points.get(index);
  }

  // TODO: Create a stub for size()
  public int size(){
    return points.size();
  }

  // TODO: Create a stub for lowestPoint()
  public Point lowestPoint(){
    if (points.isEmpty()){
      return null;
    }

    Point lowest = points.get(0);
    for (Point point : points){
      if (point.getElevation() < lowest.getElevation()){
        lowest = point;
      }
    }
    return lowest;
  }


  // TODO: Create a stub for highestPoint()
  public Point highestPoint(){
    if (points.isEmpty()){
      return null;
    }

    Point highest = points.get(0);
    for (Point point : points){
      if(points.getElevation() > highest.getElevation()){
        highest = point;
      }
    }
    return highest;
  }

  // TODO: Create a stub for totalDistance()
  //this stub is to calculate the tottal distance of the track
  public double totalDistance(){
    double totalDistance = 0.0;
    for (int i = 0; i < points.size() -1; i++){
      Point start = points.get(i);
      Point end = points.get(i + 1);
      totalDistance += Point.greatCircleDistance(start, end);
    }
    return totalDistance;
  }

  // TODO: Create a stub for averageSpeed()
  //now this one is to calculate the average speed over the track
  public double averageSpeed(){
    if (points.size() < 2){
      return 0.0;
    }

    double totalDistance = totalDistance();
    ZonedDateTime startTime = points.get(0).getTime();
    ZoneDateTime endTime = points.get(points.size() - 1).getTime();
    double totalTimeSeconds = java.time.Duration.between(startTime, endTime).getSeconds();

    return totalDistance / totalTimeSeconds;
  }

  public static void main(String[] args) {
    if (args.length < 1) {
        System.err.println("Usage: java Track <filename>");
        return;
    }
    try 
    {
        Track track = new Track(args[0]);
        System.out.println("Total number of points: " + track.size());
        System.out.println("Lowest point: " + track.lowestPoint());
        System.out.println("Highest point: " + track.highestPoint());
        System.out.println("Total distance: " + track.totalDistance() + " meters");
        System.out.println("Average speed: " + track.averageSpeed() + " meters/second");
    } 
    catch (IOException e) 
    {
        System.err.println("Error when creating track from file: " + e.getMessage());
    }
  }
}