package gui.controller.menu;

import java.awt.event.ActionEvent;

import gui.controller.FrameListener;
import gui.view.MainFrame;

//added to menu item to display add player panel.

public class MenuPlayerListener extends FrameListener
{
	public MenuPlayerListener(MainFrame frame) 
	{
		super(frame);
	}

	public void actionPerformed(ActionEvent e) 
	{
		frame.displayAddPlayerPanel();
	}
}
