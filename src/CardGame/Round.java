package CardGame;

import java.awt.*;
import java.util.ArrayList;

public abstract class Round {

	// Setting fonts and colors for buttons
	// Should be consistent in all rounds
	Font labelFont =  new Font("sansserif",Font.BOLD,32);
	Font textFont =  new Font("sansserif",Font.BOLD,18);
		
	Color bkgColour;
	Color buttonColour  = new Color(50,220,74);
	Color fontColour  = new Color(107,19,107);
	
	public abstract void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields);
	
	public Card deal(){
		Card dealtCard = new Card();
		return dealtCard;
	}
}
