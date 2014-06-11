package CardGame;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PlayGame extends Applet implements ActionListener{

	public static final long serialVersionUID=42L;
	
	String message = "Hello World";
	
	Round round;
	Deck deck;
	ArrayList<Image> images = new ArrayList<Image>();
	Image CardImage;

	Color bkgColour;
	AppletContext context;

	// Defining the buttons and an array to store them in
	ArrayList<Button> buttons = new ArrayList<Button>();
	Button playButton;
	Button helpButton;
	Button guessButton1;
	Button guessButton2;
	Button guessButton3;
	Button guessButton4;
	
	// function run on initialisation of app.
	// creates the front page to the game
	public void init(){
		System.out.println("Initialising applet");
		context=this.getAppletContext();	

		deck=new Deck(); //Initialises the deck

		round = new HomeScreen();
		
		bkgColour = new Color(255,255,169);
		setBackground(bkgColour);
		
		playButton = new Button("Button1");
		playButton.addActionListener(this);
		add(playButton);
		buttons.add(playButton);
		
		helpButton = new Button("Button2");
		helpButton.addActionListener(this);
		add(helpButton);
		buttons.add(helpButton);
		
		try{
			URL url = new URL(Card.urlBase+"cards2.jpg");
			CardImage=ImageIO.read(url);
			images.add(CardImage);
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
	
	public void start(){
		System.out.println("Starting applet");
		//System.out.println("About to set screen");
		//round.setScreen(button1, button2);
		//repaint();

	}
	
	public void stop(){
		System.out.println("Stopping applet");
	}
	
	public void destroy(){
		System.out.println("Destroying applet");
	}
	
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==playButton){
			System.out.println("play Button Pressed");
			this.getPlayerNames();
		}
		else if(evt.getSource()==helpButton){
			System.out.println("Add some intructions!");
		}
		else if(evt.getSource()==guessButton1){

		}
		else if(evt.getSource()==guessButton2){

		}
		else if(evt.getSource()==guessButton3){

		}
		else if(evt.getSource()==guessButton4){

		}
	}

	// Test function to make sure deck of cards is initalised properly
    public void displayCards(){
    	System.out.println("There are "+String.valueOf(deck.cards.size()+" cards in the deck"));
		for(int i=0; i<deck.cards.size(); i++){
			Card card=deck.cards.get(i);
			System.out.println(card.getName());
			message=card.getName();
		}
		CardImage=deck.cards.get(53).getImage();
		// Try and get the image and catch an exception 
		try{
			CardImage=ImageIO.read(deck.cards.get(53).getImageURL());
		}	
		catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("Image IO exception");
		}
		repaint();
    }
    
	// Function to get the names of players from user input
	public void getPlayerNames(){
		
	}
	
	// Function to play the first round of the game
	public void playRoundOne(){
		round = new RoundOne();
	}
	
	// Function to play the second round of the game
	public void playRoundTwo(){
		round = new RoundTwo();
	}
	
	// Function to play the third round of the game
	public void playRoundThree(){
		round = new RoundThree();
	}
	
	// Function to play the fourth round of the game
	public void playRoundFour(){
		round = new RoundFour();
	}
	
	// Function to play the second part of the game
	public void playPartTwo(){
		round = new PartTwo();
	}
			
	public void paint(Graphics g){
		// set the size of the application.
		// comment out when running in a browser
		this.setSize(new Dimension(350,400));
		
		// Setting up the screen for a given round
		// Each round takes a different number of buttons, so stored in an array
		round.setScreen(g, images, buttons);
	}
}
