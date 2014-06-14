package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class RoundOne extends Round{

	// Function to setup the applet screen for this round
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){

		//g.drawImage(images.get(0), 50, 50, 125, 150, null);
		//g.drawImage(images.get(1), 175, 50, 250, 150, null);
		g.drawImage(images.get(2), 50, 170, 125, 370, null);
		//g.drawImage(images.get(3), 150, 170, 225, 370, null);
		
	}
	
}
