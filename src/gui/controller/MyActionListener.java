package gui.controller;

import java.awt.event.ActionListener;

import gui.view.MainFrame;
import gui.view.MyToolBar;
import gui.view.StatusBarPanel;
import model.interfaces.GameEngine;

//an abstract class inherited by listeners that contain statusbar, gameengine, mainframe object.
public abstract class MyActionListener implements ActionListener
{
	protected StatusBarPanel statusBar;
	protected GameEngine gameEngine;
	protected MainFrame frame;
	protected MyToolBar toolbar;
	
	public MyActionListener(GameEngine gameEngine
			,MainFrame frame) 
	{
		this.toolbar = frame.getToolbar();
		this.statusBar = frame.getStatusBar();
		this.gameEngine = gameEngine;
		this.frame = frame;
	}
}
