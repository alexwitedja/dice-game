package gui.controller.resultpanel;

import java.awt.event.ActionEvent;

import gui.view.MainFrame;

//added to show result that is saved in a variable inside results panel.

import gui.view.ResultsPanel;

public class PreviousResultListener extends ResultsListener
{
	public PreviousResultListener(ResultsPanel resultsPanel
			, MainFrame frame) 
	{
		super(resultsPanel, frame);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		resultsPanel.setResultsPanel(resultsPanel.getPreviousResult());
		statusbar.setLeftLabelText("showing previous result");
	}
}
