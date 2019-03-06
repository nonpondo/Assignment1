import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class MainCon extends Application {
  @Override
  public void start(Stage primaryStage) {

    VBox mpane = new VBox(20);
    mpane.setStyle("-fx-background-color: teal;");
    mpane.setPadding(new Insets(25, 25, 25, 25));

    Button q1 = new Button("Question 1");
    Button q2 = new Button("Question 2");
    Button q3 = new Button("Question 3");
    Button q4 = new Button("Question 4");

    mpane.getChildren().add(q1);
    mpane.getChildren().add(q2);
    mpane.getChildren().add(q3);
    mpane.getChildren().add(q4);



    Scene scene = new Scene(mpane);
    primaryStage.setTitle("MyJavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();





    Stage stage = new Stage();
    stage.setTitle("Second Stage");


    q1.setOnAction(e -> {
        stage.setScene(new Scene(Q1.getpane1()));
        stage.show();
      }
    );
    q2.setOnAction(e -> {
        stage.setScene(new Scene(Q2.getpane2()));
        stage.show();
      }
    );
    q3.setOnAction(e -> {
        stage.setScene(new Scene(Q3.getpane3(),400,400));
        stage.show();
      }
    );
    q4.setOnAction(e -> {
        stage.setScene(new Scene(Q4.getpane4(),450,400));
        stage.show();
      }
    );

  }

  public static void main(String[] args) {
    launch(args);
  }
}
