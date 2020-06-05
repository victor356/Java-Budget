package it.unicam.cs.pa.jbudget100763;

import java.util.Date;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
	static Date d=new Date();
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		Button btn1= new Button();
		btn1.setText("Tap here to shout 'Hello Unicam'!");
		btn1.setOnAction(this::doSomething);
		
		
		
		StackPane root= new StackPane();
		root.getChildren().add(btn1);  //layout
		
		Scene scene= new Scene(root,300,100);
		
		primaryStage.setTitle("Welcome");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	private void doSomething(ActionEvent actionEvent) {
		Label label=new Label("HELLOOO");
		Scene scene=new Scene(label,200,100);
		Stage secondStage=new Stage();
		secondStage.initModality(Modality.APPLICATION_MODAL);
		secondStage.initStyle(StageStyle.DECORATED);
		secondStage.setScene(scene);
		secondStage.show();
	}

	
	
	public static void main(String[] args) {
     System.out.println("Hello World!!!");
     System.out.println(d);
     launch(args);
     
 }

}