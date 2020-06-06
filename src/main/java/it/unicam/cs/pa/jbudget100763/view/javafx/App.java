package it.unicam.cs.pa.jbudget100763.view.javafx;

import java.io.IOException;

import it.unicam.cs.pa.jbudget100763.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class App extends Application implements View {
	private static Stage primaryStage;
	private static BorderPane mainLayout;

	@Override
	public void start(Stage stage) throws IOException {
		primaryStage = stage;
		primaryStage.setTitle("JBudget");

		showHome();

	}

	public static void showHome() throws IOException {

		mainLayout = (BorderPane) FXMLLoader.load(App.class.getResource("/Home.fxml"));
		primaryStage.setScene(new Scene(mainLayout));
		primaryStage.show();
	}

	public static void showStart() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/Ledger.fxml"));
		primaryStage.setScene(new Scene(mainLayout));
	}
	
	public static void manageAccount() throws IOException {

		mainLayout = FXMLLoader.load(App.class.getResource("/ManageAccount.fxml"));
		Stage addDialogStage= new Stage();
		addDialogStage.setTitle("Add New Account");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		addDialogStage.setScene(new Scene(mainLayout));
		addDialogStage.showAndWait();
	}
	
	
	
}

/*
 * @Override public void start(Stage primaryStage) throws Exception { Button
 * btn1 = new Button(); btn1.setText("Tap here to shout 'enjoy'!");
 * btn1.setOnAction(this::doSomething);
 * 
 * Button btn2 = new Button(); btn2.setText("press here");
 * btn2.setOnAction(this::colorCircle);
 * 
 * GridPane root = new GridPane(); GridPane.setRowIndex(btn2, 0);
 * GridPane.setColumnIndex(btn2, 2);
 * 
 * root.getChildren().add(btn1); // layout root.getChildren().add(btn2); //
 * layout btn2.setLayoutX(0); btn2.setLayoutY(0);
 * 
 * Scene scene = new Scene(root, 300, 100);
 * 
 * primaryStage.setTitle("Welcome"); primaryStage.setScene(scene);
 * primaryStage.show();
 * 
 * }
 * 
 * private void doSomething(ActionEvent actionEvent) { Label label = new
 * Label("HELLOOO");
 * 
 * Scene scene = new Scene(label, 200, 100); Stage secondStage = new Stage();
 * secondStage.initModality(Modality.APPLICATION_MODAL);
 * secondStage.initStyle(StageStyle.DECORATED); secondStage.setScene(scene);
 * secondStage.show(); }
 * 
 * private void colorCircle(ActionEvent actionEvent) { Stage secondStage = new
 * Stage(); // Drawing a Circle Circle circle = new Circle();
 * 
 * // Setting the position of the circle circle.setCenterX(300.0f);
 * circle.setCenterY(135.0f);
 * 
 * // Setting the radius of the circle circle.setRadius(25.0f);
 * 
 * // Setting the color of the circle circle.setFill(Color.BROWN);
 * 
 * // Setting the stroke width of the circle circle.setStrokeWidth(20);
 * 
 * // Setting the text Text text = new
 * Text("Keep shift and click on the circle to change its color");
 * 
 * // Setting the font of the text text.setFont(Font.font(null, FontWeight.BOLD,
 * 15));
 * 
 * // Setting the color of the text text.setFill(Color.CRIMSON);
 * 
 * // setting the position of the text text.setX(150); text.setY(50);
 * 
 * // Creating the mouse event handler EventHandler<MouseEvent> eventHandler =
 * new EventHandler<MouseEvent>() { private boolean flag = true;
 * 
 * @Override public void handle(MouseEvent e) { if(!e.isShiftDown()) {
 * System.out.println("è necessario premere shift e cliccare"); }else {
 * 
 * if (flag) { circle.setFill(Color.AZURE); flag = !flag; } else {
 * circle.setFill(Color.RED); flag = !flag; } }} }; // Registering the event
 * filter circle.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
 * 
 * // Creating a Group object Group root = new Group(circle, text);
 * 
 * // Creating a scene object Scene scene = new Scene(root, 600, 300);
 * 
 * // Setting the fill color to the scene scene.setFill(Color.LAVENDER);
 * 
 * // Setting title to the Stage secondStage.setTitle("Event Filters Example");
 * 
 * // Adding scene to the stage secondStage.setScene(scene);
 * 
 * // Displaying the contents of the stage secondStage.show(); }
 */