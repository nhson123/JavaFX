package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.xml.soap.Text;

import static javax.xml.bind.DatatypeConverter.parseDouble;
import static javax.xml.bind.DatatypeConverter.parseInt;

/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 11.05.2018 2018
 */
public class TabelEditableBox {

    TextField inputName, inputPreis, inputMenge;
    Button add, delete;
    ObservableList<Product> actualProducts;
    TableView<Product> productTable;

    public  void display(String title, String message){
        Stage window = new Stage();
        Label label1 = new Label();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMaxWidth(800);
        label1.setText(message);

        inputName = new TextField();
        inputName.setMinWidth(100);
        inputName.setPromptText("Artikelname");

        inputPreis = new TextField();
        inputPreis.setMinWidth(100);
        inputPreis.setPromptText("Artikelpreis");

        inputMenge = new TextField();
        inputMenge.setMinWidth(100);
        inputMenge.setPromptText("Artikelmenge");

        add = new Button("Add");
        add.setOnAction(e->{
            addProduct();

        });

        delete = new Button("Delete");
        delete.setOnAction(e->{
            removeProducts();
        });

        HBox hbox = new HBox(10);
        hbox.setPadding(new Insets(10,10,10,10));
        hbox.getChildren().addAll(inputName, inputPreis, inputMenge, add, delete);

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
        actualProducts = getProducts();
        productTable.setItems(actualProducts);
        productTable.getColumns().addAll(nameColumn, priceColumn, quantityColumn);


        Button closeButton = new Button("close!");
        closeButton.setOnAction(e -> window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label1, closeButton, productTable,hbox);
        layout.setAlignment(Pos.TOP_LEFT);

        Scene scene = new Scene(layout,750,750);
        window.setScene(scene);
        window.show();
    }

    private void addProduct() {
        Product newProduct = new Product();
        if(!inputName.getText().equals("")&&
                !inputMenge.getText().equals("")&&
                !inputPreis.getText().equals(""))  {
            newProduct.setName(inputName.getText());
            newProduct.setPrice(parseDouble(inputPreis.getText()));
            newProduct.setQuantity(parseInt(inputMenge.getText()));
            inputName.clear();
            inputPreis.clear();
            inputMenge.clear();
            productTable.getItems().add(newProduct);
        }

    }

    private void removeProducts(){
        ObservableList<Product> productSelected, allProduct;
        allProduct = productTable.getItems();
        productSelected = productTable.getSelectionModel().getSelectedItems();
        productSelected.forEach(allProduct::remove);
    }

    public ObservableList<Product> getProducts(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Notebook", 1230.00, 3));
        products.add(new Product("Desktop", 4230.00, 2));
        products.add(new Product("MiniPc", 230.00, 12));
        products.add(new Product("Mcbook", 4230.00, 12));
        return products;
    }
}