import javafx.*;

public class Window extends Application{
	
	Button button;
	
	public static void main(String[] args){
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("chatt");
		
		button = new Button();
		button.setText("klicka");
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 200, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}