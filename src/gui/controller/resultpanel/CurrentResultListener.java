package gui.controller.resultpanel;

import java.awt.event.ActionEvent;

import gui.view.MainFrame;
import gui.view.ResultsPanel;

//saving the result shown in panel to a variable.

public class CurrentResultListener extends ResultsListener
{	
	public CurrentResultListener(ResultsPanel resultsPanel, MainFrame frame) 
	{
		super(resultsPanel, frame);
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		resultsPanel.setResultsPanel(resultsPanel.getCurrentResult());
		statusbar.setLeftLabelText("showing current result");
	}
}
