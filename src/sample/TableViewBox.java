package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 09.05.2018 2018
 */
public  class TableViewBox {



    public  void display(String title, String message){
        Stage window = new Stage();
        Label label1 = new Label();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(800);
        label1.setText(message);
        TableView<Product> productTable;

        // Colum name
        TableColumn<Product, String> nameColumn = new TableColumn<>("Artikel");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        // colum price
        TableColumn<Product, Double> priceColumn = new TableColumn<>("Preis");
        priceColumn.setMinWidth(100);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        // colum quantity
        TableColumn<Product, Integer> quantityColumn = new TableColumn<>("Menge");
        quantityColumn.setMinWidth(100);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        productTable = new TableView<>();
        productTable.setItems(getProducts());
        productTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        Button closeButton = new Button("close!");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, closeButton, productTable);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(layout,750,750);
        window.setScene(scene);
        window.show();
    }

    public  ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Notebook", 1230.00, 3));
        products.add(new Product("Desktop", 4230.00, 2));
        products.add(new Product("MiniPc", 230.00, 12));
        products.add(new Product("Mcbook", 4230.00, 12));
        return products;
    }


}
