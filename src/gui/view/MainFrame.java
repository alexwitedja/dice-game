package gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;

import model.interfaces.GameEngine;

//main frame, where all the components are combined.

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{
	@SuppressWarnings("unused")
	private GameEngine gameEngine;
	
	private JSplitPane panelCont;
	private MyToolBar toolbar;
	private StatusBarPanel statusbar;
	private MyMenuBar menuBar;
	
	private MyPanel addPlayerPanel, betPanel, dicePanel, resultsPanel;
	
	public MainFrame(GameEngine gameEngine)
	{
		super("Dice Game");
		setBounds(100, 100, 640, 480);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1000,500));
		setLayout(new BorderLayout());
		
		this.gameEngine = gameEngine;
		
		statusbar = new StatusBarPanel();
		toolbar = new MyToolBar(gameEngine, this);
		menuBar = new MyMenuBar(this);
		
		addPlayerPanel = new AddPlayerPanel(gameEngine, this);	
		betPanel = new BetPanel(gameEngine, this);
		dicePanel = new DicePanel(gameEngine, this);	
		
		resultsPanel = new ResultsPanel(gameEngine, this);
		
		panelCont = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, resultsPanel, dicePanel);

		setJMenuBar(menuBar);
		
		add(panelCont, BorderLayout.CENTER);
		add(toolbar, BorderLayout.PAGE_START);
		add(statusbar, BorderLayout.PAGE_END);

		setVisible(true);	
	}
	
	public void closeApp() 
	{
		System.exit(0);
	}
	
	public void displayAddPlayerPanel() 
	{
		JOptionPane.showMessageDialog(null, addPlayerPanel);	
	}
	
	public void displayBetPanel() 
	{
		JOptionPane.showMessageDialog(null, betPanel);	
	}
	
	public void displayErrorMessage(String text) 
	{	
		JOptionPane.showMessageDialog(this, text);	
	}
	
	public MyToolBar getToolbar() 
	{
		return toolbar;
	}
	
	public StatusBarPanel getStatusBar() 
	{
		return statusbar;
	}
	
	public MyPanel getResultsPanel() 
	{
		return resultsPanel;
	}
	
	public MyPanel getDicePanel() 
	{
		return dicePanel;
	}
}
