package gui.controller;

import java.awt.event.ActionEvent;

import gui.view.BetPanel;
import gui.view.MainFrame;
import gui.view.PlayerDecorator;
import model.interfaces.GameEngine;
import model.interfaces.Player;

//added to bet panel

public class BetListener extends MyActionListener
{
	private BetPanel panel;
	
	public BetListener(GameEngine gameEngine, MainFrame frame, BetPanel panel) 
	{
		super(gameEngine, frame);
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent e) 
	{
		//get player that is selected, convert it into player object.
		PlayerDecorator playerD = toolbar.getSelectedPlayer();
		Player player = playerD.getPlayer();
		int bet = Integer.parseInt(panel.getBetText());
		
		//check if placebet() returns true.
		if (!gameEngine.placeBet(player, bet)) 
		{
			frame.displayErrorMessage("This player doesn't have enough points");
			return;
		}
		
		statusBar.setMiddleLabelText(String.format("%s placed %d points", playerD.toString(), bet));
		statusBar.setRightLabelText(player.toString());
	}

}
