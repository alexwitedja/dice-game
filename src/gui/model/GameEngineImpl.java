package gui.model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine
{
	private Map<String,Player> players = new HashMap<String,Player>();
	private List<GameEngineCallback> callbacks = new ArrayList<GameEngineCallback>();
	private DicePair playerDice = null;
	private DicePair houseDice = null;
	
	public boolean placeBet(Player player, int bet) 
	{
		boolean check = player.placeBet(bet);
		return check;
	}

	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) 
	{
		playerDice = playerRollDice(player, initialDelay,finalDelay,delayIncrement);
		player.setRollResult(playerDice);
		
		for(GameEngineCallback Callback : callbacks) 
		{
			Callback.result(player, playerDice, this);
		}
	}
	
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) 
	{
		Collection<Player> players = getAllPlayers();
		
		houseDice = houseRollDice(initialDelay,finalDelay,delayIncrement);
		int houseResult = houseDice.getDice1()+houseDice.getDice2();
		
		for(Player player : players) 
		{
			int points = player.getPoints();
			playerDice = player.getRollResult();
			int playerResult = playerDice.getDice1()+playerDice.getDice2();
			
			if (houseResult > playerResult) 
			{
				points -= player.getBet();
				player.setPoints(points);
				
			} else if (playerResult == houseResult) 
			{
				points = player.getPoints();
				
			} else
			{
				points += player.getBet();
				player.setPoints(points);
			}
			
			player.placeBet(0);//after a player's result is settled the bet is returned to 0.
		}
	
		for(GameEngineCallback Callback : callbacks) 
		{
			Callback.houseResult(houseDice, this);
		}
	}
	
	
	@Override
	public void addPlayer(Player player) 
	{
		String id = player.getPlayerId();
		players.put(id,player);
	}

	@Override
	public Player getPlayer(String id) 
	{
		return players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) 
	{
		if(getPlayer( player.getPlayerId()) != null) 
		{
			players.remove(player.getPlayerId());
		}
		return false;				
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		callbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) 
	{
		callbacks.remove(gameEngineCallback);
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() 
	{
		return Collections.unmodifiableCollection(players.values());
	}
	
	private DicePair playerRollDice(Player player, int initialDelay, int finalDelay, int delayIncrement) 
	{
		int max = NUM_FACES;
		int min = 1;
		Random random = new Random();
		DicePair dice = null;
		
		while(initialDelay <= finalDelay) 
		{
			dice = new DicePairImpl(min+random.nextInt(max),min+random.nextInt(max), max);
			
			try 
			{
			Thread.sleep(600 - initialDelay);
			
			for(GameEngineCallback Callback : callbacks) 
			{
				Callback.intermediateResult(player, dice , this);	
			}
			
			}catch (InterruptedException e) 
			{
				e.printStackTrace();	
			}
			
			initialDelay += delayIncrement;
			
			if(initialDelay >= finalDelay) 
			{
				dice = new DicePairImpl(min+random.nextInt(max),min+random.nextInt(max), max);
			}	
		
		}
		
		return dice;
	}
	
	private DicePair houseRollDice(int initialDelay, int finalDelay, int delayIncrement) 
	{
		int max = NUM_FACES;
		int min = 1;
		Random random = new Random();
		DicePair dice = null;
		
		while(initialDelay <= finalDelay) 
		{
			dice = new DicePairImpl(min+random.nextInt(max),min+random.nextInt(max), max);
			
			try 
			{
			Thread.sleep(1000 - initialDelay);
			
			for(GameEngineCallback Callback : callbacks) 
			{
				Callback.intermediateHouseResult(dice , this);	
			}
			
			}catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			initialDelay += delayIncrement;
			
			if(initialDelay >= finalDelay)
			{
				dice = new DicePairImpl(min+random.nextInt(max),min+random.nextInt(max), max);
			}	
		}
		return dice;
	}
}


