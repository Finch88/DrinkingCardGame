package CardGame;

import java.util.*;

// class to handle the full deck of cards
public class Deck {
	
	// Array of cards ("the deck")
	public ArrayList<Card> cards = new ArrayList<Card>();
	
	//Constructor: initialise the deck
	Deck(){
		String[] suits={"H","C","D","S"};
		String[] faces={"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		
		for(String suit:suits){
			for(String face:faces){
				cards.add(new Card(face,suit));
			}
		}
		cards.add(new Card("JK","R"));
		cards.add(new Card("JK","B"));
	}

	public int getSize(){
		return cards.size();
	}
	
	public Card getCard(int index){
		return cards.get(index);
	}
	// remove a card from the deck after it is dealt
	public void removeCard(int index){
		cards.remove(index);
	}

}
