package sample;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 12.05.2018 2018
 */
public class MenuBox {
    public static void display(String title, String message) {
        Stage window = new Stage();
        Label label1 = new Label();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(800);
        label1.setText(message);
        label1.getStylesheets().add("Viper.css");

        //FileMenu
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu helpMenu = new Menu("Help");
        Menu styleSheet = new Menu("Stylesheet");
        //FileMenu Item
        MenuItem newProject = new MenuItem("New project...");
        newProject.setOnAction(e -> {
            try {
                Desktop.getDesktop().open(new File("C:/ProgramData"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        fileMenu.getItems().add(newProject);
        MenuItem openProject = new MenuItem("Open project...");
        fileMenu.getItems().add(openProject);
        fileMenu.getItems().add(new MenuItem("Import project..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().add(exit);
        exit.setDisable(true);

        // Help MENU
        CheckMenuItem F1 = new CheckMenuItem("F1 for help");
        F1.setOnAction(e -> {

        });
        CheckMenuItem autoSave = new CheckMenuItem("auto save");
        autoSave.setSelected(true);
        helpMenu.getItems().addAll(F1, autoSave);

        //difficulty Menu
        ToggleGroup difficultyToggle = new ToggleGroup();
        RadioMenuItem defaultStyle = new RadioMenuItem("default");
        RadioMenuItem modena = new RadioMenuItem("Modena");
        modena.setOnAction(e -> {
            Application.setUserAgentStylesheet(Application.STYLESHEET_MODENA);
        });
        RadioMenuItem caspian = new RadioMenuItem("Caspian");
        caspian.setOnAction(e -> {
            Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
        });
        defaultStyle.setToggleGroup(difficultyToggle);
        modena.setToggleGroup(difficultyToggle);
        caspian.setToggleGroup(difficultyToggle);
        styleSheet.getItems().addAll(defaultStyle,modena,caspian);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu, styleSheet);


        Button closeButton = new Button("Look anf Feel!");
        closeButton.setOnAction(e -> {
           Application.setUserAgentStylesheet(Application.STYLESHEET_CASPIAN);
        });

        VBox center = new VBox();
        center.getChildren().addAll(label1,closeButton);

        BorderPane layout = new BorderPane();
        layout.setTop(menuBar);
        layout.setCenter(center);


        Scene scene = new Scene(layout, 650, 350);
        scene.getStylesheets().addAll("Viper.css");
        window.setScene(scene);
        window.showAndWait();
    }
}
