package CardGame;

import java.awt.*;
import java.util.ArrayList;

public class PartTwo extends Round{

	public void setMessage(String message){
		super.message=message;
	}
	public String getMessage(){
		return super.message;
	}
	
	public void newCard(){
		this.PartTwoCard= new Card();
	}
	// Function to setup the applet screen for this round
	public void setScreen(Graphics g, ArrayList<Image> images, ArrayList<Button> buttons, ArrayList<TextField> textFields){
		g.drawImage(images.get(0), 100, 50, 150, 200, null);
		
		int pos=300;
		
		g.setFont(textFont);
		g.drawString(this.getMessage(),45,pos);

		for(TextField tf:textFields){
			pos+=30;
			System.out.println(tf.getText());
			tf.setLocation(50,pos);
			tf.setSize(250, 30);
			tf.setFont(textFont);
			tf.setVisible(true);
			g.drawString(tf.getText(),45,pos);
			
		}
		
		super.setButtonProperties(buttons);

		buttons.get(0).setLocation(100,425);

	}
	public void playRound(Player player, String guess, Deck deck){
		this.PartTwoCard=super.deal(deck);
		
		if(PartTwoCard.getFace()=="JK"){
			super.message="Unlucky- All Drink!";
		}
		
	}

}
