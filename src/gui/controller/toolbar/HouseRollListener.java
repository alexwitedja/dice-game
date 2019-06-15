package gui.controller.toolbar;

import java.awt.event.ActionEvent;
import java.util.Collection;

import gui.controller.MyActionListener;
import gui.view.MainFrame;
import gui.view.MyToolBar;
import model.interfaces.GameEngine;
import model.interfaces.Player;

//listener that calls rollhouse. added to a jtogglebutton in toolbar.

public class HouseRollListener extends MyActionListener
{
	private MyToolBar toolbar;
	
	public HouseRollListener(GameEngine gameEngine, MainFrame frame, MyToolBar toolbar) 
	{
		super(gameEngine, frame);
		this.toolbar = toolbar;
	}

	public void actionPerformed(ActionEvent e) 
	{//notifies user that house is rolling.
		statusBar.setMiddleLabelText("house is rolling");
		statusBar.setRightLabelText("results on left panel");
		//checking whether all players have rolled.
		Collection<Player> players = gameEngine.getAllPlayers();
		
		for(Player player: players) {
			if(player.getBet() == 0) {
				frame.displayErrorMessage((String.format("%s id: %s haven't place bet", player.getPlayerName(),player.getPlayerId())));
				return;
			}
		}
		for(Player player : players) 
		{	
			if(player.getRollResult() == null) 
			{
				frame.displayErrorMessage((String.format("%s id: %s haven't rolled", player.getPlayerName(),player.getPlayerId())));
				return;
			}
		}
		//disabling jtogglebutton that calls for roll player and house roll method
		//only one dice can be rolling at a time.
		toolbar.getRollButton().setEnabled(false);
		toolbar.getHouseButton().setEnabled(false);
		//thread to run a roll method and enabling disabled buttons once method is completed.
		new Thread() 
		{
			public void run() 
			{
				gameEngine.rollHouse(1, 100, 20);
				toolbar.getRollButton().setEnabled(true);
				toolbar.getHouseButton().setEnabled(true);
			}
		}.start();
				
	}

}
