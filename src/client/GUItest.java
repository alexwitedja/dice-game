package client;

import gui.model.GameEngineImpl;
import gui.view.GameEngineCallbackGUI;
import gui.view.MainFrame;
import model.interfaces.GameEngine;

public class GUItest {	
	private static MainFrame frame;
	
	public static void main(String[] args) 
	{
		final GameEngine gameEngine = new GameEngineImpl();
		frame = new MainFrame(gameEngine);
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI(frame));
		//gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
	}
}
