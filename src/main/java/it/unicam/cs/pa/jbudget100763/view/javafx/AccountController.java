package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.ResourceBundle;

import it.unicam.cs.pa.jbudget100763.controller.Controller;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AccountController implements Initializable {
    @FXML
    private TextField accountNameField = new TextField();

    @FXML
    private TextField accountDescriptionField = new TextField();

    @FXML
    private TextField accountOpeningBalanceField = new TextField();

    @FXML
    private ChoiceBox<AccountType> accountTypeField = new ChoiceBox<AccountType>();

    @FXML
    private Button alertButton;

    @FXML
    private Button closeButton;

    private Controller controller = new Controller();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        accountTypeField.setValue(accountChoice.get(0));
        accountOpeningBalanceField.setText("0");
    }

    /**
     * mostra i tipi di account nel choicebox
     */
    @FXML
    private void typeScroll() {
        accountTypeField.setItems((ObservableList<AccountType>) accountChoice);

    }

    ObservableList<AccountType> accountChoice = FXCollections
            .observableArrayList(new ArrayList<AccountType>(EnumSet.allOf(AccountType.class)));

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void addAccount(ActionEvent actionEvent) throws IOException {
        if (accountOpeningBalanceField.getText().isEmpty()) {
			throw new IllegalArgumentException("Inserire cifra iniziale!!!!");
		}
        controller.addAccount(accountTypeField.getValue(), accountNameField.getText(),
                accountDescriptionField.getText(), Double.parseDouble(accountOpeningBalanceField.getText()));

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void closeButtonAction() {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}