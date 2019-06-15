package gui.view;

import java.util.Collection;

import javax.swing.SwingUtilities;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineCallbackGUI implements GameEngineCallback
{
	private DicePanel dicePanel;
	private ResultsPanel resultsPanel;
	
	public GameEngineCallbackGUI(MainFrame frame) 
	{
		this.dicePanel = (DicePanel) frame.getDicePanel();
		this.resultsPanel =  (ResultsPanel) frame.getResultsPanel();
	}
	
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) 
	{
		final int dice1 = dicePair.getDice1();
		final int dice2 = dicePair.getDice2();
		final String text = player.getPlayerName() + " is rolling";
		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
			{
				dicePanel.setDicePanelText(dice1, dice2, text);
				dicePanel.revalidate();
			}
		});			
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) 
	{
		final int dice1 = result.getDice1();
		final int dice2 = result.getDice2();
		final String text = player.getPlayerName() + "'s result dice";
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				dicePanel.setDicePanelText(dice1, dice2, text);
				dicePanel.revalidate();
			}
		});	
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
	{
		final int dice1 = dicePair.getDice1();
		final int dice2 = dicePair.getDice2();
		final String text = "house is rolling the dice";
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				dicePanel.setDicePanelText(dice1, dice2, text);
				dicePanel.revalidate();
			}
		});		
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) 
	{//save the result to a variable;
		resultsPanel.setPreviousResult();
		//reset the panel's text area
		resultsPanel.setResultsPanel("");

		final int dice1 = result.getDice1();
		final int dice2 = result.getDice2();
		final String text = "house result dice";
		//use for append string.
		String currentResult = "";
		
		SwingUtilities.invokeLater(new Runnable() 
		{
			public void run() 
			{
				dicePanel.setDicePanelText(dice1, dice2, text);
				dicePanel.revalidate();
			}
		});	
		
		Collection<Player> players = gameEngine.getAllPlayers();
		
		for(Player player: players) 
		{
			String winOrLose = winOrLose(result, player.getRollResult());
			String playerInfo = player.toString();
			final String results = String.format("%s %ss %n", playerInfo, winOrLose);
			currentResult += results;
			
			SwingUtilities.invokeLater(new Runnable() 
			{
				public void run() {
					resultsPanel.appendResultsPanel(results);
					resultsPanel.revalidate();
				}
			});	

		}
		//store the result in a variable in results panel object.
		//so user can go back and forth between current and previous result.
		resultsPanel.setCurrentResult(currentResult);
	}

	private String winOrLose(DicePair house, DicePair player) 
	{//returns win/draw/lose so user know outcome.
		int houseResult = house.getDice1()+house.getDice2();
		int playerResult = player.getDice1()+player.getDice2();
		
		if(playerResult>houseResult) 
		{
			return "win";
		}
		else if(playerResult == houseResult) 
		{
			return "draw";
		}
		else 
		{
			return "lose";
		}
	}
}
