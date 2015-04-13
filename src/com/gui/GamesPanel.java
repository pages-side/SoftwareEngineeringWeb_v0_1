/*package com.gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.dataaccess.DbAccessor;
import com.dataaccess.DbConn;
import com.dataaccess.delete.DeleteProduct;

*//**
 * A class that creates the content of the Manage Games List Window
 *
 * @author  Kelsey Smith
 * @version 1.0, 04/08/15
 *//*
public class GamesPanel {
	private static final int PREF_W = 500;
	private static final int PREF_H = 500;
	private JPanel mainPanel;
	private JTable table;
	private JButton printButton;
	private JButton addGameButton;
	private JPanel buttonPanel;
	private ImageIcon deleteIcon;

	*//**
	 * Constructor for GamesPanel
	 *//*
	public GamesPanel() {

		// create buttons
		printButton = new JButton();
		addGameButton = new JButton("Add Game");
		try {
			Image img = ImageIO.read(getClass().getResource("smallprint.png"));
			printButton.setIcon(new ImageIcon(img));
			Image deleteImg = ImageIO.read(getClass().getResource(
					"deletebuttonsmall.png"));
			deleteIcon = new ImageIcon(deleteImg);
		} catch (IOException ex) {
			System.out.println("Image not found");
		}

		mainPanel = new JPanel();
		mainPanel.setBorder(null);
		mainPanel.setPreferredSize(new Dimension(PREF_W, PREF_H));

		// create report table
		table = new JTable(new DefaultTableModel(new Object[] { "Game I.D.",
				"Game Name", "Game Platform", "Delete Game" }, 0));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		table.getColumnModel().getColumn(2).setPreferredWidth(120);
		table.setRowHeight(35);
		populateTable();
		JScrollPane pane1 = new JScrollPane(table);

		// create delete game column
		AbstractAction delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				//create confirmation popup
				int selectedOption = JOptionPane.showConfirmDialog(null,
						new JLabel(
								"Are you sure you want to delete this game? "),
								"Remove Game", JOptionPane.YES_NO_OPTION);
				//delete entry from database
				if (selectedOption == JOptionPane.YES_OPTION) {



					int modelRow = Integer.valueOf(e.getActionCommand());
					DeleteProduct daDelete = new DeleteProduct();
					daDelete.setPno(table.getValueAt(modelRow, 0) + "'");
					if(!daDelete.execute()){
						TODO - better errorhandling here
						System.err.println("Unable to delete " + table.getValueAt(modelRow, 0) + "'");
					}else{
						((DefaultTableModel) table.getModel()).removeRow(modelRow);	
					}


				}
			}
		}; // end delete entry from database

		ButtonColumn buttonColumn = new ButtonColumn(table, delete, 3);

		// create button Panel
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(PREF_W, 50));
		buttonPanel.setLayout(new BorderLayout());

		addGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new BorderLayout(5, 5));

				JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
				label.add(new JLabel("Game Name", SwingConstants.RIGHT));
				label.add(new JLabel("Game Platform", SwingConstants.RIGHT));
				panel.add(label, BorderLayout.WEST);
				JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));

				//create game name textfield with length limit of 25 characters
				JTextField gameNameTextField = new JTextField();
				gameNameTextField.setDocument(new FixedSizeDocument(25));
				controls.add(gameNameTextField);

				//prepopulate combobox with existing platforms
				final DefaultComboBoxModel platforms = new DefaultComboBoxModel();
				platforms.addElement("Wii");
				platforms.addElement("Xbox");
				JComboBox platformCombo = new JComboBox(platforms);
				controls.add(platformCombo);

				panel.add(controls, BorderLayout.CENTER);

				int selectedOption = JOptionPane.showConfirmDialog(null, panel,
						"Add Game", JOptionPane.OK_CANCEL_OPTION);

				//if user chooses to add game
				if (selectedOption == JOptionPane.OK_OPTION) {
					Connection conn = null;
					Statement stmt = null;
					ResultSet rs = null;
					try {
						DbConn dbConn = new DbConn();
						conn = dbConn.getConn();
						stmt = conn.createStatement();
						stmt.executeUpdate("insert into s_product(name, platform) values ('"
								+ gameNameTextField.getText()
								+ "', '"
								+ platformCombo.getSelectedItem() + "')");
						DefaultTableModel model = (DefaultTableModel) table
								.getModel();
						int maxID = 0;
						Statement s2 = conn.createStatement();
						s2.execute("SELECT MAX(pno) FROM s_product");
						ResultSet rs2 = s2.getResultSet(); //
						if (rs2.next()) {
							maxID = rs2.getInt(1);
						}
						model.addRow(new Object[] { maxID,
								gameNameTextField.getText(),
								platformCombo.getSelectedItem(), deleteIcon });
						System.out.println("row added");

					} catch (SQLException err) {
						System.err.println(err.getMessage());
					} finally {
						if (stmt != null) {
							try {
								stmt.close();
							} catch (SQLException sqle) {
							}
						}
						if (conn != null) {
							try {
								conn.close();
							} catch (SQLException sqle) {
							}
						}
						if (DbConn.getSession() != null) {
							DbConn.getSession().disconnect();
							DbConn.setSession(null);
						}
						if (DbConn.getConn() != null) {
							DbConn.setConnection(null);
						}
					}
				}
			}
		}); //end add game

		printButton.setPreferredSize(new Dimension(45, 45));

		pane1.setBackground(Color.decode("#FFFFFF"));
		pane1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		pane1.setPreferredSize(new Dimension(PREF_W, PREF_H - 50));

		// add buttons and report to window
		mainPanel.setLayout(new FlowLayout());
		buttonPanel.add(printButton, BorderLayout.LINE_START);
		buttonPanel.add(addGameButton, BorderLayout.LINE_END);
		mainPanel.add(buttonPanel, BorderLayout.PAGE_START);
		mainPanel.add(pane1, BorderLayout.PAGE_END);
	}

	*//**
	 * Returns the main panel of the Manage Games List frame 
	 *
	 * @param     N/A
	 * @return    the panel that contains all functions of Manage Games List
	 *//*
	public JPanel getMainPanel() {
		return mainPanel;
	}

	*//**
	 * Populates the Games List Table with all games in the database
	 *
	 * @param     N/A
	 * @return    N/A
	 *//*
	public void populateTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			if (DbConn.getConn() == null) {
				DbConn dbConn = new DbConn();
				conn = dbConn.getConn();
			} else {
				conn = DbConn.getConn();
			}
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from s_product");
			while (rs.next()) {
				String id = rs.getString("pno");
				String name = rs.getString("name");
				String platform = rs.getString("platform");
				model.addRow(new Object[] { id, name, platform, deleteIcon });
			}
		} catch (SQLException err) {
			System.err.println(err.getMessage());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
				}
			}
			if (DbConn.getSession() != null) {
				DbConn.getSession().disconnect();
				DbConn.setSession(null);
			}
			if (DbConn.getConn() != null) {
				DbConn.setConnection(null);
			}
		}
	}
}
*/