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
	
	int nPlayers;
	int player;
	int currentRound;
	String guess; // Player's guess 
	int numFingers; //number of fingers for part two
	int partTwoCount; //number of times part two has been played
	String giveOrTake; 
	String names;
	
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
		
		nPlayers=0;
		player=0; //initialises the player number;
		currentRound=0;
		numFingers=2;
		partTwoCount=0;
		names="";
		
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
		guessButton1.addActionListener(this);
		guessButton2.addActionListener(this);
		guessButton3.addActionListener(this);
    	guessButton4.addActionListener(this);

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
		buttons.clear();
		textFields.clear();
		images.clear();
		players.clear();
		remove(playButton);
		remove(helpButton);
		remove(goButton);
		remove(nextButton);
		remove(guessButton1);
		remove(guessButton2);
		remove(guessButton3);
		remove(guessButton4);
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
			if(round instanceof GetPlayerName){ addPlayer(); }
			else if(round instanceof PartTwo){
				partTwoCount++;
				if(partTwoCount==8){ destroy(); init(); repaint(); }
				else if(partTwoCount%2==0){ 
					numFingers++;
					playThisRound();
				}
				else{
					playThisRound();
				}
			}
			else{
				player++;
				// Once all players have played a round, reset the player index and play next round
				if(player>=nPlayers){ 
					player=0;
					currentRound++;
				}
				playThisRound();
			}
		}
		else if(evt.getSource()==guessButton1){
			guess=guessButton1.getLabel();
			round.playRound(players.get(player), guess, deck);
			getCardImages();
			for(Button button : buttons){
				remove(button);
			}
			add(nextButton);
			repaint();
		}
		else if(evt.getSource()==guessButton2){
			guess=guessButton2.getLabel();
			round.playRound(players.get(player), guess, deck);
			getCardImages();
			for(Button button : buttons){
				remove(button);
			}
			add(nextButton);
			repaint();		
		}
		else if(evt.getSource()==guessButton3){
			guess=guessButton3.getLabel();
			round.playRound(players.get(player), guess, deck);
			getCardImages();
			for(Button button : buttons){
				remove(button);
			}
			add(nextButton);
			repaint();
		}
		else if(evt.getSource()==guessButton4){
			guess=guessButton4.getLabel();
			round.playRound(players.get(player), guess, deck);
			getCardImages();
			for(Button button : buttons){
				remove(button);
			}
			add(nextButton);
			repaint();
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
			//message=card.getName();
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
			currentRound++;
			playRoundOne();
		}
		else{
			nameField.setText("Player_"+(player+1));
			repaint();				
		}
    }
    
    public void getCardImages(){
		images.clear();
		for(int i=0; i<players.get(player).dealtCards.size(); i++){
			try{
				//System.out.println(players.get(player).dealtCards.get(i).getName());
				CardImage=ImageIO.read(players.get(player).dealtCards.get(i).getImageURL());
			}	
			catch(IOException ioe){
				ioe.printStackTrace();
				System.out.println("Image IO exception");
			}
			images.add(CardImage);
		}		
    }
    
    public void getPartTwoImage(){
		if(round instanceof PartTwo){
			images.clear();
			//if(partTwoCount==0){ System.out.println("Setting blank card"); ((PartTwo) round).newCard(); }
			try{
				//System.out.println(players.get(player).dealtCards.get(i).getName());
				CardImage=ImageIO.read(round.PartTwoCard.getImageURL());
			}	
			catch(IOException ioe){
				ioe.printStackTrace();
				System.out.println("Image IO exception");
			}
			images.add(CardImage);
		}
		else{
			System.out.println("Trying to access getPartTwoImage when round!=PartTwo");
		}
    }
    // Plays the current round
    public void playThisRound(){
    	if(currentRound==1){ playRoundOne(); }
    	else if(currentRound==2){ playRoundTwo(); }
    	else if(currentRound==3){ playRoundThree(); }
    	else if(currentRound==4){ playRoundFour(); }
    	else if(currentRound==5){ playPartTwo(); }
    }
        
    // Function to play the first round of the game
	public void playRoundOne(){
		// Clear arrays and remove old buttons and TextFields
		buttons.clear();
		textFields.clear();
		
		remove(nameField);
		remove(nextButton);
		
		// Add buttons to accept guess from players
		add(guessButton1);
		add(guessButton2);
		buttons.add(guessButton1);
		buttons.add(guessButton2);
	
		// nextButton needs to be position for later
		buttons.add(nextButton);
		round.setMessage(players.get(player).getName()+": What colour?");
		System.out.println(round.getMessage());
		
		getCardImages();
		
		round = new RoundOne();
		repaint();
	}
	
	// Function to play the second round of the game
	public void playRoundTwo(){
		// Clear arrays and remove old buttons and TextFields
		buttons.clear();
		textFields.clear();

		remove(nextButton);
		
		// Add buttons to accept guess from players
		add(guessButton1);
		add(guessButton2);
		buttons.add(guessButton1);
		buttons.add(guessButton2);
	
		// nextButton needs to be position for later
		buttons.add(nextButton);
		round.setMessage(players.get(player).getName()+": Higher or Lower?");
		System.out.println(round.getMessage());
		
		getCardImages();
		
		round = new RoundTwo();
		repaint();
	}
	
	// Function to play the third round of the game
	public void playRoundThree(){
		// Clear arrays and remove old buttons and TextFields
		buttons.clear();
		textFields.clear();

		remove(nextButton);

		// Add buttons to accept guess from players
		add(guessButton1);
		add(guessButton2);
		buttons.add(guessButton1);
		buttons.add(guessButton2);
	
		// nextButton needs to be position for later
		buttons.add(nextButton);
		round.setMessage(players.get(player).getName()+": Inside or Outside?");
		System.out.println(round.getMessage());
		
		getCardImages();
		
		round = new RoundThree();
		repaint();
	}
	
	// Function to play the fourth round of the game
	public void playRoundFour(){
		// Clear arrays and remove old buttons and TextFields
		buttons.clear();
		textFields.clear();

		remove(nextButton);

		// Add buttons to accept guess from players
		add(guessButton1);
		add(guessButton2);
		add(guessButton3);
		add(guessButton4);		
		buttons.add(guessButton1);
		buttons.add(guessButton2);
		buttons.add(guessButton3);
		buttons.add(guessButton4);
	
		// nextButton needs to be position for later
		buttons.add(nextButton);
		round.setMessage(players.get(player).getName()+": Guess the suit");
		System.out.println(round.getMessage());
		
		getCardImages();
		
		round = new RoundFour();
		repaint();
	}
	
	// Function to play the second part of the game
	public void playPartTwo(){
		// Clear arrays and remove old buttons and TextFields
		buttons.clear();
		textFields.clear();
		
		remove(nameField);
		remove(nextButton);
		
		// Add buttons to accept guess from players
		add(nextButton);
		buttons.add(nextButton);

		if(partTwoCount%2==0){
			giveOrTake="Give: ";
		}
		else{
			giveOrTake="Take: ";
		}
				
		round = new PartTwo();
		round.playRound(players.get(0), "", deck);
		
		getPartTwoImage();
		
		names="";
		for(Player pl: players){
			for(Card card: pl.dealtCards){
				if(card.getValue()==round.PartTwoCard.getValue()){
					nameField.setText(pl.getName());
					System.out.println(pl.getName());
					textFields.add(nameField);
				}
			}
		}
		
		round.setMessage(giveOrTake+numFingers+" fingers");
		System.out.println(round.getMessage());

		repaint();
	}
			
	public void paint(Graphics g){
		// set the size of the application.
		// comment out when running in a browser
		this.setSize(new Dimension(350,575)); //350, 400
		//g.drawImage(CardImage, 50, 50, 250, 200, null);

		// Setting up the screen for a given round
		// Each round takes a different number of buttons, so stored in an array
		round.setScreen(g, images, buttons, textFields);
	}
}
