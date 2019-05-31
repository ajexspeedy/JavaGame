package rpg4;


import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Controller{
	
	public Button startknop, moveknop, button;
	public Label label;
	public ImageView hero, enemy, background;
	
	public boolean goNorth, goSouth, goEast, goWest;
	public boolean move;
	
	public double width, height;
	
	public Timeline movement;
	
	public String selected;
	
	public int s;
	


	
	

	

	
	
	
	public void handleOtherButtonAction(ActionEvent event) throws Exception
	{
		
		Parent root = FXMLLoader.load(getClass().getResource("game_start.fxml"));
        Scene game = new Scene(root);
        
	    Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    // OR
	    
	    // Swap screen
	    stageTheEventSourceNodeBelongs.setScene(game);
		System.out.println("Het werkt");
		
		
	}

	public void move(ActionEvent event) {
		moveknop.setVisible(false);
		button.setVisible(false);
		
		 move = true;
       
	    Stage stageTheEventSourceNodeBelongs = (Stage) ((Node)event.getSource()).getScene().getWindow();
		stageTheEventSourceNodeBelongs.getScene().setOnKeyPressed(new EventHandler <KeyEvent>() {
		ActionEvent	event2 = event;
		
				 @Override
		            public void handle(KeyEvent event) {
					 
					 
					
		                switch (event.getCode()) {
		                    case UP:    
		                    			
		                    		if(move) {
		               
		                    			hero.setLayoutY(hero.getLayoutY()-5);
		                    			
		                    			move = false;
		                    			movement.playFromStart();
		                    			
		                    			if(collisionHero()) {
		                    				
		                    				try {
												battle(event2);
											} catch (IOException e) {
												// TODO Auto-generated catch block
												e.printStackTrace();
											}
											
		                    			}
		                    			
		            					
		                    		}
		                    			
		                    			break;
		                    case DOWN:  
			                    	if(move) {
	                    		
	                    			hero.setLayoutY(hero.getLayoutY()+5);
	                    			move = false;
	                    			movement.playFromStart();
	                    			if(collisionHero()) {
	                    				
	                    				try {
											battle(event2);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
	                    			}
	                    			
                    		} break;
		                    case LEFT:  
		                    	
		                    		if(move){
		                    		hero.setLayoutX(hero.getLayoutX()-5);
		                    		
		                    		move = false;
		                    		movement.playFromStart();
		                    		if(collisionHero()) {
		                    			
		                    			try {
											battle(event2);
										} catch (IOException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
	                    			}
	                    			
		                    		}
		                    		break;
		                    case RIGHT: 
		                    		
		                    		if(move) {
		                    		hero.setLayoutX(hero.getLayoutX()+5);
		                    		
		                    		move = false;
		                    		movement.playFromStart();
			                    		if(collisionHero()) {
			                    			
												try {
													battle(event2);
												} catch (IOException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
											
		                    			}
			                   
		                    		}
		                    		break;
		                 
						default: System.out.println("Er is iets foutgelopen");
							break;
		                    
		                }
					 
					}
				
			});
	    
		
		}

	
	public void battle(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("game_fight.fxml"));
        Scene game = new Scene(root);
        
   
	    Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    stage.setScene(game);
	    
		System.out.println("Het werkt");
	}
	
	

	public boolean collisionHero()
	{
		double enemyx1, enemyx2, enemyy1,enemyy2;
		enemyx1 = enemy.getLayoutX();
		enemyx2 = enemyx1-enemy.getImage().getWidth();
		enemyy1 = enemy.getLayoutY();
		enemyy2 = enemyy1+enemy.getImage().getHeight();
		
	
		
		
		double herox1, herox2, heroy1,heroy2;
		herox1 = hero.getLayoutX();
		herox2 = herox1-hero.getImage().getWidth();
		heroy1 = hero.getLayoutY();
		heroy2 = heroy1+hero.getImage().getHeight();
	
		
		if((herox1>=enemyx2&&herox1<=enemyx1)||(herox2>=enemyx2&&herox2<=enemyx1)) {
			if(heroy1>enemyy1&&heroy1<enemyy2) {
				return true;
			}
			else if(heroy2>enemyy1&&heroy2<enemyy2) {
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
			
		
	
	}


	public void puls() {
		this.move = true;
	}

	


	
	public void initialize() 
	{
		movement = new Timeline(new KeyFrame(Duration.seconds(0.01), ob-> puls()));
		
	
		movement.setCycleCount(Animation.INDEFINITE);
		
		Image image = new Image("rpg4/images/"+ControllerStart.selected+".PNG");
		hero.setImage(image);
		hero.setFitWidth(73);
		enemy.setFitWidth(73);
		hero.setFitHeight(100);
		enemy.setFitHeight(100);
		
	}
	
	
	







	
	
	
	
}
