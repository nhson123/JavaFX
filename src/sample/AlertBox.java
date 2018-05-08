package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;



/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 05.05.2018 2018
 */
public class AlertBox {



    public static void display(String title, String message){
        Stage window = new Stage();
        Label label1 = new Label();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(400);
        label1.setText(message);

        Button closeButton = new Button("close!");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout,250,350);
        window.setScene(scene);
        window.showAndWait();
    }
}