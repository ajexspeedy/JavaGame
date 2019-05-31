package rpg4;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class ControllerStart {
	
	public ImageView Warrior, Mage, Assassin;
	
	public Label warriorlabel, magelabel, assassinlabel;
	
	public static String selected;
	
	
	
	public void handleButtonAction(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
        Scene game = new Scene(root);
      
	    Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    stageTheEventSourceNodeBelongs.setScene(game);
	   
	    
		System.out.println("Het werkt");
		
		
		
	
		
	}
	
	
	public void selectWarrior()
	{
		System.out.println("test");
		warriorlabel.getStyleClass().add("select");
		magelabel.getStyleClass().remove("select");
		assassinlabel.getStyleClass().remove("select");
		selected = "warrior";
		
	}
	public void selectMage()
	{
		System.out.println("test");
		magelabel.getStyleClass().add("select");
		warriorlabel.getStyleClass().remove("select");
		assassinlabel.getStyleClass().remove("select");
		selected = "mage";
	}
	public void selectAssassin()
	{
		System.out.println("test");
		assassinlabel.getStyleClass().add("select");
		warriorlabel.getStyleClass().remove("select");
		magelabel.getStyleClass().remove("select");
		selected = "assassin";
	}
	
	public void initialize() {
		warriorlabel.getStyleClass().add("select");
		selected = "warrior";
	}
}
