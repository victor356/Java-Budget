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
public class App extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;

	/**
	 * Ha il compito di avviare l'applicazione
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
	 * @throws IOException se non viene inserito un parametro adeguato nella
	 *                     schermata
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
	 * @throws IOException se non viene inserito un parametro adeguato nella
	 *                     schermata
	 */
	public static void showStart() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/Ledger.fxml"));
		primaryStage.setScene(new Scene(mainLayout));
	}

	/**
	 * Ha il compito di aprire la schermata dove è riassunta la gestione
	 * dell'account
	 * 
	 * @throws IOException se non viene inserito un parametro adeguato nella
	 *                     schermata
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
	 * 
	 * @throws IOException se non viene inserito un parametro adeguato nella
	 *                     schermata
	 */
	public static void createAccount() throws IOException {
		Stage addDialogStage = new Stage();

		mainLayout = FXMLLoader.load(App.class.getResource("/newAccount.fxml"));
		addDialogStage.setTitle("Add New Account");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		addDialogStage.setScene(new Scene(mainLayout));
		addDialogStage.showAndWait();
	}

	/**
	 * Ha il compito di aprire la schermata dove è riassunta la gestione dei tag
	 * 
	 * @throws IOException se non viene inserito un parametro adeguato nella
	 *                     schermata
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
	 * 
	 * @throws IOException se non viene inserito un parametro adeguato nella
	 *                     schermata
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
