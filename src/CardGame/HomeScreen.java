package CardGame;

import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

public class HomeScreen extends Round{
		
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons){

		System.out.println("Setting home screen");

		// Set general properties
		for(int i=0; i<buttons.size(); i++){
			buttons.get(i).setSize(150,50);
			buttons.get(i).setFont(labelFont);
			buttons.get(i).setBackground(buttonColour);
			buttons.get(i).setForeground(fontColour);
			
		}
		
		// Specific properties for each button
		buttons.get(0).setLabel("Play");
		buttons.get(0).setLocation(100,270);
		
		buttons.get(1).setLabel("Help");		
		buttons.get(1).setLocation(100,340);
		
		g.drawImage(images.get(0), 50, 50, 250, 200, null);
	}
	
}
