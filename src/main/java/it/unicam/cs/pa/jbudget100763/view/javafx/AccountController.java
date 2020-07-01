/*
This file is part of JBudget.

    JBudget is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    JBudget is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with JBudget.  If not, see <https://www.gnu.org/licenses/>.
*/
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

/**
 * Gestisce i metodi chiamati dalla schermata di creazione di un conto,
 * indirizzandoli al controller MVC
 */
public class AccountController implements Initializable {
    private Controller controller = new Controller();

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