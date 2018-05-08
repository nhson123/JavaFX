package sample;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 07.05.2018 2018
 */
public class GridBox {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(1000);

        Button button1 = new Button("Button1");
        Button button2 = new Button("Button2");
        Button button3 = new Button("Button3");
        Button button4 = new Button("Button4");
        Button button5 = new Button("Button5");
        TextField textField = new TextField();
        CheckBox checkBoxYes = new CheckBox("Yes");
        CheckBox checkBoxNo = new CheckBox("No");
        checkBoxNo.setSelected(true);
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Peace");
        choiceBox.getItems().add("Melone");
        choiceBox.setValue("Melone");


        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(10);
        GridPane.setConstraints(button1, 0, 0);
        GridPane.setConstraints(button2, 1, 1);
        GridPane.setConstraints(button3, 2, 2);
        GridPane.setConstraints(button4, 3, 3);
        GridPane.setConstraints(button5, 0, 4);
        GridPane.setConstraints(textField, 0, 5);
        GridPane.setConstraints(checkBoxYes, 0, 6);
        GridPane.setConstraints(checkBoxNo, 1, 6);
        GridPane.setConstraints(choiceBox, 0, 7);

        gridPane.getChildren().addAll(
                button1, button2, button3, button4, button5,textField, checkBoxNo,checkBoxYes,
                choiceBox);
        Scene scene = new Scene(gridPane, 650, 650);
        window.setScene(scene);
        window.showAndWait();
    }
}
