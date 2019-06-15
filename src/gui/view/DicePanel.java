package gui.view;

import javax.swing.JLabel;

import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class DicePanel extends MyPanel
{
	private JLabel diceOutput, dice1, dice2, number1, number2;
	
	public DicePanel(GameEngine gameEngine, MainFrame frame)
	{
		super(gameEngine, frame);
		
		diceOutput = new JLabel("Dice output");
		dice1 = new JLabel("Dice 1 :");
		dice2 = new JLabel("Dice 2 : ");
		number1 = new JLabel("");
		number2 = new JLabel("");

		addComponent(diceOutput,0,0);
		addComponent(dice1,0,1);
		addComponent(dice2,1,1);
		addComponent(number1,0,2);
		addComponent(number2,1,2);
	}
	
	public void setDicePanelText(int dice1, int dice2, String text) 
	{		
		number1.setText(Integer.toString(dice1));
		number2.setText(Integer.toString(dice2));
		diceOutput.setText(text);
		
	}
}
