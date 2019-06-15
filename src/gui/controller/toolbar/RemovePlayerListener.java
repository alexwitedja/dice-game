package gui.controller.toolbar;

import java.awt.event.ActionEvent;

import gui.controller.MyActionListener;
import gui.view.MainFrame;
import gui.view.MyToolBar;
import gui.view.PlayerDecorator;
import model.interfaces.GameEngine;
import model.interfaces.Player;

//listener that calls remove player. added to jtogglebutton in toolbar.

public class RemovePlayerListener extends MyActionListener
{
	private MyToolBar toolbar;
	
	public RemovePlayerListener(GameEngine gameEngine, MainFrame frame, MyToolBar toolbar) 
	{
		super(gameEngine, frame);
		this.toolbar = toolbar;
	}

	public void actionPerformed(ActionEvent arg0) 
	{//checks if the selected element in jcombobox isn't null
		PlayerDecorator playerD = toolbar.getSelectedPlayer();
		
		if(playerD == null) 
		{
			frame.displayErrorMessage("select a player to remove");
			return;
		}
		
		Player player = playerD.getPlayer();
		//removes player from the collection and jcombobox.
		gameEngine.removePlayer(player);
		toolbar.removeSelected();
		
		statusBar.setMiddleLabelText(String.format("%s successfully removed", player.getPlayerName()));
		statusBar.setRightLabelText(player.toString());
	}
}
