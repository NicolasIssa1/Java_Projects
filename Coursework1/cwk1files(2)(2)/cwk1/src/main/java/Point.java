import java.time.ZonedDateTime;

import static java.lang.Math.abs;
import static java.lang.Math.atan2;
import static java.lang.Math.cos;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.toRadians;


/**
 * Represents a point in space and time, recorded by a GPS sensor.
 *
 * @author Nick Efford & YOUR NAME
 */

public class Point {
  // Constants useful for bounds checking, etc

  private static final double MIN_LONGITUDE = -180.0;
  private static final double MAX_LONGITUDE = 180.0;
  private static final double MIN_LATITUDE = -90.0;
  private static final double MAX_LATITUDE = 90.0;
  private static final double MEAN_EARTH_RADIUS = 6.371009e+6;

   // Fields (instance variables) to store the state of a Point object.
   //this function is to store the time the point was recorded.
   private ZonedDateTime timestamp; 
   //this one to stores the longitude in degrees.
   private double longitude;
   //stores the latitude in degrees. 
   private double latitude;
   //stores the elevation in meters above sea level.
   private double elevation; 

  public Point(ZoneDateTime timestamp, double longitude, double latitude, double Elevation){
    if(lon < MIN_LONGITUDE || lon > MAX_LONGITUDE){
      throw new GPSException("Longitude out of bounds");
    }
    if(lat < MIN_LATITUDE || lat > MAX_LATITUDE){
      throw new GPSException("Latitude out of bounds");
    }
    timestamp = ts;
    longitude = lon;
    latitude = lat;
    elevation = elev;
  }

  // TODO: Create a stub for getTime()
  public ZoneDateTime getTime(){
    return timestamp;
  }

  // TODO: Create a stub for getLatitude()
  public double getLatitude () {
    return longitude; 
  }

  // TODO: Create a stub for getLongitude()
  public double getLongitude(){
    return latitude ;
  }

  public double getElevation() {
    return elevation;
}

  // TODO: Create a stub for toString()
  public String toString(){
    return String.format("(%f, %f) %f m", longitude, latitude, elevation);
  }

  // IMPORTANT: Do not alter anything beneath this comment!

  /**
   * Computes the great-circle distance or orthodromic distance between
   * two points on a spherical surface, using Vincenty's formula.
   *
   * @param p First point
   * @param q Second point
   * @return Distance between the points, in metres
   */
  public static double greatCircleDistance(Point p, Point q) {
    double phi1 = toRadians(p.getLatitude());
    double phi2 = toRadians(q.getLatitude());

    double lambda1 = toRadians(p.getLongitude());
    double lambda2 = toRadians(q.getLongitude());
    double delta = abs(lambda1 - lambda2);

    double firstTerm = cos(phi2)*sin(delta);
    double secondTerm = cos(phi1)*sin(phi2) - sin(phi1)*cos(phi2)*cos(delta);
    double top = sqrt(firstTerm*firstTerm + secondTerm*secondTerm);

    double bottom = sin(phi1)*sin(phi2) + cos(phi1)*cos(phi2)*cos(delta);

    return MEAN_EARTH_RADIUS * atan2(top, bottom);
  }
}
