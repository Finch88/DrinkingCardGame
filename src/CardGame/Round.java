package CardGame;

import java.awt.*;
import java.util.ArrayList;

public abstract class Round {

	// Setting fonts and colors for buttons
	// Should be consistent in all rounds
	Font labelFont =  new Font("sansserif",Font.BOLD,32);
	Font smallLabelFont = new Font("sansserif",Font.BOLD,28);
	Font textFont =  new Font("sansserif",Font.BOLD,18);
		
	protected static String message="Default Message"; // Message to display, i.e. prompting for guess or showing result.
	public abstract void setMessage(String message);
	public abstract String getMessage();
	Color bkgColour;
	Color buttonColour  = new Color(50,220,74);
	Color fontColour  = new Color(107,19,107);
	
	public Card PartTwoCard;
	
	public abstract void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields);
	
	public abstract void playRound(Player player, String guess, Deck deck);
	
	// Method to set general properties of buttons common to all
	public void setButtonProperties(ArrayList<Button> buttons){
		for(int i=0; i<buttons.size(); i++){
			buttons.get(i).setSize(150,50);
			buttons.get(i).setFont(labelFont);
			buttons.get(i).setBackground(buttonColour);
			buttons.get(i).setForeground(fontColour);			
		}
	}
	
	public Card deal(Deck deck){
		Card dealtCard = new Card();
		System.out.println(deck.getSize());
		int index = (int)(Math.random()*deck.getSize());
		dealtCard=deck.getCard(index);
		deck.removeCard(index);
		System.out.println(dealtCard.getName());
		return dealtCard;
	}
}
