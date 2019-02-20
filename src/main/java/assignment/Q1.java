
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Random;

public class Q1 extends MainCon {

  public static Pane getpane1() {

    Random rand = new Random();
    int ind1 = rand.nextInt(51)+1;
    int ind2 = rand.nextInt(51)+1;
    int ind3 = rand.nextInt(51)+1;

    while(ind1 == ind2){
      ind2 = rand.nextInt(51)+1;

    }
    while (ind1 == ind3 && ind1 == ind3){
      ind3 = rand.nextInt(51)+1;
    }

    String card1 = String.format("Cards/%d.png",ind1);
    String card2 = String.format("Cards/%d.png",ind2);
    String card3 = String.format("Cards/%d.png",ind3);

    Pane pane = new HBox(10);
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.getChildren().add(new ImageView(new Image(card1)));
    pane.getChildren().add(new ImageView(new Image(card2)));
    pane.getChildren().add(new ImageView(new Image(card3)));

    return pane;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
