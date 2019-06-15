package gui.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import gui.controller.resultpanel.PreviousResultListener;
import gui.controller.resultpanel.CurrentResultListener;
import model.interfaces.GameEngine;

@SuppressWarnings("serial")
public class ResultsPanel extends MyPanel 
{
	private JLabel results;
	private JTextArea textA;
	private JScrollPane scroll;
	private JButton submit, save;
	private String previousResult, currentResult;
	
	private ActionListener listener, listener2;
	
	public ResultsPanel(GameEngine gameEngine, MainFrame frame) 
	{
		super(gameEngine, frame);
		
		listener = new CurrentResultListener(this,frame);
		listener2 = new PreviousResultListener(this, frame);
		
		setLayout(new BorderLayout());
		Dimension minimumSize = new Dimension(200,50);
		results = new JLabel("Results");
		results.setBorder(new EmptyBorder(10,10,10,10));
		results.setMinimumSize(minimumSize);
		textA = new JTextArea();
		textA.setEditable(false);
		scroll = new JScrollPane(textA);
		scroll.setBorder(new EmptyBorder(10,10,10,10));
		save = new JButton("Current");
		submit = new JButton("Previous");
		
		save.addActionListener(listener);
		submit.addActionListener(listener2);
		
		JPanel subPanel = new JPanel();
		subPanel.add(save);
		subPanel.add(submit);
		
		add(results, BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(subPanel, BorderLayout.SOUTH);
	}
	
	public void appendResultsPanel(String text)
	{
		textA.append(text);
	}
	
	public void setResultsPanel(String text)
	{
		textA.setText(text);
	}
	
	public String getResultsPanel()
	{
		return textA.getText();
	}
	
	public String getPreviousResult() 
	{
		return previousResult;		
	}
	
	public String getCurrentResult() 
	{
		return currentResult;	
	}
	
	public void setCurrentResult(String text)
	{
		currentResult = text; 
	}
	
	public void setPreviousResult() 
	{
		previousResult = textA.getText();	
	}
	
}
