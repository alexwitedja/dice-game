package gui.controller;

import java.awt.event.ActionListener;

import gui.view.MainFrame;

//an abstract class inherited by listeners only containing frame.

public abstract class FrameListener implements ActionListener
{
	protected MainFrame frame;
	
	public FrameListener(MainFrame frame) 
	{
		this.frame = frame;
	}
}
