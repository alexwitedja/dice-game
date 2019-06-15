package gui.controller.toolbar;

import java.awt.event.ActionEvent;

import gui.controller.MyActionListener;
import gui.view.MainFrame;
import gui.view.MyToolBar;
import gui.view.PlayerDecorator;
import model.interfaces.GameEngine;
import model.interfaces.Player;

//listener that calls rollplayer method. added to jtogglebutton in toolbar.

public class RollListener extends MyActionListener
{
	private MyToolBar toolbar;
	
	public RollListener(GameEngine gameEngine, MainFrame frame, MyToolBar toolbar)
	{
		super(gameEngine, frame);
		this.toolbar = toolbar;
	}

	public void actionPerformed(ActionEvent e) 
	{
		PlayerDecorator playerD = toolbar.getSelectedPlayer();
		final Player player = playerD.getPlayer();

		//checks if a player have placed bet.
		if (player.getBet() == 0) 
		{
			frame.displayErrorMessage("this player haven't placed a bet");
			return;
		}
		
		toolbar.getRollButton().setEnabled(false);
		toolbar.getHouseButton().setEnabled(false);
		
		statusBar.setMiddleLabelText(String.format("rolling for %s", player.getPlayerName()));
		statusBar.setRightLabelText(player.toString());
		
		new Thread() 
		{
			public void run() 
			{
				gameEngine.rollPlayer(player, 1, 100, 20);
				toolbar.getRollButton().setEnabled(true);
				toolbar.getHouseButton().setEnabled(true);
			}
		}.start();
	}
}
