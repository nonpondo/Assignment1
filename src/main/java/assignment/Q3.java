
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

    //create main circle
    Circle circle = new Circle();
    circle.setCenterX(200);
    circle.setCenterY(200);
    circle.setRadius(100);
    circle.setStroke(Color.BLACK);
    circle.setFill(Color.WHITE);

    //create first small circle
    Circle sc1 = new Circle();
    sc1.setCenterX(200);
    sc1.setCenterY(100);
    sc1.setRadius(10);
    sc1.setStroke(Color.BLACK);
    sc1.setFill(Color.RED);

    //create second small circle
    Circle sc2 = new Circle();
    sc2.setCenterX(200);
    sc2.setCenterY(300);
    sc2.setRadius(10);
    sc2.setStroke(Color.BLACK);
    sc2.setFill(Color.RED);

    //create third small circle
    Circle sc3 = new Circle();
    sc3.setCenterX(300);
    sc3.setCenterY(200);
    sc3.setRadius(10);
    sc3.setStroke(Color.BLACK);
    sc3.setFill(Color.RED);

    //create lines in between circles that are marked (beginning circle)t(end circle)
    Line line1t2 = new Line(200, 100, 200, 300);
    Line line2t3 = new Line(200, 300, 300, 200);
    Line line3t1 = new Line(300, 200, 200, 100);

    //angle texts
    Text angle1 = new Text(10,10,"0");
    Text angle2 = new Text(10,10,"0");
    Text angle3 = new Text(10,10,"0");

    //add nodes to pane
    pane.getChildren().addAll(circle,angle1,angle2,angle3,line1t2,line2t3,line3t1,sc1,sc2,sc3);


    //
    sc1.setOnMouseDragged(e -> {
      //get mouse co-ordinates relatie to origin
      double xd = (e.getX()-200);
      double yd = (e.getY()-200);
      //get length of norm from origin to mouse co-ordinates using 2-norm
      double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
      //calculate unit vector
      double xu = xd/dnorm;
      double yu = yd/dnorm;
      //multiply unit vector by radius and offset to center of circle
      int x = (int)(Math.floor(100*xu))+200;
      int y = (int)(Math.floor(100*yu))+200;
      //move lines between points
      line1t2.setStartX(x);
      line1t2.setStartY(y);

      line3t1.setEndX(x);
      line3t1.setEndY(y);

      //update angle nnumbers
      int[] angs = angles(line1t2, line2t3, line3t1);
      angle1.setText(String.valueOf(angs[0]));
      angle2.setText(String.valueOf(angs[1]));
      angle3.setText(String.valueOf(angs[2]));
      angle1.setX(x-10);
      angle1.setY(y-10);


      //move circle
      sc1.setCenterX(x);
      sc1.setCenterY(y);
    });


    sc2.setOnMouseDragged(e -> {
      //get mouse co-ordinates relatie to origin
      double xd = (e.getX()-200);
      double yd = (e.getY()-200);
      //get length of norm from origin to mouse co-ordinates using 2-norm
      double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
      //calculate unit vector
      double xu = xd/dnorm;
      double yu = yd/dnorm;
      //multiply unit vector by radius and offset to center of circle
      int x = (int)(Math.floor(100*xu))+200;
      int y = (int)(Math.floor(100*yu))+200;
      //move lines between points
      line2t3.setStartX(x);
      line2t3.setStartY(y);

      line1t2.setEndX(x);
      line1t2.setEndY(y);
      //update angle nnumbers
      int[] angs = angles(line1t2, line2t3, line3t1);
      angle1.setText(String.valueOf(angs[0]));
      angle2.setText(String.valueOf(angs[1]));
      angle3.setText(String.valueOf(angs[2]));
      angle2.setX(x-10);
      angle2.setY(y-10);
      //move circle
      sc2.setCenterX(x);
      sc2.setCenterY(y);
    });

    sc3.setOnMouseDragged(e -> {
      //get mouse co-ordinates relatie to origin
      double xd = (e.getX()-200);
      double yd = (e.getY()-200);
      //get length of norm from origin to mouse co-ordinates using 2-norm
      double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
      //calculate unit vector
      double xu = xd/dnorm;
      double yu = yd/dnorm;
      //multiply unit vector by radius and offset to center of circle
      int x = (int)(Math.floor(100*xu))+200;
      int y = (int)(Math.floor(100*yu))+200;
      //move lines between points
      line3t1.setStartX(x);
      line3t1.setStartY(y);

      line2t3.setEndX(x);
      line2t3.setEndY(y);
      //update angle nnumbers
      int[] angs = angles(line1t2, line2t3, line3t1);
      angle1.setText(String.valueOf(angs[0]));
      angle2.setText(String.valueOf(angs[1]));
      angle3.setText(String.valueOf(angs[2]));
      angle3.setX(x-10);
      angle3.setY(y-10);
      //move circle
      sc3.setCenterX(x);
      sc3.setCenterY(y);
    });

    return pane;
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static double leng(Line l1){
    //input is line and output is length using euclidean norm
    double xd = (l1.getStartX()-l1.getEndX());
    double yd = (l1.getStartY()-l1.getEndY());
    double dnorm = Math.sqrt(Math.pow(xd,2)+Math.pow(yd,2));
    return dnorm;
  }

  public static int[] angles(Line line1t2, Line line2t3, Line line3t1){
    //input 3 lines, output is angle between lines in an array
    int ang1 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line2t3),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line1t2),2))/(-2*leng(line3t1)*leng(line1t2)))));
    int ang2 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2)-Math.pow(leng(line1t2),2))/(-2*leng(line2t3)*leng(line1t2)))));
    int ang3 =(int)(Math.toDegrees(Math.acos((Math.pow(leng(line1t2),2)-Math.pow(leng(line3t1),2)-Math.pow(leng(line2t3),2))/(-2*leng(line2t3)*leng(line3t1)))));
    return new int[] {ang1, ang2, ang3};
  }


}
