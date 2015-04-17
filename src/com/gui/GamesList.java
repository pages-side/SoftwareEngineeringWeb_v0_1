/*package com.gui;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class GamesList extends JFrame{
	
	JMenuBar menuBar;

	public static void main(String args[]) {
		GamesList gamesList = new GamesList();
		gamesList.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamesList.pack();
		gamesList.setLocationRelativeTo(null);
		gamesList.setLocationByPlatform(true);
		gamesList.setVisible(true);
	}

	public void createMenuBar() {
		menuBar = new JMenuBar();
		JMenu file = new JMenu("File");
		JMenuItem exitItem = new JMenuItem("Exit");
		file.add(exitItem);
		menuBar.add(file);
	}

	public GamesList() {
		setTitle("Games List");
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout(1, 5));
		createMenuBar();
		setJMenuBar(menuBar);
		GamesPanel gamesPanel = new GamesPanel();
		contentPane.add(gamesPanel.getMainPanel(), BorderLayout.CENTER);
	}

}
*/