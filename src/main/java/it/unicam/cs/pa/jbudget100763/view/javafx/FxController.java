package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;

import javafx.fxml.FXML;

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
	
	
	
	
}
