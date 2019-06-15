package gui.view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import gui.controller.toolbar.HouseRollListener;
import gui.controller.toolbar.RemovePlayerListener;
import gui.controller.toolbar.RollListener;
import gui.controller.toolbar.ShowBetPanelListener;
import model.interfaces.GameEngine;
import model.interfaces.Player;

@SuppressWarnings("serial")
public class MyToolBar extends JToolBar
{
	private JToggleButton roll = new JToggleButton("Roll Player");
	private JToggleButton bet = new JToggleButton("Place Bet");
	private JToggleButton house = new JToggleButton("House Roll");
	private JToggleButton removePlayer = new JToggleButton("Remove Player");
	
	private ActionListener rollListener, houseListener, removeListener, showBetListener;
	
	private AbstractButton[] buttons = 
		{
			bet
			,roll
			,house
			,removePlayer
			
		};
	
	private ButtonGroup group = new ButtonGroup();
	private JComboBox<PlayerDecorator> playerGroup = new JComboBox<PlayerDecorator>();
	
	public MyToolBar(GameEngine gameEngine, MainFrame frame) 
	{	
		showBetListener = new ShowBetPanelListener(frame);
		rollListener = new RollListener(gameEngine, frame, this);
		houseListener = new HouseRollListener(gameEngine, frame, this);
		removeListener = new RemovePlayerListener(gameEngine, frame, this);
		
		playerGroup.setPreferredSize(new Dimension(200,10));
		playerGroup.setMaximumSize(new Dimension(200,100));
		add(playerGroup);
		
		for(int i = 0; i<buttons.length; i++) 
		{
			group.getSelection();
			buttons[i].setBorder(BorderFactory.createRaisedBevelBorder());
			
			if (i == 0)
				buttons[i].setSelected(true);
			
			group.add(buttons[i]);
			add(buttons[i]);
		}
		
		bet.addActionListener(showBetListener);
		roll.addActionListener(rollListener);
		house.addActionListener(houseListener);
		removePlayer.addActionListener(removeListener);
	}
	
	public void addPlayerToList(Player p) 
	{
		PlayerDecorator pD = new PlayerDecorator(p);
		playerGroup.addItem(pD);
	}
	
	public JComboBox<PlayerDecorator> getComboBox()
	{
		return playerGroup;	
	}
	
	public PlayerDecorator getSelectedPlayer()
	{
		return (PlayerDecorator) playerGroup.getSelectedItem();
	}
	
	public void erasePlayers() 
	{
		playerGroup.removeAllItems();
	}
	
	public void removeSelected()
	{
		PlayerDecorator playerD = (PlayerDecorator) playerGroup.getSelectedItem();
		playerGroup.removeItem(playerD);
	}
	
	public JToggleButton getRollButton() 
	{
		return roll;
	}
	
	public JToggleButton getHouseButton() 
	{
		return house;
	}
}
