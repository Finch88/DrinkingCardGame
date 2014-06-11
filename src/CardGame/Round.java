package CardGame;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public abstract class Round {

	// Setting fonts and colors for buttons
	// Should be consistent in all rounds
	Font labelFont =  new Font("sansserif",Font.BOLD,32);;
	Color bkgColour;
	Color buttonColour  = new Color(50,220,74);
	Color fontColour  = new Color(107,19,107);
	
	public abstract void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons);
	
	public Card deal(){
		Card dealtCard = new Card();
		return dealtCard;
	}
}
