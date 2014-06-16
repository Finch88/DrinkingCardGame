package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class HomeScreen extends Round{

	public void setMessage(String message){
		super.message=message;
	}
	public String getMessage(){
		return super.message;
	}
	
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){

		System.out.println("Setting home screen");

		// Set general properties
		super.setButtonProperties(buttons);
		
		// Specific properties for each button
		buttons.get(0).setLabel("Play");
		buttons.get(0).setLocation(100,270);
		
		buttons.get(1).setLabel("Help");		
		buttons.get(1).setLocation(100,340);
		
		g.drawImage(images.get(0), 50, 50, 250, 200, null);
	}
	// Must be implemented but do nothing for this round
	public void playRound(Player player, String guess, Deck deck){}
	
}
