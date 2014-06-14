package CardGame;

import java.awt.Image;
import java.io.IOException;
import java.net.*;

import javax.imageio.ImageIO;

// This class stores information about a card
public class Card{

	public static final long serialVersionUID=42L;
	// Private member variables
	private String face; // face value of card, i.e. 2-10, J, Q, K, A or JK for joker
	private String suit; // options are "H", "D", "C" and "S" or R/B for joker (red/black"
	private String name; // Name is face + suit, i.e. "2H", "AD" etc.
	private int value; // Numerical value of the card, J=11, Q=12, K=13, A=1 or 14
	private String colour; // colour of card
	private URL imageURL; //URL of image associated with card
	private Image image; // image associated with card
	
	public static String urlBase="file:/E:/Documents/Projects/Java/DrinkingCardGame/pics/";

	//Constructors
	Card(){
		setFace("N"); //null card
		setSuit("B"); // back of card
	}
	
	Card(String face, String suit){
		setFace(face);
		setSuit(suit);
	}
	
	// Functions to access the private member variables
	public String getName(){ return this.name; }
	public String getFace(){ return this.face; }
	public String getSuit(){ return this.suit; }
	public int getValue(){ return this.value; }
	public String getColor(){ return this.colour; }
	public URL getImageURL(){ return this.imageURL; }
	public Image getImage(){ return this.image; }
	
	// Functions for setting the private member variables and updating related variables
	public void setFace(String Face){
		this.face=Face;
		setName();
		setImageURL();
		setValue();
	}
	
	public void setSuit(String Suit){
		this.suit=Suit;
		setName();
		setImageURL();
		setColour();
	}
	
	public void setName(){
		this.name=this.face+this.suit;
	}
	
	public void setColour(){
		if(this.suit=="H"||this.suit=="D"||this.suit=="R"){ this.colour="Red"; }
		else if(this.suit=="S"||this.suit=="C"||this.suit=="B"){ this.colour="Black"; }
		else if(this.suit=="B"){ this.colour="Blue"; }
		else{
			System.out.println("Unknown suit: "+this.suit+"! Setting colour to null");
			colour="";
		}
	}
	
	//assign a numerical value to card for higher/lower comparison
	// Note, Ace can be high or low, but will initially be set to low
	public void setValue(){
		if(this.face=="J"){ this.value=11; }
		else if(this.face=="Q"){ this.value=12; }
		else if(this.face=="K"){ this.value=13; }
		else if(this.face=="A"){ this.value=1; }
		else if(this.face=="JK"){ this.value=-1; } //value of joker is undefined
		else if(this.face=="N"){ this.value=0; } //value of the null card
		else{ this.value=Integer.parseInt(this.face); }
	}
	
	public void setImage(){
		try{
			URL url = new URL(urlBase+this.name+".jpg");
			this.image=ImageIO.read(url);
			//CardImage = context.getImage(url);

		}	
		catch(MalformedURLException e){
	         e.printStackTrace();
	         // Display in browser status bar
	         System.out.println("Invalid Image URL");
	         }
		catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("Image IO exception");
		}

	}
	public void setImageURL(){
		// Try and get the image and catch an exception 
		try{
			this.imageURL = new URL(urlBase+name+".png");
	    }	
		catch(MalformedURLException e){
	         e.printStackTrace();
	         // Display in browser status bar
	         System.out.println("Invalid Image URL");
	         }	

	}
	
	
}
