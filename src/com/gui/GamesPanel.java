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

import com.dataaccess.DbConn;

*//**
 * A class that creates the content of the Manage Games List Window
 *
 * @author Kelsey Smith
 * @version 1.0, 04/08/15
 *//*
public class GamesPanel {

	// class constants
	private static final int PREF_W = 500;
	private static final int PREF_H = 500;
	private static final int ROW_H = 35;
	private static final int IDCOL_W = 80;
	private static final int NAMECOL_W = 160;
	private static final int PLATCOL_W = 120;
	private static final int buttonPanel_H = 50;
	private static final int printButton_W = 45;
	private static final int printButton_H = 45;
	private static final int scrollPane_H = 450;
	private static final int nameCharLimit = 25;
	private static final String printButtonPath = "";
	private static final String deleteButtonPath = "";

	// GamesPanel member variables
	private JPanel combinedPanel;
	private JPanel mainPanel;
	private JTable table;
	private JButton printButton;
	private JButton addGameButton;
	private JPanel buttonPanel;
	private ImageIcon deleteIcon;
	private AbstractAction delete;
	private AbstractAction save;
	private AbstractAction edit;

	*//**
	 * Constructor for GamesPanel
	 *//*
	public GamesPanel() {
		// create main panel
		mainPanel = new JPanel();
		mainPanel.setBorder(null);
		mainPanel.setPreferredSize(new Dimension(PREF_W, PREF_H));

		combinedPanel = new JPanel();
		combinedPanel.setBorder(null);
		combinedPanel.setPreferredSize(new Dimension(PREF_W, PREF_H));

		// create buttons
		printButton = new JButton();
		printButton
				.setPreferredSize(new Dimension(printButton_W, printButton_H));
		try {
			Image img = ImageIO.read(getClass().getResource(printButtonPath));
			printButton.setIcon(new ImageIcon(img));
			Image deleteImg = ImageIO.read(getClass().getResource(
					deleteButtonPath));
			deleteIcon = new ImageIcon(deleteImg);
		} catch (IOException ex) {
			System.err.println("Image not found");
		}
		table = new JTable(new MyModel(new Object[] { "Game I.D.", "Game Name",
				"Game Platform", "Edit", "Save", "Delete" }, 0));

		addGameButton = new JButton("Add Game");
		addGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel panel = new JPanel(new BorderLayout(5, 5));

				JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
				label.add(new JLabel("Game Name", SwingConstants.RIGHT));
				label.add(new JLabel("Game Platform", SwingConstants.RIGHT));
				panel.add(label, BorderLayout.WEST);
				JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));

				// create game name textfield with character limit
				JTextField gameNameTextField = new JTextField();
				gameNameTextField.setDocument(new FixedSizeDocument(
						nameCharLimit));
				controls.add(gameNameTextField);

				// prepopulate combobox with existing platforms
				final DefaultComboBoxModel platforms = new DefaultComboBoxModel();
				platforms.addElement("Wii");
				platforms.addElement("Xbox");
				JComboBox platformCombo = new JComboBox(platforms);
				controls.add(platformCombo);

				panel.add(controls, BorderLayout.CENTER);

				int selectedOption = JOptionPane.showConfirmDialog(null, panel,
						"Add Game", JOptionPane.OK_CANCEL_OPTION);

				// if user chooses to add game, add new game entity to database
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
								platformCombo.getSelectedItem(), "Edit",
								"Save", deleteIcon });
						ButtonColumn deletebuttonColumn = new ButtonColumn(
								table, delete, 5);
						ButtonColumn editButtonColumn = new ButtonColumn(table,
								edit, 3);
						ButtonColumn saveButtonColumn = new ButtonColumn(table,
								save, 4);
						((MyModel) model).addCell(model.getRowCount() - 1, 0,
								false);
						((MyModel) model).addCell(model.getRowCount() - 1, 1,
								false);
						((MyModel) model).addCell(model.getRowCount() - 1, 2,
								false);
						((MyModel) model).addCell(model.getRowCount() - 1, 3,
								true);
						((MyModel) model).addCell(model.getRowCount() - 1, 4,
								false);
						((MyModel) model).addCell(model.getRowCount() - 1, 5,
								true);
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
		}); // end add game
		// create delete game column
		delete = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// create confirmation popup
				int selectedOption = JOptionPane.showConfirmDialog(null,
						new JLabel(
								"Are you sure you want to delete this game? "),
						"Remove Game", JOptionPane.YES_NO_OPTION);
				// delete entry from database
				if (selectedOption == JOptionPane.YES_OPTION) {
					Connection conn = null;
					Statement stmt = null;
					try {
						DbConn dbConn = new DbConn();
						conn = dbConn.getConn();
						stmt = conn.createStatement();
						int modelRow = Integer.valueOf(e.getActionCommand());
						stmt.executeUpdate("delete from s_product where pno = '"
								+ table.getValueAt(modelRow, 0) + "'");
						((DefaultTableModel) table.getModel())
								.removeRow(modelRow);
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
		}; // end delete entry from database

		save = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				int modelRow = Integer.valueOf(e.getActionCommand());
				if ((table.getValueAt(modelRow, 2).equals("Wii") || table
						.getValueAt(modelRow, 2).equals("Xbox"))
						&& ((String) table.getValueAt(modelRow, 1)).length() < 26) {
					Connection conn = null;
					Statement stmt = null;
					try {
						DbConn dbConn = new DbConn();
						conn = dbConn.getConn();
						stmt = conn.createStatement();
						stmt.executeUpdate("update s_product set name = '"
								+ table.getValueAt(modelRow, 1)
								+ "' where pno = '"
								+ table.getValueAt(modelRow, 0) + "'");
						stmt.executeUpdate("update s_product set platform = '"
								+ table.getValueAt(modelRow, 2)
								+ "' where pno = '"
								+ table.getValueAt(modelRow, 0) + "'");
						((MyModel) table.getModel())
								.setCellEditable(
										Integer.valueOf(e.getActionCommand()),
										1, false);
						((MyModel) table.getModel())
								.setCellEditable(
										Integer.valueOf(e.getActionCommand()),
										2, false);
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
					//make the edit button editable and save button not editable
					((MyModel) table.getModel()).setCellEditable(
							Integer.valueOf(e.getActionCommand()), 3, true);
					((MyModel) table.getModel()).setCellEditable(
							Integer.valueOf(e.getActionCommand()), 4, false);
				} else {
					// custom title, error icon
					JOptionPane
							.showMessageDialog(
									null,
									"Error saving. Please make sure that the game name is at most 25"
											+ "\n"
											+ "characters and that the platform is spelled and capitalized correctly.",
									"error", JOptionPane.ERROR_MESSAGE);
				}

			}
		}; // end save entry from database

		edit = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				// makes the game name and game platform columns editable
				((MyModel) table.getModel()).setCellEditable(
						Integer.valueOf(e.getActionCommand()), 1, true);
				((MyModel) table.getModel()).setCellEditable(
						Integer.valueOf(e.getActionCommand()), 2, true);
				
				//make the save button editable and edit button not editable
				((MyModel) table.getModel()).setCellEditable(
						Integer.valueOf(e.getActionCommand()), 3, false);
				((MyModel) table.getModel()).setCellEditable(
						Integer.valueOf(e.getActionCommand()), 4, true);
			}
		}; // end edit entry from database

		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.getColumnModel().getColumn(0).setPreferredWidth(IDCOL_W);
		table.getColumnModel().getColumn(1).setPreferredWidth(NAMECOL_W);
		table.getColumnModel().getColumn(2).setPreferredWidth(PLATCOL_W);
		table.setRowHeight(ROW_H);

		// populate table with existing games
		populateTable();

		// create scroll pane that contains the games list table
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setBackground(Color.decode("#FFFFFF"));
		tableScrollPane
				.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		tableScrollPane.setPreferredSize(new Dimension(PREF_W, scrollPane_H));

		// Make delete game column with delete buttons
		ButtonColumn editButtonColumn = new ButtonColumn(table, edit, 3);
		ButtonColumn saveButtonColumn = new ButtonColumn(table, save, 4);
		ButtonColumn deletebuttonColumn = new ButtonColumn(table, delete, 5);

		// create Buttons Panel with add and print buttons
		buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(PREF_W, buttonPanel_H));
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(printButton, BorderLayout.LINE_START);
		buttonPanel.add(addGameButton, BorderLayout.LINE_END);

		// add buttons and table to main panel
		combinedPanel.setLayout(new FlowLayout());
		combinedPanel.add(buttonPanel, BorderLayout.PAGE_START);
		combinedPanel.add(tableScrollPane, BorderLayout.PAGE_END);
		mainPanel.add(combinedPanel, BorderLayout.CENTER);
	}

	*//**
	 * Returns the main panel of the Manage Games List frame
	 *
	 * @param N
	 *            /A
	 * @return the panel that contains all functions of Manage Games List
	 *//*
	public JPanel getMainPanel() {
		return mainPanel;
	}

	*//**
	 * Populates the Games List Table with all games in the database
	 *
	 * @param N
	 *            /A
	 * @return N/A
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
				model.addRow(new Object[] { id, name, platform, "Edit", "Save",
						deleteIcon });
				((MyModel) model).addCell(model.getRowCount() - 1, 0, false);
				((MyModel) model).addCell(model.getRowCount() - 1, 1, false);
				((MyModel) model).addCell(model.getRowCount() - 1, 2, false);
				((MyModel) model).addCell(model.getRowCount() - 1, 3, true);
				((MyModel) model).addCell(model.getRowCount() - 1, 4, false);
				((MyModel) model).addCell(model.getRowCount() - 1, 5, true);
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