import java.io.IOException;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;


/**
 * JavaFX application to plot elevations of a GPS track, for the
 * Advanced task of COMP1721 Coursework 1.
 *
 * @author Nicolas Issa
 */
public class PlotApplication extends Application {

  @Override
  public void start(Stage stage){

    // Validate command line arguments
    List<String> params = getParameters().getRaw();
    if (params.size() != 1) {
      System.out.println("Usage: java PlotApplication <filename>");
      System.exit(1);
    }

    // Setup the chart
    NumberAxis xAxis = new NumberAxis();
    xAxis.setLabel("Distance (meters)");
    NumberAxis yAxis = new NumberAxis();
    yAxis.setLabel("Elevation (meters)");

    LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
    lineChart.setTitle("Elevation Plot");

    XYChart.Series<Number, Number> series = new XYChart.Series<>();
    series.setName("Elevation");

    // Read and plot data
    try {
      Track track = new Track(params.get(0)); // Load the track data from file
      double distance = 0; // Initialize cumulative distance

      for (int i = 1; i < track.size(); i++) {
        Point prev = track.get(i - 1);
        Point curr = track.get(i);
        distance += Point.greatCircleDistance(prev, curr); // Calculate cumulative distance
        series.getData().add(new XYChart.Data<>(distance, curr.getElevation())); // Add elevation data to series
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(2);
    } catch (GPSException e) {
      System.out.println(e.getMessage());
      System.exit(3);
    }

    lineChart.getData().add(series);

    Scene scene = new Scene(lineChart, 800, 600);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
