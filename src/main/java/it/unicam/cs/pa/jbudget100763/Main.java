package it.unicam.cs.pa.jbudget100763;

import it.unicam.cs.pa.jbudget100763.view.javafx.App;
import javafx.application.Application;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main  {
	
	 private static void launchGui() {
	        Application.launch(App.class);
	    }

	 public static void main(String[] args) {
		 launchGui();
		}

}