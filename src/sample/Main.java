package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

/**
 * https://www.youtube.com/watch?v=FLkOX4Eez6o&list=PL6gx4Cwl9DGBzfXLWLSYVy8EbTdpGbUIG
 */
public class Main extends Application implements EventHandler<ActionEvent> {
    Button button;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Label label;
    Stage window;
    Scene scene;
    Scene scene2;
    Boolean confirm = false;


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //primaryStage.setScene(new Scene(root, 600, 550));
        window = primaryStage;

        window.setTitle("Hello World 1");
        button = new Button();
        button.setText("Click me!");
        button.setOnAction(this);

        button1 = new Button();
        button1.setText("Klick mich!");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                button1.setText("Geklickt!");
                if (confirm) {
                    AlertBox.display("a confirmed Alert", "Uhuu");
                } else AlertBox.display("a Alert", "Uhuu");
            }
        });
        button2 = new Button();
        button2.setText("lambda me!");
        button2.setOnAction(e -> {
            window.setScene(scene);
            window.setTitle("Hello World 1");
            button2.setText("Lambda!");
        });
        button3 = new Button();
        button3.setText("please Confirm!");
        button3.setOnAction(e -> {
            confirm = ConfirmBox.display("ConfirmBox", "Confirm!");
        });

        button4 = new Button();
        button4.setText("show BorderPane!");
        button4.setOnAction(e -> {
            BorderBox.display("BorderBox", "BorderBox");
        });

        button5 = new Button();
        button5.setText("show GridPane!");
        button5.setOnAction(e -> {
            GridBox.display("GridBox", "GridBox");
        });
        button6 = new Button();
        button6.setText("show TableView!");
        button6.setOnAction(e -> {
            TableViewBox table = new TableViewBox();
            table.display("TableBox", "TableViewBox");
        });

        button7 = new Button();
        button7.setText("show EditTableView!");
        button7.setOnAction(e -> {
            TabelEditableBox table = new TabelEditableBox();
            table.display("EditableTableBox", "editable TableViewBox");
        });

        button8 = new Button();
        button8.setText("show Menubar!");
        button8.setOnAction(e -> {
            MenuBox menuBoxm = new MenuBox();
            menuBoxm.display("Menubar Box", "Menubar");
        });

        button9 = new Button();
        button9.setText("StringProperty");
        Person person = new Person();
        person.firstNameProperty().addListener((v,oldValue, newValue)->{
            label.setText("PersonFirstName: "+person.firstNameProperty()+ " changed from: "+
            oldValue +" to: "+newValue);
        });
        button9.setOnAction(e -> {
            person.setFirstName("SonNguyen");
        });
        label = new Label();
        VBox layout = new VBox(20);
        layout.getChildren().add(button);
        layout.getChildren().add(button1);
        layout.getChildren().add(button2);
        layout.getChildren().add(button3);
        layout.getChildren().add(button4);
        layout.getChildren().add(button5);
        layout.getChildren().add(button6);
        layout.getChildren().add(button7);
        layout.getChildren().add(button8);
        layout.getChildren().add(button9);
        layout.getChildren().add(label);

        StackPane layout2 = new StackPane();
        layout2.getChildren().add(button2);
        scene2 = new Scene(layout2, 700, 400);


        scene = new Scene(layout, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        window.setOnCloseRequest(e -> {
            e.consume();
            if(ConfirmBox.display("Ende des Programm","wollen wir schluss!"))
            window.close();
        });

    }


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void handle(ActionEvent event) {
        if (event.getSource() == button) {
            button.setText("Cliked!");
            window.setScene(scene2);
            window.setTitle("Hello World 2");
        }

    }
}
