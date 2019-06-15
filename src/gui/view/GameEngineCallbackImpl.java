package gui.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");
	@SuppressWarnings("unused")
	private static GameEngine gameEngine = null;

	public GameEngineCallbackImpl()
	{
		// FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
	}

	@SuppressWarnings("static-access")
	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		// intermediate results logged at Level.FINE
		this.gameEngine = gameEngine;
		logger.log(Level.FINE, "Intermediate data to log .. " + dicePair.toString());
		// TO DO: complete this method to log results
	}

	@SuppressWarnings("static-access")
	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		// final results logged at Level.INFO
		this.gameEngine = gameEngine;
		logger.log(Level.INFO, "Result data to log .. " + result.toString());
		// TO DO: complete this method to log results
	}

	@SuppressWarnings("static-access")
	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) 
	{
		// TODO Auto-generated method stub
		this.gameEngine = gameEngine;
		logger.log(Level.FINE, "Intermediate data to log .. " + dicePair.toString());
	}

	@SuppressWarnings("static-access")
	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) 
	{
		// TODO Auto-generated method stub
		this.gameEngine = gameEngine;
		logger.log(Level.INFO, "Result data to log .. " + result.toString());
	}
	// TO DO: complete the GameEngineCallback interface implementation

}
