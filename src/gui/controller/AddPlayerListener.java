package gui.controller;

import java.awt.event.ActionEvent;
import java.util.Collection;

import gui.model.SimplePlayer;
import gui.view.AddPlayerPanel;
import gui.view.MainFrame;
import model.interfaces.GameEngine;
import model.interfaces.Player;

//added to the submit button of add player panel.

public class AddPlayerListener extends MyActionListener 
{
	private AddPlayerPanel panel;
	
	public AddPlayerListener(GameEngine gameEngine,
	        MainFrame frame, AddPlayerPanel panel) 
	{
		super(gameEngine, frame);
		this.panel = panel;
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		try
		{ //surround in try catch for checking number.
			String id, name;
			int points;
			//getting the collection in gameEngine to be added.
			Collection<Player> players = gameEngine.getAllPlayers();
			//getting id,name,points from add player panel.
			id = panel.getIdField();
			name = panel.getNameField();
			points = Integer.parseInt(panel.getPointsField());
			
			Player newPlayer = new SimplePlayer(id, name, points);
			//check whether or not player with the same ID is already in the collection
			if(!checkID(id)) 
			{
				frame.displayErrorMessage("Player with same ID already exists");
				return;
			}
			
			gameEngine.addPlayer(newPlayer);
			toolbar.erasePlayers();
			//for every player in the collection, add to the jcombobox in toolbar.
			for(Player player : players) 
			{
				toolbar.addPlayerToList(player);	
			}
			
			statusBar.setMiddleLabelText(String.format("Added player \" %s \"", name));	
			statusBar.setRightLabelText(newPlayer.toString());
			
		} catch (NumberFormatException e) 
		{
			e.printStackTrace();
		}
	}
	
	public boolean checkID(String id) 
	{
		Collection<Player> players = gameEngine.getAllPlayers();
		
		for(Player player : players) 
		{
			if (player.getPlayerId().equals(id)) 
			{
				return false;
			}
		}

		return true;	
	}
}
