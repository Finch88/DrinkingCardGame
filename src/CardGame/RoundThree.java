package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class RoundThree extends Round{

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
			buttons.get(0).setLabel("IN");
		
			buttons.get(0).setSize(150,50);
			buttons.get(0).setLocation(20,425);
		
			buttons.get(1).setLabel("OUT");
			buttons.get(1).setSize(150,50);
			buttons.get(1).setLocation(180,425);
		
			// Set location of next button for after playRound()
			buttons.get(2).setLocation(100,425);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Exception accessing buttons array in RoundThree.setScreen()");
		}		
	}

	public void playRound(Player player, String guess, Deck deck){
		Card dealtCard=super.deal(deck);
		Card firstCard=player.dealtCards.get(0);
		Card secondCard=player.dealtCards.get(1);
		
		int low,high;
		// Get low number and high number of previous cards
		if(firstCard.getValue()<secondCard.getValue()){
			low=firstCard.getValue();
			high=secondCard.getValue();
		}
		else{
			low=secondCard.getValue();
			high=firstCard.getValue();
		}
		
		if(firstCard.getFace()=="JK"||secondCard.getFace()=="JK"){
			super.message="You can't win with a joker- Drink!";
		}
		else if(dealtCard.getFace()=="JK"){
			super.message="Unlucky- All Drink!";
		}
		else if((dealtCard.getValue()>low&&dealtCard.getValue()<high&&guess=="IN")||
				((dealtCard.getValue()<low||dealtCard.getValue()>high)&&guess=="OUT"))
		{
			super.message="Correct- Nominate!";
		}
		else{
			super.message="Wrong- Drink!";
		}
		player.dealtCards.add(2,dealtCard);
	}
}
