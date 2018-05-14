package sample;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
        Label labelInput = new Label();
        CheckBox checkBoxYes = new CheckBox("Yes");
        CheckBox checkBoxNo = new CheckBox("No");
        checkBoxNo.setSelected(true);
        ChoiceBox<String> choiceBox = new ChoiceBox<String>();
        choiceBox.getItems().add("Apple");
        choiceBox.getItems().add("Peace");
        choiceBox.getItems().add("Melone");
        choiceBox.setValue("Melone");
        ListView listView = new ListView();
        listView.getItems().addAll(
                "Vietnam",
                "Korea",
                "Japan"
        );
        listView.setPrefHeight(100);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ObservableList<String> selectedItems = listView.getSelectionModel().getSelectedItems();
        Label label = new Label("Gender");
        ComboBox<String> comboBox = new ComboBox<String>();
        comboBox.setPromptText("Gender");
        comboBox.getItems().addAll(
                "Mänder",
                "Frauen",
                "Kinder"
        );
        comboBox.setOnAction(e -> {
            label.setText(comboBox.getValue());
            System.out.println(comboBox.getValue());
        });
        comboBox.setEditable(true);


        button5.setOnAction(e -> button5.setText(getChoiceBox(choiceBox)));
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            button4.setText(oldValue);
            button3.setText(newValue);
        });


        TreeItem<String> root, Oberschef, Chef1, Chef2, Underchef;
        root = new TreeItem<String>();
        root.setExpanded(true);
        TreeView<String> treeView = new TreeView<>(root);
        treeView.setPrefHeight(100);
        treeView.setShowRoot(false);
        Oberschef = makeTreeItem("Oberschef", root);
        Chef1 = makeTreeItem("Chef1", Oberschef);
        Chef2 = makeTreeItem("Chef2", Oberschef);
        Underchef = makeTreeItem("Unterchef", Chef1);
        treeView.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            if (oldValue != null && newValue != null) {
                label.setText(oldValue.getValue() + " -> " + newValue.getValue());
            } else if (oldValue == null && newValue != null) {
                label.setText(" -> " + newValue.getValue());
            }
        });

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
        GridPane.setConstraints(labelInput, 1, 5);
        GridPane.setConstraints(checkBoxYes, 0, 6);
        GridPane.setConstraints(checkBoxNo, 1, 6);
        GridPane.setConstraints(choiceBox, 0, 7);
        GridPane.setConstraints(comboBox, 1, 7);
        GridPane.setConstraints(label, 2, 7);
        GridPane.setConstraints(listView, 0, 8);
        GridPane.setConstraints(treeView, 1, 8);
        gridPane.getChildren().addAll(
                button1, button2, button3, button4, button5, textField, labelInput, checkBoxNo, checkBoxYes,
                choiceBox, comboBox, label, listView, treeView);
        GridPane.setConstraints(label, 2, 7);


        button4.setOnAction(e -> {
            for (String item : selectedItems) {
                System.out.println(item);
            }

            System.out.println(treeView.getSelectionModel().getSelectedItem().getValue());
        });

        //Bind Label
        labelInput.textProperty().bind(textField.textProperty());
        Scene scene = new Scene(gridPane, 1000, 650);
        window.setScene(scene);
        window.showAndWait();
    }

    private static TreeItem<String> makeTreeItem(String name, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(name);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;
    }

    private static String getChoiceBox(ChoiceBox<String> choiceBox) {
        return choiceBox.getValue();
    }
}
