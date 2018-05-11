package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 12.05.2018 2018
 */
public class MenuBox {
    public static void display(String title, String message){
        Stage window = new Stage();
        Label label1 = new Label();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(400);
        label1.setText(message);

        //FileMenu
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        //FileMenu Item
        fileMenu.getItems().add(new MenuItem("New project..."));
        fileMenu.getItems().add(new MenuItem("Open project..."));
        fileMenu.getItems().add(new MenuItem("Import project..."));

        // Main Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu);


        Button closeButton = new Button("close!");
        closeButton.setOnAction(e -> window.close());

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);


        Scene scene = new Scene(layout,250,350);
        window.setScene(scene);
        window.showAndWait();
    }
}