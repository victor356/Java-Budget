package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.ResourceBundle;

import it.unicam.cs.pa.jbudget100763.controller.Controller;
import it.unicam.cs.pa.jbudget100763.controller.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountImpl;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.Tag;
import it.unicam.cs.pa.jbudget100763.model.TagImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FxController implements Initializable {

	Controller controller = new Controller();

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

	// /**
	// * View Account fields
	// */
	@FXML
	private TableView<Account> accountTable = new TableView<Account>();

	@FXML
	private TableColumn<Account, String> AccountName = new TableColumn<Account, String>();
	@FXML
	private TableColumn<Account, String> AccountDesc = new TableColumn<Account, String>();

	@FXML
	private TableColumn<Account, AccountType> Type = new TableColumn<Account, AccountType>();

	@FXML
	private TableColumn<Account, Double> AccountOpeningB = new TableColumn<Account, Double>();

	@FXML
	private TableColumn<Account, Double> AccountB = new TableColumn<Account, Double>();

	ObservableList<Account> accounts = FXCollections.observableArrayList(LedgerImpl.getInstance().getAccounts());

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		AccountName.setCellValueFactory(new PropertyValueFactory<Account, String>("name"));
		AccountDesc.setCellValueFactory(new PropertyValueFactory<Account, String>("description"));
		Type.setCellValueFactory(new PropertyValueFactory<Account, AccountType>("type"));
		AccountOpeningB.setCellValueFactory(new PropertyValueFactory<Account, Double>("openingBalance"));
		AccountB.setCellValueFactory(new PropertyValueFactory<Account, Double>("balance"));
		accountTable.getItems().addAll(accounts);
		// tag
		
		tagName.setCellValueFactory(new PropertyValueFactory<Tag, String>("name"));
		tagDescription.setCellValueFactory(new PropertyValueFactory<Tag, String>("description"));
		tagTable.getItems().addAll(tags);
	}

	// /**
	// * New Account tool fields
	// */

	@FXML
	private Button alertButton;

	@FXML
	private Button closeButton;

	@FXML
	private TextField accountNameField = new TextField();

	@FXML
	private TextField accountDescriptionField = new TextField();

	@FXML
	private TextField accountOpeningBalanceField = new TextField();

	@FXML
	private ChoiceBox<AccountType> accountTypeField = new ChoiceBox<AccountType>();;

	ObservableList<AccountType> accountChoice = FXCollections
			.observableArrayList(new ArrayList<AccountType>(EnumSet.allOf(AccountType.class)));

	// /**
	// * shows the account types on ChoiceBox
	// */
	@FXML
	private void typeScroll() {
		accountTypeField.setItems((ObservableList<AccountType>) accountChoice);

	}

	@FXML
	private void newAccount() {
		 accountTable.getItems().add(new AccountImpl(accountTypeField.getValue(), accountNameField.getText(),
		 		Double.parseDouble(accountOpeningBalanceField.getText()), accountDescriptionField.getText()));

		LedgerImpl.getInstance().addAccount(accountTypeField.getValue(), accountNameField.getText(),
				accountDescriptionField.getText(), Double.parseDouble(accountOpeningBalanceField.getText()));

		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();

	}

	@FXML
	private void deleteAccount() {
		LedgerImpl.getInstance().getTags().removeIf(o->o==accountTable.getSelectionModel().getSelectedItem());
		accountTable.getItems().removeAll(accountTable.getSelectionModel().getSelectedItem());
	}

	/**
	 * closes the window
	 */
	@FXML
	private void closeButtonAction() {
		// get a handle to the stage
		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	ObservableList<Tag> tags = FXCollections.observableArrayList(LedgerImpl.getInstance().getTags());

	/**
	 * tag table
	 */
	@FXML
	private void manageTag() throws IOException {
		App.manageTag();

	}

	@FXML
	private void createTag() throws IOException {
		App.createTag();
	}

	@FXML
	private TableView<Tag> tagTable= new TableView<Tag>();

	@FXML
	private TableColumn<Tag, String> tagName = new TableColumn<Tag, String>();

	@FXML
	private TableColumn<Tag, String> tagDescription = new TableColumn<Tag, String>();

	/**
	 * new Tag scene
	 */

	@FXML
	private TextField tagNameField = new TextField();

	@FXML
	private TextField TagDescriptionField = new TextField();

	@FXML
	void newTag() {
		Tag t = new TagImpl(tagNameField.getText(), TagDescriptionField.getText());
		LedgerImpl.getInstance().getTags().add(t);
		tagTable.getItems().add(t);

		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	@FXML
	private void deleteTag() {
		LedgerImpl.getInstance().getTags().removeIf(o->o==tagTable.getSelectionModel().getSelectedItem());
		tagTable.getItems().removeAll(tagTable.getSelectionModel().getSelectedItem());
	

	}

	// // @Override
	// // public void initialize(URL location, ResourceBundle resources) {
	// // AccountName.setCellValueFactory(new PropertyValueFactory<>("name"));
	// // AccountDesc.setCellValueFactory(new
	// PropertyValueFactory<>("description"));
	// // AccountType.setCellValueFactory(new PropertyValueFactory<>("type"));
	// // AccountOpeningB.setCellValueFactory(new
	// PropertyValueFactory<>("openingBalance"));
	// // AccountB.setCellValueFactory(new PropertyValueFactory<>("balance"));
	// // accountTable.setItems(accounts);
	// }
	//

	// @FXML
	// private void askAlert() {
	// Stage stage = (Stage) closeButton.getScene().getWindow();

	// Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	// alert.setTitle("Alert");
	// alert.setContentText("Are you sure?");
	// ButtonType okButton = new ButtonType("YES", ButtonBar.ButtonData.YES);
	// ButtonType cancelButton = new ButtonType("NO", ButtonBar.ButtonData.NO);
	// alert.getButtonTypes().setAll(okButton, cancelButton);
	// alert.showAndWait().ifPresent(type -> {

	// if (type == ButtonType.OK) {
	// newAccount();

	// }
	// ;
	// });
	// }

	//

}
