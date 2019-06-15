package gui.controller.toolbar;

import java.awt.event.ActionEvent;

import gui.controller.FrameListener;
import gui.view.MainFrame;

//a listener to show bet panel.

public class ShowBetPanelListener extends FrameListener
{
	public ShowBetPanelListener(MainFrame frame) 
	{
		super(frame);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		frame.displayBetPanel();
	}
}
