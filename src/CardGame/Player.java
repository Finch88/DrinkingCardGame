package CardGame;

// class to store information on a player
public class Player {
	private String name;	
	public Card[] dealtCards;
	
	public void setName(String Name){ this.name=Name; }
	public String getName(){ return this.name; }
}
