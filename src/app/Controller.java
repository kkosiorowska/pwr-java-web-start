package app;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller {


    @FXML public ListView toDoList;
    @FXML public Button btnDelete;
    @FXML public TextField nameField;
    @FXML public TextArea descriptionField;
    @FXML public Button btnAdd;

    List<Task> tasks = new ArrayList<Task>();


    public Task selectedTask;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        setList();
        toDoList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Task>() {
            @Override
            public void changed(ObservableValue<? extends Task> observable, Task oldValue, Task newValue) {
                selectedTask = newValue;
            }
        });
    }


    public void setList() {

        ObservableList<Task> observableArrayList = FXCollections.observableArrayList(tasks);
        toDoList.setItems(observableArrayList);

        toDoList.setCellFactory(param -> new ListCell<Task>() {
            @Override
            protected void updateItem(Task item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.getName() == null || item.getDescription() == null) {
                    setText(null);
                } else {
                    setText("Name: " + item.getName() + " Description: " + item.getDescription());
                }
            }
        });
    }



    public void addBtnClicked(MouseEvent mouseEvent) {
        if(!nameField.getText().isEmpty() && !descriptionField.getText().isEmpty()){
            Task task = new Task(nameField.getText(), descriptionField.getText());
            tasks.add(task);
            setList();
            nameField.clear();
            descriptionField.clear();
        }
    }

    public void deleteBtnClicked(MouseEvent mouseEvent) {
//        toDoList.getItems().remove(selectedTask);
        System.out.println("s");
       System.out.println(selectedTask.getName());
//        setList();
    }
}
