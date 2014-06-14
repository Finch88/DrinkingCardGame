package CardGame;

import java.util.*;

// class to store information on a player
public class Player {
	private String name;	
	public ArrayList<Card> dealtCards = new ArrayList<Card>();
	
	Player(){
		this.name="player";
		// Add four blank cards to start with
		for(int i=0; i<4; i++){
			dealtCards.add(new Card());
		}
		
	}
	Player(String n){
		this.name=n;
		// Add four blank cards to start with
		for(int i=0; i<4; i++){
			dealtCards.add(new Card());
		}
	}
	
	public void setName(String Name){ this.name=Name; }
	public String getName(){ return this.name; }
}
