package CardGame;

import java.awt.*;

public abstract class Round {

	public abstract void setScreen(Graphics g);
	
	public Card deal(){
		Card dealtCard = new Card();
		return dealtCard;
	}
}
