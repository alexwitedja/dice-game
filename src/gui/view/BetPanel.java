package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import gui.controller.BetListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class BetPanel extends MyPanel
{
	private JLabel betAmount;
	private JTextArea inputBet;
	private JButton submit;
	private ActionListener listener;
	
	public BetPanel(GameEngine gameEngine, MainFrame frame) 
	{	
		super(gameEngine, frame);
		listener = new BetListener(gameEngine, frame, this);
		
		betAmount = new JLabel("Input Bet: ");
		inputBet = new JTextArea("Type number here");
		submit = new JButton("Bet!");
		
		submit.addActionListener(listener);
		
		addComponent(betAmount,0,0);
		addComponent(inputBet,1,0);
		addComponent(submit,1,1);
	}

	public String getBetText() 
	{
		return inputBet.getText();
	}
}
