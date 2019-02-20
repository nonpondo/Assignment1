
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.TextAlignment;

public class Q3 extends MainCon {
  public static Pane getpane3(){
    // Create a pane and set its properties
    Pane pane = new Pane();
    Circle circle = new Circle();
    circle.setCenterX(200);
    circle.setCenterY(200);
    circle.setRadius(100);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

    Circle sc1 = new Circle();
    sc1.setCenterX(100);
    sc1.setCenterY(100);
    sc1.setRadius(10);
    sc1.setStroke(Color.BLACK);
    sc1.setFill(Color.RED);

    Circle sc2 = new Circle();
    sc2.setCenterX(100);
    sc2.setCenterY(100);
    sc2.setRadius(10);
    sc2.setStroke(Color.BLACK);
    sc2.setFill(Color.RED);

    Circle sc3 = new Circle();
    sc3.setCenterX(100);
    sc3.setCenterY(100);
    sc3.setRadius(10);
    sc3.setStroke(Color.BLACK);
    sc3.setFill(Color.RED);
    Line line1t2 = new Line(10, 10, 10, 10);


    Line line2t3 = new Line(10, 10, 10, 10);

    Line line3t1 = new Line(10, 10, 10, 10);

    Text angle1 = new Text(10,10,"0");
    Text angle2 = new Text(10,10,"0");
    Text angle3 = new Text(10,10,"0");

    pane.getChildren().addAll(circle,angle1,angle2,angle3,line1t2,line2t3,line3t1,sc1,sc2,sc3);



    sc1.setOnMouseDragged(e -> {
      double xd = (e.getX()-200);
      double yd = (e.getY()-200);
      double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
      double xu = xd/dnorm;
      double yu = yd/dnorm;
      int x = (int)(Math.floor(100*xu))+200;
      int y = (int)(Math.floor(100*yu))+200;
      line1t2.setStartX(x);
      line1t2.setStartY(y);

      line3t1.setEndX(x);
      line3t1.setEndY(y);


      int ang1 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line2t3),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line1t2),2))/(-2*leng(line3t1)*leng(line1t2)))));
      int ang2 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2)-Math.pow(leng(line1t2),2))/(-2*leng(line2t3)*leng(line1t2)))));
      int ang3 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line1t2),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2))/(-2*leng(line2t3)*leng(line3t1)))));
      angle1.setText(String.valueOf(ang1));
      angle2.setText(String.valueOf(ang2));
      angle3.setText(String.valueOf(ang3));
      angle1.setX(x-10);
      angle1.setY(y-10);



      sc1.setCenterX(x);
      sc1.setCenterY(y);
    });


    sc2.setOnMouseDragged(e -> {
      double xd = (e.getX()-200);
      double yd = (e.getY()-200);
      double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
      double xu = xd/dnorm;
      double yu = yd/dnorm;

      int x = (int)(Math.floor(100*xu))+200;
      int y = (int)(Math.floor(100*yu))+200;
      line2t3.setStartX(x);
      line2t3.setStartY(y);

      line1t2.setEndX(x);
      line1t2.setEndY(y);

      int ang1 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line2t3),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line1t2),2))/(-2*leng(line3t1)*leng(line1t2)))));
      int ang2 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2)-Math.pow(leng(line1t2),2))/(-2*leng(line2t3)*leng(line1t2)))));
      int ang3 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line1t2),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2))/(-2*leng(line2t3)*leng(line3t1)))));
      angle1.setText(String.valueOf(ang1));
      angle2.setText(String.valueOf(ang2));
      angle3.setText(String.valueOf(ang3));
      angle2.setX(x-10);
      angle2.setY(y-10);

      sc2.setCenterX(x);
      sc2.setCenterY(y);
    });

    sc3.setOnMouseDragged(e -> {
      double xd = (e.getX()-200);
      double yd = (e.getY()-200);

      double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
      double xu = xd/dnorm;
      double yu = yd/dnorm;

      int x = (int)(Math.floor(100*xu))+200;
      int y = (int)(Math.floor(100*yu))+200;
      line3t1.setStartX(x);
      line3t1.setStartY(y);

      line2t3.setEndX(x);
      line2t3.setEndY(y);

      int ang1 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line2t3),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line1t2),2))/(-2*leng(line3t1)*leng(line1t2)))));
      int ang2 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2)-Math.pow(leng(line1t2),2))/(-2*leng(line2t3)*leng(line1t2)))));
      int ang3 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line1t2),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2))/(-2*leng(line2t3)*leng(line3t1)))));
      angle1.setText(String.valueOf(ang1));
      angle2.setText(String.valueOf(ang2));
      angle3.setText(String.valueOf(ang3));
      angle3.setX(x-10);
      angle3.setY(y-10);

      sc3.setCenterX(x);
      sc3.setCenterY(y);
    });

    return pane;
  }

  /**
   * The main method is only needed for the IDE with limited
   * JavaFX support. Not needed for running from the command line.
   */
  public static void main(String[] args) {
    launch(args);
  }

  public static double leng(Line l1){
    double xd = (l1.getStartX()-l1.getEndX());
    double yd = (l1.getStartY()-l1.getEndY());
    double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
    return dnorm;
  }
}
