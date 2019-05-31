package rpg4;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import rpg3.Monster;

public class ControllerFight {
	
	
	public ProgressBar heroHp,heroMp,enemyHp,enemyMp;
	
	public ImageView player, enemy;
	
	public Hero hero;
	public Monster monster;
	
	
	public Button itemButton,fightButton,runButton;
	
	public Pane pane;
	
	public String move1,move2;
	
	public double monsterHitpoints, heroHitpoints;

	
	public void initialize() throws Exception {

		hero = new Hero("Tim",50,30.00,12.00);
		heroHitpoints = hero.getHitpoints();
		hero.setProtection(25);
		
		
		hero.strengthCapacity();
	
		
		Weapon weapon = new Weapon(12, "Sword of Jus tice");
		Armor armor = new Armor(123456,1, "Light armor",  5.00);
		Armor armor2  = new Armor(789101,2,"Medium armor", 8.00);
		weapon.setDamage(205);
		hero.pickUpItem(armor);
		hero.pickUpItem(weapon);
		hero.pickUpItem(armor2);
		
		

		monster = new Monster("U 'gando", 6, 15, 45, 6.5, 8, 15);
		
		monsterHitpoints = monster.getHitpoints();
		
		
		heroHp.setProgress(100);
		heroMp.setProgress(100);
		enemyHp.setProgress(100);
		enemyMp.setProgress(100);
		player.setImage(new Image("rpg4/images/"+ControllerStart.selected+".PNG"));
		
		
		switch (ControllerStart.selected) {
		case "warrior": move1 = "Swing"; move2 = "Bash";
			
			break;
		case "mage": move1 = "Bolt"; move2 = "Icicle";
					
			break;
		case "assassin": move1 = "Shank"; move2 = "Snipe";
			
			break;
		default:
			break;
		}
		
	}
	
	
	
	
	public void run(ActionEvent event) throws IOException
	{
		if(hero.getSpeed()>monster.getSpeed()) {
			Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
			Scene scene = new Scene(root);
			Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			stage.setScene(scene);
		}
	}

	public void showItems(ActionEvent event)
	{
		itemButton.setVisible(false);
		runButton.setVisible(false);
		fightButton.setVisible(false);
		pane.getChildren().clear();
		int position = 0;
		for(int i=0;i<Anchors.values().length;i++) {
			Item item =  null;
		
			
				
				item = hero.getListOfItems().get(Anchors.values()[i]);
			if(item !=null) {
				
		
				String name = item.getName();
		
				Button button = new Button(name);
				button.setLayoutY(position);
				button.setLayoutX(20);
				pane.getChildren().add(button);
				position += 30;
			}
		}
		Button back = new Button("Go back");
		pane.setVisible(true);
		back.setOnMouseClicked((e) -> {
			
			back();
			pane.setVisible(false);
		});
		back.setLayoutX(130);
		pane.getChildren().add(back);
		
		
	}
		
	public void showFight(ActionEvent event)
	{
		itemButton.setVisible(false);
		runButton.setVisible(false);
		fightButton.setVisible(false);
		pane.getChildren().clear();
		

		
		Button basic = new Button(move1);
		basic.setLayoutX(50);
		basic.setPrefWidth(100);

		basic.setOnMouseClicked((e) -> {
			
			fight(hero,monster);
			double percentage = monsterHitpoints/monster.getHitpoints();
			System.out.println(percentage);
		});
		Button special = new Button(move2);
		special.setPrefWidth(100);
		special.setLayoutX(50);
		special.setLayoutY(30);
		pane.getChildren().add(basic);
		pane.getChildren().add(special);
		pane.setVisible(true);
		
		
	}
	
	public void fight(Entity entity1, Entity entity2) {
	
			
	}
	
	public void back()
	{
		itemButton.setVisible(true);
		runButton.setVisible(true);
		fightButton.setVisible(true);
		pane.setVisible(false);
		
		
		
	}
	
	

	

}
