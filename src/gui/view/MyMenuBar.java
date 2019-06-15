package gui.view;

import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.sun.glass.events.KeyEvent;

import gui.controller.menu.MenuExitListener;
import gui.controller.menu.MenuPlayerListener;

@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar
{
	
	private JMenu menu;
	private JMenuItem addPlayer, exitApp;
	private ActionListener menuExit, menuPlayer;

	public MyMenuBar(MainFrame frame)
	{
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		add(menu);
		
		menuPlayer = new MenuPlayerListener(frame);
		menuExit = new MenuExitListener(frame);
		
		addPlayer = new JMenuItem("Add Player");
		addPlayer.setMnemonic(KeyEvent.VK_P);
		addPlayer.addActionListener(menuPlayer);
		
		exitApp = new JMenuItem("Exit application");
		exitApp.setMnemonic(KeyEvent.VK_X);
		exitApp.addActionListener(menuExit);
		
		menu.add(addPlayer);
		menu.add(exitApp);
	}
}
