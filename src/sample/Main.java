package sample;

import javafx.animation.FillTransition;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Main extends Application {

    int x = 1;
    @Override
    public void start(Stage stage) {

        Button get_Color = new Button("Paint");
        get_Color.setStyle("-fx-background-color: #ff9000;-fx-text-fill: white;-fx-font-size: 25;-fx-font-weight: bold");
        get_Color.setPrefSize(100,50);
        get_Color.setTranslateX(100);
        get_Color.setTranslateY(250);

        Button clear = new Button("Clear");
        clear.setStyle("-fx-background-color: #ff9000;-fx-text-fill: white;-fx-font-size: 25;-fx-font-weight: bold");
        clear.setPrefSize(100,50);
        clear.setTranslateX(100);
        clear.setTranslateY(400);

        TextField textField = new TextField();
        textField.setPromptText("Enter Color");
        textField.setPrefSize(200,50);
        textField.setTranslateX(100);
        textField.setTranslateY(100);

        Separator separator = new Separator();
        separator.setOrientation(Orientation.VERTICAL);
        separator.setTranslateX(400);
        separator.setPrefSize(20,600);

        Label message = new Label("");
        message.setStyle("-fx-font-weight: bold;-fx-text-fill: red;-fx-font-size: 25");
        message.setTranslateX(100);
        message.setTranslateY(150);

        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: #ffffff");
        pane.setTranslateX(415);
        pane.setPrefSize(300,250);

        Pane pane2 = new Pane();
        pane2.setStyle("-fx-background-color: #ffffff");
        pane2.setTranslateX(715);
        pane2.setPrefSize(300,250);

        Pane pane3 = new Pane();
        pane3.setStyle("-fx-background-color: #ffffff");
        pane3.setTranslateX(415);
        pane3.setTranslateY(250);
        pane3.setPrefSize(300,350);

        Pane pane4 = new Pane();
        pane4.setStyle("-fx-background-color: #ffffff");
        pane4.setTranslateX(715);
        pane4.setTranslateY(250);
        pane4.setPrefSize(300,350);


        Pane root = new Pane();
        root.setStyle("-fx-background-color: #2e2e2e");

        Text text = new Text("MN9");

        text.setFont(new Font("Tahoma", 60));
        text.setStroke(Color.GRAY);
        text.setTranslateX(100);
        text.setTranslateY(75);
        FillTransition fillTransition = new FillTransition();
        fillTransition.setDuration(Duration.seconds(1.5));

        fillTransition.setShape(text);
        fillTransition.setFromValue(Color.CYAN);

        fillTransition.setToValue(Color.CORAL);

        fillTransition.setCycleCount(-1);
        fillTransition.setAutoReverse(true);
        fillTransition.play();



        root.getChildren().addAll(get_Color,textField,separator,message,pane,pane2,pane3,pane4,clear,text);
        Scene scene = new Scene(root,1000,500);
        scene.getStylesheets().add("sample/css.css");
        stage.setScene(scene);
        stage.setTitle("MN9");
        stage.setResizable(false);
        stage.show();


        get_Color.addEventHandler(MouseEvent.ANY,(MouseEvent e)->{
            if(e.getEventType().equals(MouseEvent.MOUSE_ENTERED)){
                DropShadow dropShadow = new DropShadow(10,Color.WHITE);
                get_Color.setEffect(dropShadow);
            }
            else if(e.getEventType().equals(MouseEvent.MOUSE_EXITED)){
                get_Color.setEffect(null);
            }
            else if(e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                if(textField.getText().isEmpty()){
                    message.setText("Please type color");
                }
                else {
                    try {
                        message.setText("");
                        if(x == 1) {
                            pane.setBackground(new Background(new BackgroundFill(Color.web(textField.getText()), CornerRadii.EMPTY, Insets.EMPTY)));
                            x++; }
                        else if (x == 2){
                            pane2.setBackground(new Background(new BackgroundFill(Color.web(textField.getText()),CornerRadii.EMPTY,Insets.EMPTY)));
                            x++;}
                        else if (x == 3){
                            pane3.setBackground(new Background(new BackgroundFill(Color.web(textField.getText()),CornerRadii.EMPTY,Insets.EMPTY)));
                            x ++;}
                        else if (x == 4){
                            pane4.setBackground(new Background(new BackgroundFill(Color.web(textField.getText()),CornerRadii.EMPTY,Insets.EMPTY)));
                            x =1;}
                    } catch (Exception ex) {
                        message.setText(textField.getText() + " is not a color!");
                        System.out.println(ex.getMessage());
                    }
                }
                textField.clear();
            }
        });

        clear.addEventHandler(MouseEvent.ANY,(MouseEvent e)-> {
            if (e.getEventType().equals(MouseEvent.MOUSE_ENTERED)) {
                DropShadow dropShadow = new DropShadow(10, Color.WHITE);
                clear.setEffect(dropShadow);
            } else if (e.getEventType().equals(MouseEvent.MOUSE_EXITED)) {
                clear.setEffect(null);
            }
            else if(e.getEventType().equals(MouseEvent.MOUSE_CLICKED)){
                pane.setStyle("-fx-background-color: white");
                pane2.setStyle("-fx-background-color: white");
                pane3.setStyle("-fx-background-color: white");
                pane4.setStyle("-fx-background-color: white");
                x =1;
            }
        });


    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void M(){
        main(null);
    }

}
