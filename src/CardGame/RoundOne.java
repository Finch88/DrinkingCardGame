package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class RoundOne extends Round{

	public void setMessage(String message){
		super.message=message;
	}
	public String getMessage(){
		return super.message;
	}
	
	// Function to setup the applet screen for this round
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){

		g.drawImage(images.get(0), 45, 20, 120, 160, null);
		g.drawImage(images.get(1), 185, 20, 120, 160, null);
		g.drawImage(images.get(2), 45, 200, 120, 160, null); //50, 170, 125, 370
		g.drawImage(images.get(3), 185, 200, 120, 160, null);
		
		g.setFont(textFont);
		g.drawString(this.getMessage(),45,400);
		
		super.setButtonProperties(buttons);
		// Specific properties for each button
		try{
			buttons.get(0).setLabel("RED");
		
			buttons.get(0).setSize(150,50);
			buttons.get(0).setLocation(20,425);
		
			buttons.get(1).setLabel("BLACK");
			buttons.get(1).setSize(150,50);
			buttons.get(1).setLocation(180,425);
		
			// Set location of next button for after playRound()
			buttons.get(2).setLocation(100,425);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Exception accessing buttons array in RoundOne.setScreen()");
		}
	}
	
	public void playRound(Player player, String guess, Deck deck){
		Card dealtCard=super.deal(deck);
		if (dealtCard.getFace()=="JK"){
			super.message="Unlucky- All Drink!";
		}
		else if(dealtCard.getColour()==guess){
			super.message="Correct- Nominate!";
		}
		else{
			super.message="Wrong- Drink!";
		}
		player.dealtCards.add(0,dealtCard);
	}
	
}
