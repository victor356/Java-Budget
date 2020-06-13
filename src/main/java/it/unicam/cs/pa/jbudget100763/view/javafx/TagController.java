package it.unicam.cs.pa.jbudget100763.view.javafx;

import it.unicam.cs.pa.jbudget100763.controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TagController {

    /**
     * new Tag scene
     */

    @FXML
    private TextField TagNameField = new TextField();

    @FXML
    private TextField TagDescriptionField = new TextField();

    @FXML
    private Button alertButton;

    @FXML
    private Button closeButton;

    private Controller controller = new Controller();

    @FXML
    void newTag() {
      
        controller.addTag(TagNameField.getText(), TagDescriptionField.getText());
        
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void closeButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}