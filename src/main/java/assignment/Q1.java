
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

    //create random seed
    Random rand = new Random();
    //pick 3 random numbers between 1 and 54
    int ind1 = rand.nextInt(53)+1;
    int ind2 = rand.nextInt(53)+1;
    int ind3 = rand.nextInt(53)+1;

    //loop makes sure all random numbers are different
    while(ind1 == ind2){
      ind2 = rand.nextInt(53)+1;

    }
    while (ind1 == ind3 && ind1 == ind3){
      ind3 = rand.nextInt(53)+1;
    }

    //create card id strings
    String card1 = String.format("Cards/%d.png",ind1);
    String card2 = String.format("Cards/%d.png",ind2);
    String card3 = String.format("Cards/%d.png",ind3);

    //print the 3 random cards to a pane
    Pane pane = new HBox(10);
    pane.setPadding(new Insets(5, 5, 5, 5));
    pane.getChildren().add(new ImageView(new Image(card1)));
    pane.getChildren().add(new ImageView(new Image(card2)));
    pane.getChildren().add(new ImageView(new Image(card3)));

    //return the pane
    return pane;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
