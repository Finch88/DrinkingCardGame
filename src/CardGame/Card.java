package CardGame;

import java.applet.*;
import java.awt.*;
import java.net.*;

// This class stores information about a card
public class Card extends Applet{

	// Private member variables
	private String face; // face value of card, i.e. 2-10, J, Q, K, A
	private String suit; // options are "H", "D", "C" and "S"
	private String name; // Name is face + suit, i.e. "2H", "AD" etc.
	private int value; // Numerical value of the card, J=11, Q=12, K=13, A=1 or 14
	private String colour; // colour of card
	private Image image; // image associated with card
	
	//Constructors
	Card(){
		name="";
		face="";
		suit="";
		value=0;
		colour="";
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
	public Image getImage(){ return this.image; }
	
	// Functions for setting the private member variables and updating related variables
	public void setFace(String Face){
		this.face=Face;
		setName();
		setImage();
		setValue();
	}
	
	public void setSuit(String Suit){
		this.suit=Suit;
		setName();
		setImage();
		setColour();
	}
	
	public void setName(){
		this.name=this.face+this.suit;
	}
	
	public void setColour(){
		if(this.suit=="H"||this.suit=="D"){ colour="Red"; }
		else if(this.suit=="S"||this.suit=="C"){ colour="Black"; }
		else{
			System.out.println("Unknown suit: "+this.suit+"! Setting colour to null");
			this.colour="";
		}
	}
	
	//assign a numerical value to card for higher/lower comparison
	// Note, Ace can be high or low, but will initially be set to low
	public void setValue(){
		if(this.face=="J"){ this.value=11; }
		else if(this.face=="Q"){ this.value=12; }
		else if(this.face=="K"){ this.value=13; }
		else if(this.face=="A"){ this.value=1; }
		else{ this.value=Integer.parseInt(this.face); }
	}
	
	// Finding image associated with card
	private AppletContext context=this.getAppletContext();
	String urlBase="file:/E:/Documents/Projects/Java/DrinkingCardGame/pics/";
	
	public void setImage(){
		// Try and get the image and catch an exception 
		try{
			System.out.println(this.getDocumentBase());
	         URL url = new URL(urlBase+this.name+".jpg");
	         this.image = context.getImage(url);
	         if(this.image==null){ System.out.println("Cannot find image"); }
		}	
		catch(MalformedURLException e){
	         e.printStackTrace();
	         // Display in browser status bar
	         System.out.println("Image not found");
	         context.showStatus("Could not load image!");
	         }	

	}
	
	
}
