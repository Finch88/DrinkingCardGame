package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class NumberPlayersScreen extends Round{

	public void setMessage(String message){
		super.message=message;
	}
	public String getMessage(){
		return super.message;
	}
	
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){
		g.drawImage(images.get(0), 50, 50, 250, 200, null);

		textFields.get(0).setLocation(50,270);
		textFields.get(0).setSize(250, 30);
		textFields.get(0).setFont(textFont);
		//textFields.get(0).setText("How many players?");
        textFields.get(0).setVisible(true);
        
		buttons.get(0).setSize(150,50);
		buttons.get(0).setFont(labelFont);
		buttons.get(0).setBackground(buttonColour);
		buttons.get(0).setForeground(fontColour);
		buttons.get(0).setLabel("Go!");
		buttons.get(0).setLocation(100,320);
	}
	// Must be implemented but do nothing for this round
	public void playRound(Player player, String guess, Deck deck){}

}
