package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.ResourceBundle;

import it.unicam.cs.pa.jbudget100763.controller.Controller;
import it.unicam.cs.pa.jbudget100763.model.Account;
import it.unicam.cs.pa.jbudget100763.model.AccountImpl;
import it.unicam.cs.pa.jbudget100763.model.AccountType;
import it.unicam.cs.pa.jbudget100763.model.LedgerImpl;
import it.unicam.cs.pa.jbudget100763.model.Tag;
import it.unicam.cs.pa.jbudget100763.model.TagImpl;
import it.unicam.cs.pa.jbudget100763.view.View;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Ha la responsabilit� di caricare le schermate da avviare e raccogliere tutte
 * le interazioni dell'utente tramite la javaFX GUI e di inoltrarle al
 * controller dell'applicazione
 * 
 * @author Vittorio
 *
 */
public class FxController implements Initializable,View {

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
	public
	 void manageAccount() throws IOException {
		App.manageAccount();
	}

	@FXML
	public void createAccount() throws IOException {
		App.createAccount();
	}

	/**
	 * Manage account fields
	 */
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

	ObservableList<Account> accounts = FXCollections.observableArrayList(controller.getAccounts());

	/**
	 * Match delle colonne della tabella con gli attributi delle classi
	 */
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

	/**
	 * new account fields
	 */
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

	/**
	 * mostra i tipi di account nel choicebox
	 */
	@FXML
	private void typeScroll() {
		accountTypeField.setItems((ObservableList<AccountType>) accountChoice);

	}

	@FXML
	private void newAccount() {
		accountTable.getItems().add(new AccountImpl(accountTypeField.getValue(), accountNameField.getText(),
				Double.parseDouble(accountOpeningBalanceField.getText()), accountDescriptionField.getText()));
		// accounts.add(new AccountImpl(accountTypeField.getValue(),
		// accountNameField.getText(),
		// Double.parseDouble(accountOpeningBalanceField.getText()),
		// accountDescriptionField.getText()));
		controller.addAccount(accountTypeField.getValue(), accountNameField.getText(),
				accountDescriptionField.getText(), Double.parseDouble(accountOpeningBalanceField.getText()));

		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();

	}

	@FXML
	public void deleteAccount() {
		controller.removeAccount(accountTable.getSelectionModel().getSelectedItem());
		controller.getAccounts().removeIf((Account o) -> o == accountTable.getSelectionModel().getSelectedItem());
		accountTable.getItems().removeAll(accountTable.getSelectionModel().getSelectedItem());

	}

	/**
	 * closes the window
	 */
	@FXML
	private void closeButtonAction() {

		Stage stage = (Stage) closeButton.getScene().getWindow();
		stage.close();
	}

	ObservableList<Tag> tags = FXCollections.observableArrayList(controller.getTags());

	/**
	 * tag table management
	 */
	@FXML
	public void manageTag() throws IOException {
		App.manageTag();

	}

	@FXML
	public void createTag() throws IOException {
		App.createTag();
	}

	@FXML
	private TableView<Tag> tagTable = new TableView<Tag>();

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
		controller.getTags().removeIf(o -> o == tagTable.getSelectionModel().getSelectedItem());
		tagTable.getItems().removeAll(tagTable.getSelectionModel().getSelectedItem());

	}
}
