package gui.controller.resultpanel;

import java.awt.event.ActionListener;

import gui.view.MainFrame;
import gui.view.ResultsPanel;
import gui.view.StatusBarPanel;

//an abstract class that will be inherited by listeners that is related to results panel.

public abstract class ResultsListener implements ActionListener
{
	protected ResultsPanel resultsPanel;
	protected StatusBarPanel statusbar;
	
	public ResultsListener(ResultsPanel resultsPanel, MainFrame frame) 
	{
		this.resultsPanel = resultsPanel;
		this.statusbar = frame.getStatusBar();
	}
}
