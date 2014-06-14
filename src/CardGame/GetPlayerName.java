package CardGame;

import java.awt.*;
import java.util.*;

public class GetPlayerName extends Round{

		public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){
			
			g.drawImage(images.get(0), 50, 50, 250, 200, null);

			g.setFont(textFont);
			g.drawString("Enter player name", 50, 270);
			
			textFields.get(0).setLocation(50,290);
			textFields.get(0).setSize(250, 30);
			textFields.get(0).setFont(textFont);
	        textFields.get(0).setVisible(true);
	        
			buttons.get(0).setSize(150,50);
			buttons.get(0).setFont(labelFont);
			buttons.get(0).setBackground(buttonColour);
			buttons.get(0).setForeground(fontColour);
			buttons.get(0).setLabel("Next!");
			buttons.get(0).setLocation(100,340);

			
		}

}