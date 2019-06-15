package gui.view;

import model.interfaces.Player;

//a custom object with player reference to be added to Jcombobox.

public class PlayerDecorator 
{
	private Player p;

	public PlayerDecorator(Player p) 
	{
		this.p = p;
		
	}
	
	public String toString() 
	{
		return p.getPlayerName();		
	}
	
	public Player getPlayer()
	{
		return p;		
	}
}
