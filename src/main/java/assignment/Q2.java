
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.geometry.Pos;
import javafx.scene.control.PasswordField;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Q2 extends MainCon {

  public static GridPane getpane2(){
    //create gridpane
    GridPane pane = new GridPane();
    pane.setAlignment(Pos.CENTER);
    pane.setHgap(5.5);
    pane.setVgap(5.5);

    //create textfields
    TextField invamount = new TextField();
    TextField yrs = new TextField();
    TextField annintrate = new TextField();
    TextField phone = new TextField();
    //create button
    Button btnCalc = new Button("Calculate");
    //function value text box
    Text fval = new Text();
    //layout panels
    pane.add(new Text("Investment Amount "),0,0);
    pane.add(new Text("Years "),0,1);
    pane.add(new Text("Annual Interest Rate "),0,2);
    pane.add(new Text("Future Value "),0,3);
    pane.add(invamount,1,0);
    pane.add(yrs,1,1);
    pane.add(annintrate,1,2);
    pane.add(fval,1,3);
    pane.add(btnCalc,1,4);



    //button action calculates formula
    btnCalc.setOnAction(e -> {
      double fvald = Float.parseFloat( invamount.getText() ) * Math.pow( (1.0+Float.parseFloat(annintrate.getText())/1200) , ( Float.parseFloat( yrs.getText() )*12.0));
      fval.setText(String.format("$%.2f",fvald));

    });




    return pane;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
