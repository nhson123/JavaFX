package sample;

import javafx.beans.property.*;

/**
 * Package: sample
 * Generated by: Hoang.Son.Nguyen
 * Generated at: 14.05.2018 2018
 */
public class Person {
    private StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private BooleanProperty divorced = new SimpleBooleanProperty();
    private BooleanProperty married= new SimpleBooleanProperty();
    private BooleanProperty single= new SimpleBooleanProperty();


    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public boolean isDivorced() {
        return divorced.get();
    }

    public BooleanProperty divorcedProperty() {
        return divorced;
    }

    public void setDivorced(boolean divorced) {
        this.divorced.set(divorced);
        this.married.setValue(!divorced);
        this.single.setValue(divorced);
    }
}
