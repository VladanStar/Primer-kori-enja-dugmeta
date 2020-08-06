package sample;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;




public class Main extends Application {

    Text text = new Text(50,50,"JavaFx Programing");

    public BorderPane getPane(){
        HBox paneForButton = new HBox(20);
        // kreiranje dugmeta za levo
        ImageView img_left = new ImageView("left.jpg");
        img_left.setFitWidth(50);
        img_left.setFitHeight(50);
        Button btLeft = new Button("Left",img_left);

        // kreiranje dugmeta za desno
        ImageView img_right = new ImageView("right.jpg");
        img_right.setFitHeight(50);
        img_right.setFitWidth(50);
        Button btRight = new Button("Right", img_right);

        // dodavanje panela sa dugmicima za border layout
        paneForButton.getChildren().addAll(btLeft,btRight);
        paneForButton.setAlignment(Pos.CENTER);
        paneForButton.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButton);
        // dodavanje teksta na centar BorderPane

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        // dodavanje akcija na dugmice
        btLeft.setOnAction(e->text.setX(text.getX() -10));
        btRight.setOnAction(e->text.setX(text.getX()+10));
        return pane;

    }

    @Override  // Redefinisanje metode start() klase Application
    public void start(Stage primaryStage) throws Exception{
        // kreiranje scene i njeno postavljanje na pozornicu
        Scene scene = new Scene(getPane(),400,400);
        primaryStage.setTitle("Button Demo Labedel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
