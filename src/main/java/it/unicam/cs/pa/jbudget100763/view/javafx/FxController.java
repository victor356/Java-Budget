package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;

import javafx.fxml.FXML;

public class FxController {
	private App main;
	
	@FXML
	private void start() throws IOException {
		main.showStart();
	}
	
	
}
