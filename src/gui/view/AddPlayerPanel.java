package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import gui.controller.AddPlayerListener;
import model.interfaces.GameEngine;

//panel for users to fill in player details and add them to the collection inside gameengine object.

@SuppressWarnings("serial")
public class AddPlayerPanel extends MyPanel
{
	private JLabel name, ID, points;
	private JTextField enterName, enterID, enterPoints;
	private JButton submit;
	private ActionListener listener;

	public AddPlayerPanel(GameEngine gameEngine, MainFrame frame) 
	{	
		super(gameEngine, frame);
		
		listener = new AddPlayerListener(gameEngine, frame, this);
		
		name = new JLabel("Name of Player");
		ID = new JLabel("Player ID");
		points = new JLabel("Player's points");
		enterName = new JTextField("Enter name");
		enterID = new JTextField("Enter ID");
		enterPoints = new JTextField("Enter initial points");
		submit = new JButton("Add Player");
		
		submit.addActionListener(listener);
		
		addComponent(name, 0, 0);
		addComponent(ID, 0, 1);
		addComponent(points, 0, 2);
		addComponent(enterName, 1, 0);
		addComponent(enterID, 1, 1);
		addComponent(enterPoints, 1, 2);
		addComponent(submit, 1, 3);
	}
	
	public String getNameField() 
	{
		return enterName.getText();
	}
	
	public String getPointsField() 
	{
		return enterPoints.getText();
	}
	
	public String getIdField() 
	{
		return enterID.getText();
	}
}
