package gui.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;

import model.interfaces.GameEngine;

//a panel inherited by other panels for layout management.
@SuppressWarnings("serial")
public abstract class MyPanel extends JPanel
{
	private GridBagConstraints gbc = new GridBagConstraints();
	private final int SPACING = 10;

	public MyPanel(GameEngine gameEngine, MainFrame frame) 
	{
		setLayout(new GridBagLayout());
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = new Insets(SPACING,SPACING,SPACING,SPACING);
		
	}
	
	protected void addComponent(Component component, int x, int y) 
	{
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		add(component, gbc);
	}
}
