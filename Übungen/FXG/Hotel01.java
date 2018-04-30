package Übungen.FXG;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

/**
 * This class demonstrates some features of JavaFX:
 * use of control elements like Label, Button and TextField
 * arranged in a GridLayout, event handling and binding.
 * @author agathe merceron
 *
 */


public class Hotel01 extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            GridPane root = new GridPane();
            // space between rows
            root.setHgap(10);
            // space between columns
            root.setVgap(10);
            //space around the element root
            root.setPadding(new Insets(25, 25, 25, 25));

            Text hotelIbisMitte = new Text("ibis Styles Hotel\n "
                    + "Berlin Mitte, Brunnenstraße 1-2\n" +"10119 Berlin");
            //puts hotelIbisMitte column 1 row 0
            root.add(hotelIbisMitte, 1, 0);

            Image image = new Image (getClass().
                    getResource("/resources/ibisMitteBerlin.jpg").toString());
            ImageView imageview = new ImageView(image);
            //puts imageview column 0 row 0
            root.add(imageview, 5, 0);



            Label labelrating = new Label("current rating:");
            //puts labelrating column 0 row 1
            root.add(labelrating, 0, 1);
            Label currentrating = new Label("6.2");
            root.add(currentrating, 1, 1);

            Button button = new Button("Enter your rating");

            root.add(button, 0, 3);

            Label l = new Label("Your rating:");
            l.setVisible(false);
            root.add(l, 0, 5);

            TextField myrating = new TextField("6.2");
            myrating.setVisible(false);
            //binds the text of currentrating to the text of myrating
            currentrating.textProperty().bind(myrating.textProperty());
            root.add(myrating, 1, 5);
            // The Parameter of setOnAction is of Type
            // EventHandler<T extends Event>, a functional Interface.
            // the unique instance method handle is implemented
            // with a lambda expression.
            // The body of the lambda expression is programmed
            // in the help method enterRating
            // for more clarity
            button.setOnAction(e -> enterRating(l, myrating));
            // other possible way because the body of the method
            // is still small: only 2 lines.
            // button.setOnAction(e -> {l.setVisible(true);
            // myrating.setVisible(true);
            // });


            Scene scene = new Scene(root,400,400);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    //help method for the body of the lambda expression
    private void enterRating(Label l, TextField t){
        l.setVisible(true);
        t.setVisible(true);

    }

    public static void main(String[] args) {
        launch(args);
    }
}