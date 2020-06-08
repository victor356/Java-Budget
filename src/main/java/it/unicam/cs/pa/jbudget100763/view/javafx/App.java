package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;

import it.unicam.cs.pa.jbudget100763.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Applicazione principale dell'implementazione tramite javaFX
 * 
 * @author Vittorio
 *
 */
public class App extends Application  {
	private static Stage primaryStage;
	private static BorderPane mainLayout;

	/**
	 * Ha il compito di aprire la schermata d'avvio dell'applicazione
	 */
	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		primaryStage.setTitle("JBudget");

		showHome();

	}

	/**
	 * Ha il compito di aprire la schermata principale dell'applicazione
	 * 
	 * @throws IOException
	 */
	public static void showHome() throws IOException {

		mainLayout = (BorderPane) FXMLLoader.load(App.class.getResource("/Home.fxml"));
		primaryStage.setScene(new Scene(mainLayout));
		primaryStage.show();
	}

	/**
	 * Ha il compito di aprire la schermata in cui sono riassunte le funzioni del
	 * ledger
	 * 
	 * @throws IOException
	 */
	public static void showStart() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/Ledger.fxml"));
		primaryStage.setScene(new Scene(mainLayout));
	}

	/**
	 * Ha il compito di aprire la schermata dove è riassunta la gestione
	 * dell'account
	 * 
	 * @throws IOException
	 */
	public static void manageAccount() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/AccountSettings.fxml"));
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Account Settings");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		addDialogStage.setScene(new Scene(mainLayout));
		addDialogStage.showAndWait();
	}
/**
 * Creazione schermata per creare un account
 * @throws IOException
 */
	public static void createAccount() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/newAccount.fxml"));
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Account");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		addDialogStage.setScene(new Scene(mainLayout));
		addDialogStage.showAndWait();
	}
	
	
	/**
	 * Ha il compito di aprire la schermata dove è riassunta la gestione
	 * dei tag
	 * @throws IOException
	 */
	public static void manageTag() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/TagSettings.fxml"));
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Tag Settings");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		addDialogStage.setScene(new Scene(mainLayout));
		addDialogStage.showAndWait();
	}
/**
 * Ha il compito di aprire la schermata dove si crea un nuovo tag
 * @throws IOException
 */
	public static void createTag() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/newTag.fxml"));
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Tag");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		addDialogStage.setScene(new Scene(mainLayout));
		addDialogStage.showAndWait();
	}

}
