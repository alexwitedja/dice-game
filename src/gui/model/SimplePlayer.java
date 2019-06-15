package gui.model;
import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player
{
	private String PlayerName, PlayerID;
	private int Points, Bet;
	private DicePair RollResult;
	
	public SimplePlayer(String PlayerID, String PlayerName, int Points) 
	{
		this.PlayerID = PlayerID;
		this.PlayerName = PlayerName;
		this.Points = Points;
	}

	public String getPlayerName() 
	{
		return PlayerName;
	}

	public void setPlayerName(String playerName) 
	{
		PlayerName = playerName;
	}

	public int getPoints() 
	{	
		return Points;		
	}

	public void setPoints(int points) 
	{	
		Points = points;		
	}

	public String getPlayerId() 
	{
		return PlayerID;	
	}

	public boolean placeBet(int bet) 
	{
		int current = getPoints();
		if (current < bet) 
		{	
			return false;			
		}
		
		else 
		{			
			Bet = bet;
			return true;			
		}
	}

	public int getBet() 
	{
		return Bet;		
	}

	public DicePair getRollResult() 
	{
		return RollResult;		
	}

	public void setRollResult(DicePair rollResult) 
	{
		RollResult = rollResult;		
	}
	
	public String toString() 
	{	
		return String.format(" id= %s, name= %s, points= %d", getPlayerId(), getPlayerName(), getPoints());	
	}
}
