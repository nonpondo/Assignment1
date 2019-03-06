import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;

public class Q4 extends MainCon {

  public static BorderPane getpane4(){
    //create main border pane
    BorderPane bpane = new BorderPane();
    //create pane for input fields
    Pane box = new HBox(5);
    //file field input
    TextField fileField = new TextField();
    fileField.setPrefColumnCount(25);
    //view graph button
    Button btnView = new Button("View");
    //add all items to input fields
    box.getChildren().addAll(new Text("Filename: "),fileField, btnView);
    bpane.setCenter(box);

    //view file button action
    btnView.setOnAction(e ->{
      //create graph pane
      Pane pane = new Pane();
      //create bottom line of graph
      Line line = new Line(0,300,400,300);
      //frequency of letters array
      int[] letFreq = new int[26];
      //input file and catch exception or open file
      try{
        //call file function that generates frequency array
        letFreq = file(fileField.getText());
      }catch(Exception exc){
        fileField.setText("File not found:");
      }
      //get max value from array
      int max = 0;
      for (int i = 0; i < 26; i ++){
        if (max < letFreq[i]){
          max = letFreq[i];
        }
      }
      //max height of bar in graph possible (250)
      int maxheight = 250;
      for (int i = 0; i < 26; i ++){
        int heig = 0;
        if (letFreq[i] != 0){
          //height of bar for letter is equivalent to ratio between frequency to max frequency multiplied by max height
          heig = (int)(Double.valueOf(maxheight) *(Double.valueOf(letFreq[i])/Double.valueOf(max)));
        }
        //create rectangle in proper position
        Rectangle rect = new Rectangle(i*14 + 2, 300-heig, 10, heig);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK);
        pane.getChildren().add(rect);
      }
      pane.getChildren().add(line);
      //add Letter index to base
      pane.getChildren().add(new Text(1,310,"A  B  C  D  E   F  G  H   I   J  K  L  M  N O  P  Q R   S  T  U  V  W X  Y  Z"));
      bpane.setTop(pane);
    });


    return bpane;
  }

  public static void main(String[] args) {
    launch(args);
  }

  public static int[] file(String fileinput) throws Exception{
    //takes file input and outputs array from 0-25 based on frequncy of each letter regardless of case
    int [] freq = new int[26];
    //input file directory
    java.io.File file = new java.io.File(fileinput);
    //scan in file
    Scanner input = new Scanner(file);
    //loop until all text in file has been read
    while (input.hasNext()) {
      //x is current string being read from file
      String x = input.next();
      //turn x to upper case
      x = x.toUpperCase();
      //loop over every character in string
      for (int i = 0; i < x.length(); i ++){
        int ca = (int)x.charAt(i);
        //check if current character is a letter based on ascii code
        if (ca >= 65 && ca <= 91){
          //add 1 to corresponding array frequency position if it is a letter in the string
          freq[ca-65] ++;
        }
      }
    }

    input.close();
    return freq;

  }
}
