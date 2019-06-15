package gui.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class StatusBarPanel extends JPanel
{
	
	private JLabel statusLabel1 = new JLabel("status", JLabel.LEFT);
	private JLabel statusLabel2 = new JLabel("game status", JLabel.CENTER);
	private JLabel statusLabel3 = new JLabel("player status", JLabel.RIGHT);

	public StatusBarPanel()
	{
		setLayout(new GridLayout(1, 3));
		Border blackBorder = BorderFactory.createLineBorder(Color.BLACK);
		statusLabel1.setBorder(blackBorder);
		statusLabel2.setBorder(blackBorder);
		statusLabel3.setBorder(blackBorder);

		add(statusLabel1);
		add(statusLabel2);
		add(statusLabel3);
	}
	
	public void setLeftLabelText(String text) 
	{
		statusLabel1.setText(text);		
	}
	
	public void setMiddleLabelText(String text) 
	{
		statusLabel2.setText(text);		
	}

	public void setRightLabelText(String text) 
	{
		statusLabel3.setText(text);	
	}
}
