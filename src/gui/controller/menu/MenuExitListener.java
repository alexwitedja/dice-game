package gui.controller.menu;

import java.awt.event.ActionEvent;

import gui.controller.FrameListener;
import gui.view.MainFrame;

//added to menu item to close the application.

public class MenuExitListener extends FrameListener
{
	public MenuExitListener(MainFrame frame) 
	{
		super(frame);
	}

	public void actionPerformed(ActionEvent arg0) 
	{
		frame.closeApp();
	}

}
