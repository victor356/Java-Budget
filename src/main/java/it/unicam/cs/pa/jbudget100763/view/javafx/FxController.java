package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Observable;

import it.unicam.cs.pa.jbudget100763.model.AccountType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FxController {

	@FXML
	private void start() throws IOException {
		App.showStart();
	}

	@FXML
	private void backHome() throws IOException {
		App.showHome();
	}

	@FXML
	private void manageAccount() throws IOException {
		App.manageAccount();
	}

	@FXML
	private void createAccount() throws IOException {
		App.createAccount();
	}

	// New Account Stage

	@FXML
	private TextField accountNameField;

	@FXML
	private TextField accountDescriptionField;

	@FXML
	private ChoiceBox accountTypeField;

	ObservableList<AccountType> accountChoice = FXCollections
			.observableArrayList(new ArrayList<AccountType>(EnumSet.allOf(AccountType.class)));

	@FXML
	private TextField accountOpeningBalanceField;

	@FXML
	private void typeScroll() {
		accountTypeField.setItems(accountChoice);
	}
}
