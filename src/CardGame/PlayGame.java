package CardGame;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class PlayGame extends Applet implements ActionListener, FocusListener{

	public static final long serialVersionUID=42L;
	
	String message = "Hello World";
	int nPlayers;
	int player;
	
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
	Button goButton;
	Button nextButton;
	Button guessButton1;
	Button guessButton2;
	Button guessButton3;
	Button guessButton4;
	
	ArrayList<TextField> textFields = new ArrayList<TextField>();
    TextField nameField; 
	
    // Array of players
    ArrayList<Player> players = new ArrayList<Player>();
    
	// function run on initialisation of app.
	// creates the front page to the game
	public void init(){
		System.out.println("Initialising applet");
		context=this.getAppletContext();	

		deck=new Deck(); //Initialises the deck

		round = new HomeScreen();
		
		player=0; //initialises the player number;
		
		bkgColour = new Color(255,255,169);
		setBackground(bkgColour);
		
		// Initialise buttons for later
		playButton = new Button();
		helpButton = new Button();
		goButton = new Button();
		nextButton = new Button();
		guessButton1 = new Button();
		guessButton2 = new Button();
		guessButton3 = new Button();
		guessButton4 = new Button();
		
		//Add all buttons to ActionListener
		playButton.addActionListener(this);
		helpButton.addActionListener(this);
		goButton.addActionListener(this);
    	nextButton.addActionListener(this);

    	// Initialising the TextField 
		nameField = new TextField(30);
		// add to action listener and focus listener 
        nameField.addActionListener(this);
		nameField.addFocusListener(this);

		// Add buttons for initial start-up screen
		add(playButton);
		buttons.add(playButton);
		
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
	}
	
	public void stop(){
		System.out.println("Stopping applet");
	}
	
	public void destroy(){
		System.out.println("Destroying applet");
	}

	// Definitions for actions, i.e. button clicks
	public void actionPerformed(ActionEvent evt){
		if(evt.getSource()==playButton){
			askNumPlayers();
		}
		else if(evt.getSource()==helpButton){
			displayCards();
			System.out.println("Add some intructions!");
		}
		else if(evt.getSource()==goButton){
			getPlayers();
		}
		else if(evt.getSource()==nameField){
			if(round instanceof NumberPlayersScreen ){ getPlayers(); }
			else if(round instanceof GetPlayerName){ addPlayer(); }
		}
		else if(evt.getSource()==nextButton){
			addPlayer();	
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

    // Definitions for focus events
    public void focusLost(final FocusEvent pE) {}
    public void focusGained(final FocusEvent pE){
    	if(pE.getSource()==nameField){ nameField.selectAll(); }
    }	

	// Test function to make sure deck of cards is initialised properly
    public void displayCards(){
    	System.out.println("There are "+String.valueOf(deck.cards.size()+" cards in the deck"));
		for(int i=0; i<deck.cards.size(); i++){
			Card card=deck.cards.get(i);
			System.out.println(card.getName());
			message=card.getName();
		}
		// Try and get the image and catch an exception 
		Card test = new Card();
		try{
			//CardImage=ImageIO.read(deck.cards.get(12).getImageURL());
			CardImage=ImageIO.read(test.getImageURL());
		}	
		catch(IOException ioe){
			ioe.printStackTrace();
			System.out.println("Image IO exception");
		}
		repaint();
    }

    public void askNumPlayers(){
		System.out.println("play Button Pressed");
		round = new NumberPlayersScreen(); // change the round to ask for players

		// remove the initial buttons
		remove(playButton);
		remove(helpButton);
		buttons.clear();
		textFields.clear();		
		
		// add new buttons for this screen
		buttons.add(goButton);
		add(goButton);

		nameField.setText("How many players?");
		add(nameField);
		textFields.add(nameField);

		repaint();
    }

    public void getPlayers(){
    	try{
    		nPlayers =  Integer.parseInt(nameField.getText());
    	}
    	catch(NumberFormatException e){
    		System.out.println("Exception in parsing integer from nameField");
    		textFields.get(0).setText("Enter number of players");
    		//askNumPlayers();
    		repaint();
    	}
    	System.out.println("There are "+nPlayers+" players");
    	
    	if(nPlayers>0){
    		round = new GetPlayerName();
    	
    		remove(goButton);
    		buttons.remove(goButton);
		
    		// add new buttons for this screen
    		buttons.add(nextButton);
    		add(nextButton);

    		nameField.setText("Player_"+(player+1));
    		repaint();
    	}
    }
    
    public void addPlayer(){
    	players.add(new Player(nameField.getText()));
    	player++;
		if(player>=nPlayers){
			// play first round
			System.out.println("Reached max players");
			for(Player pl:players){
				System.out.println(pl.getName());
			}
			player=0; //reset the players index for the next round
			playRoundOne();
		}
		else{
			nameField.setText("Player_"+(player+1));
			repaint();				
		}
    }
    
    
    // Function to play the first round of the game
	public void playRoundOne(){
		// Clear arrays and remove old buttons and TextFields
		buttons.clear();
		textFields.clear();
		images.clear();
		
		remove(nameField);
		remove(nextButton);
		
		// Add buttons to accept guess from players
		add(guessButton1);
		add(guessButton2);
		buttons.add(guessButton1);
		buttons.add(guessButton2);
	
		for(int i=0; i<players.get(player).dealtCards.size(); i++){
			try{
				CardImage=ImageIO.read(players.get(player).dealtCards.get(i).getImageURL());
			}	
			catch(IOException ioe){
				ioe.printStackTrace();
				System.out.println("Image IO exception");
			}
			images.add(CardImage);
		}
		
		round = new RoundOne();
		repaint();
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
		this.setSize(new Dimension(350,500)); //350, 400
		//g.drawImage(CardImage, 50, 50, 250, 200, null);

		// Setting up the screen for a given round
		// Each round takes a different number of buttons, so stored in an array
		round.setScreen(g, images, buttons, textFields);
	}
}
