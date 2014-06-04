package CardGame;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class PlayGame extends Applet{

	String message = "Hello World";
	
	Round round;
	
	// function run on initialisation of app.
	// creates the front page to the game
	public void init(){
		// set the size of the application.
		// comment out when running in a browser
		this.setSize(new Dimension(300,400)); 
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
		g.drawString(message,20,50);
		
		 //pass the graphics to the round class to setup the screen
		round.setScreen(g);
	}
}
