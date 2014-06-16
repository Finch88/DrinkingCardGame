package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class PartTwo extends Round{

	PartTwo(){
		this.PartTwoCard = new Card();
	}
	public void setMessage(String message){
		super.message=message;
	}
	public String getMessage(){
		return super.message;
	}
	
	// Function to setup the applet screen for this round
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){
		g.drawImage(images.get(0), 100, 50, 150, 200, null);
		
		g.setFont(textFont);
		g.drawString(this.getMessage(),45,400);

		super.setButtonProperties(buttons);

		buttons.get(0).setLocation(100,425);

	}
	public void playRound(Player player, String guess, Deck deck){
		
	}

}
