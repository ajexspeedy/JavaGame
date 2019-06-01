package JavaGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import rpg3.Monster;


	
	




	public class Main extends Application {
		

		
		Scene start, game;
		
	    @Override
	    public void start(Stage primaryStage) throws Exception{
	        Parent root = FXMLLoader.load(getClass().getResource("game_start.fxml"));
	        start = new Scene(root);
	        primaryStage.setTitle("Game");
	        primaryStage.setScene(start);
	        primaryStage.show();
	        
	    }

	    public static void main(String[] args) {
	        launch(args);
	        
	        
	        
	    }
		
	  
	
	


}
