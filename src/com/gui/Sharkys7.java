package com.gui;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

import java.awt.event.*;
import java.awt.*;

import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Sharkys7 extends JFrame
{
	public final int WINDOW_WIDTH = 1200;
	public final int WINDOW_HEIGHT = 750;
	public JPanel login_panel;
	public JScrollPane scroll;
	public JTable table;
	public DefaultTableModel model;
	public ArrayList<Integer> random_ids = new ArrayList<Integer>();
	
	public Sharkys7()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(MenuBar(), BorderLayout.NORTH);
		add(buildLogin());
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setVisible(true);
		
		random_ids.add(500000000);
	}
	
	/**
	 * Builds the JMenuBar.
	 * @return menubar
	 */
	public Component MenuBar()
	{
		JMenuBar menubar = new JMenuBar();
		Border raise_etch = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
		menubar.setBorder(raise_etch);

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);

		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_E);
		exit.addActionListener(new ExitListener());
		file.add(exit);
		
		JMenu reports = new JMenu("Reports");
		reports.setMnemonic(KeyEvent.VK_R);
		
		JMenuItem masterItem = new JMenuItem("Master Report");
		masterItem.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem popularItem = new JMenuItem("Popularity Report");
		popularItem.setMnemonic(KeyEvent.VK_O);
		reports.add(masterItem);
		reports.add(popularItem);
		
		JMenu manage = new JMenu("Manage");
		manage.setMnemonic(KeyEvent.VK_M);
		
		JMenuItem gamesItem = new JMenuItem("Games");
		gamesItem.setMnemonic(KeyEvent.VK_G);
		
		JMenuItem transactionItem = new JMenuItem("Transactions");
		transactionItem.setMnemonic(KeyEvent.VK_T);
		
		JMenuItem membershipItem = new JMenuItem("Memberships");
		membershipItem.setMnemonic(KeyEvent.VK_M);
		
		JMenuItem employeeItem = new JMenuItem("Employees");
		employeeItem.setMnemonic(KeyEvent.VK_E);
		manage.add(gamesItem);
		manage.add(transactionItem);
		manage.add(membershipItem);
		manage.add(employeeItem);
		
		JMenu print = new JMenu("Print");
		print.setMnemonic(KeyEvent.VK_P);
		
		menubar.add(file);
		menubar.add(reports);
		menubar.add(manage);
		menubar.add(print);
		
		return menubar;
	}
	/**
	 * Exits the program when user clicks the 'Exit' menu item.
	 *
	 */
	public class ExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.exit(0);
		}
	}
	
	public class TransferListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			int row_index = table.getSelectedRow();
			table.setValueAt("bleh", row_index, 0);
		}
	}
	
	/**
	 * Builds the Login Screen when the program is started.
	 * @return login_panel
	 */
	public Component buildLogin()
	{
		login_panel = new JPanel();
		JPanel left_side = new JPanel();
		login_panel.setLayout(new BoxLayout(login_panel, BoxLayout.LINE_AXIS));
		login_panel.setBackground(new Color(2, 176, 176));
		
		login_panel.setBorder(BorderFactory.createLineBorder(Color.RED));
		left_side.setOpaque(false);
		
		left_side.setLayout(new BoxLayout(left_side, BoxLayout.Y_AXIS));
		
		JLabel shark_lbl = new JLabel("<html>Sharky's<br> Gameroom</html>");
		
		shark_lbl.setFont(new Font("Broadway", Font.PLAIN, 70));
		shark_lbl.setBackground(new Color(2, 176, 176));
		shark_lbl.setForeground(Color.WHITE);
		shark_lbl.setOpaque(true);
		shark_lbl.setBorder(BorderFactory.createEmptyBorder(0, 120, 0, 0)); //used to center the text
		
		JLabel uncw_logo = new JLabel("UNCW LOGO");
		uncw_logo.setFont(new Font("Verdana", Font.ITALIC, 50));
		uncw_logo.setBorder(BorderFactory.createEmptyBorder(20, 150, 0, 0));
		
		left_side.add(shark_lbl);
		left_side.add(uncw_logo);
		login_panel.add(left_side);
		
		JPanel right_side = new JPanel(new FlowLayout());
		right_side.setBackground(new Color(2, 131, 131));
		right_side.setBorder(BorderFactory.createEmptyBorder(
									250, //top
									0, 	   //left
									25, //bottom
									0));   //right
		JSeparator line = new JSeparator(JSeparator.VERTICAL);
		line.setForeground(Color.WHITE);
		login_panel.add(line);

		right_side.add(buildLoginBox());
		right_side.setPreferredSize(new Dimension(500, 250));//500, 550
		
		
		login_panel.add(right_side);
		
		return login_panel;
	}
	
	/**
	 * Builds the Login Box where the user will enter their credentials.
	 * @return
	 */
	public Component buildLoginBox()
	{
		GridBagConstraints c = new GridBagConstraints();
		
		final JPanel p = new JPanel();
		p.setPreferredSize(new Dimension(250, 150));
		p.setBackground(new Color(2, 176, 176));
		Border raise = BorderFactory.createRaisedBevelBorder();
		p.setBorder(raise);
		p.setLayout(new GridBagLayout());
		
		JLabel login = new JLabel("Login");
		login.setFont(new Font("Verdana", Font.BOLD, 14));
		login.setForeground(Color.WHITE);
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0;
		c.insets = new Insets(10, 10, 0, 30); //top, left, bottom, right
		p.add(login, c);
		
		JPanel labels = new JPanel(new GridLayout(0,1,2,15)); //0,1,2,11//rows, cols, hgap, vgap
		labels.setBackground(new Color(2, 176, 176));
		JLabel usname = new JLabel("Username");
		usname.setFont(new Font("Verdana", Font.BOLD, 12));
		usname.setForeground(Color.WHITE);
		labels.add(usname);
		JLabel pswd = new JLabel("Password");
		pswd.setFont(new Font("Verdana", Font.BOLD, 12));
		pswd.setForeground(Color.WHITE);
		labels.add(pswd);
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 10;
		c.insets = new Insets(0,10,0,10); //top, left, bottom, right
		p.add(labels, c);
		
		JPanel controls = new JPanel(new GridLayout(0,1,2,10));
		controls.setBackground(new Color(2, 176, 176));
		final JTextField username = new JTextField();
		username.setFont(new Font("Verdana", Font.PLAIN, 10));
		c.insets = new Insets(5, 10, 0, 10);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 5;
		c.weighty = 5;
		c.ipady = 5;
		controls.add(username, c);
		final JTextField password = new JTextField();
		password.setFont(new Font("Verdana", Font.PLAIN, 10));
		password.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				p.setVisible(false);
				login_panel.setVisible(false);
				if(authorize(username.getText(), password.getText()))
				{
					p.setVisible(false);
					getContentPane().add(buildMainPanel());
				}
				else{
					JOptionPane.showMessageDialog(p, "Invalid username or password");
					username.setText("");
					password.setText("");
				}
			}
		});
		controls.add(password, c);
		c.gridx = 1;
		c.gridy = 1;
		p.add(controls,c);
		
		JPanel buttons = new JPanel(new GridLayout(1,0,10,10));
		buttons.setBackground(new Color(2, 176, 176));
		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnOK.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnOK.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				p.setVisible(false);
				login_panel.setVisible(false);
				getContentPane().add(buildMainPanel());
				if(authorize(username.getText(), password.getText()))
				{
					p.setVisible(false);
					getContentPane().add(buildMainPanel());
				}
				else
				{
					JOptionPane.showMessageDialog(p, "Invalid username or password");
					username.setText("");
					password.setText("");
				}
			}
		});
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Verdana", Font.PLAIN, 10));
		btnCancel.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		
		c.ipady = 0;
		c.weightx = 0;
		c.weighty = 7; //makes gap between button and bottom of frame
		buttons.add(btnOK, c);
		buttons.add(btnCancel, c);
		
		c.gridx = 1;
		c.gridy = 2;
		c.insets = new Insets(0,-30,0,40); //0,-50,0,20
		p.add(buttons, c);
		
		return p;
	}
	
	/**
	 * Builds the Main Panel when the user has successfully logged in.
	 * @return
	 */
	public Component buildMainPanel()
	{
		JPanel main_panel = new JPanel();
		main_panel.setBackground(new Color(2, 131, 131));
		add(BottomPanel(), BorderLayout.SOUTH);
		add(RightPanel(), BorderLayout.EAST);
		add(LeftPanel(), BorderLayout.WEST);
		
		return main_panel;
	}
	
	/**
	 * Builds the bottom panel of the Main Panel and consists of the buttons
	 * "Membership", "Cash Out", "Transfer", and "Stop".
	 * 
	 * @return
	 */
	public Component BottomPanel()
	{
		JPanel bottom_panel = new JPanel();
		Border new_border = BorderFactory.createRaisedSoftBevelBorder();
		bottom_panel.setLayout(new BorderLayout(0, 20)); // hgap, vgap (not sure if 20 does anything)
		bottom_panel.setBackground(new Color(3, 131, 131));
		bottom_panel.setPreferredSize(new Dimension(WINDOW_WIDTH, 100));
		
		JPanel test = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 4)); // int align, hgap, vgap
		test.setBackground(new Color(3, 131, 131));
		test.setPreferredSize(new Dimension(500, 70));//300,70
		//test.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //used just to show position
		
		JButton member_btn = new JButton("Membership");
		member_btn.setBorder(new_border);
		member_btn.setPreferredSize(new Dimension(150, 95));//100,95
		member_btn.setBackground(new Color(2, 176, 176));
		member_btn.setForeground(Color.WHITE);
		member_btn.setFont(new Font("Arial", Font.BOLD, 14));
		member_btn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		member_btn.setFocusable(false);
		test.add(member_btn);
		
		test.add(Box.createRigidArea(new Dimension(5, 10)));
		
		JButton cash_out_btn = new JButton("Cash Out");
		cash_out_btn.setBorder(new_border);
		cash_out_btn.setPreferredSize(new Dimension(150, 95));
		cash_out_btn.setBackground(new Color(2, 176, 176));
		cash_out_btn.setForeground(Color.WHITE);
		cash_out_btn.setFont(new Font("Arial", Font.BOLD, 14));
		cash_out_btn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		cash_out_btn.setFocusable(false);
		test.add(cash_out_btn);
		
		bottom_panel.add(test, BorderLayout.WEST);
		
		JPanel test2 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 4)); // int align, hgap, vgap
		test2.setBackground(new Color(3, 131, 131));
		test2.setPreferredSize(new Dimension(400, 70));
		//test2.setBorder(BorderFactory.createLineBorder(Color.WHITE)); //used just to show position
		
		JButton transfer_btn = new JButton("Transfer");
		transfer_btn.setBorder(new_border);
		transfer_btn.setPreferredSize(new Dimension(150, 95));
		transfer_btn.setBackground(new Color(2, 176, 176));
		transfer_btn.setForeground(Color.WHITE);
		transfer_btn.setFont(new Font("Arial", Font.BOLD, 14));
		transfer_btn.setAlignmentY(Component.CENTER_ALIGNMENT);
		transfer_btn.setFocusable(false);
		transfer_btn.addActionListener(new TransferListener());
		test2.add(transfer_btn);
		
		test2.add(Box.createRigidArea(new Dimension(5, 10)));
		
		JButton stop_btn = new JButton("Stop");
		stop_btn.setBorder(new_border);
		stop_btn.setPreferredSize(new Dimension(150, 95));
		stop_btn.setBackground(new Color(2, 176, 176));
		stop_btn.setForeground(Color.WHITE);
		stop_btn.setFont(new Font("Arial", Font.BOLD, 14));
		stop_btn.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		stop_btn.setFocusable(false);
		test2.add(stop_btn);
		
		//test2.add(Box.createRigidArea(new Dimension(5, 10)));
		
		bottom_panel.add(test2, BorderLayout.EAST);
		
		return bottom_panel;
	}
	
	/**
	 * Builds the left side of the Main Panel and it consists of 3 pool table buttons,
	 * a ping pong button, a Wii button, Xbox button, and DDR button.
	 * 
	 * @return
	 */
	public Component LeftPanel()
	{
		final JPanel left_panel = new JPanel();
		left_panel.setBackground(new Color(2, 176, 176));
		left_panel.setPreferredSize(new Dimension(820, 400));

		GridBagConstraints c = new GridBagConstraints();
		
		JPanel pool_panel = new JPanel();
		pool_panel.setPreferredSize(new Dimension(100, 100));
		pool_panel.setBackground(new Color(2, 176, 176));
		
		ImageIcon pool_icon = new ImageIcon(getClass().getResource("pool1tc.png"));
		Image bimg = pool_icon.getImage().getScaledInstance(120, 70, java.awt.Image.SCALE_SMOOTH);
		ImageIcon new_icon = new ImageIcon(bimg);
		JButton pool_button1 = new JButton(new_icon);
		pool_button1.setPreferredSize(new Dimension(120, 70));
		
		pool_button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = JOptionPane.showInputDialog(left_panel, "Enter name or student ID:", "Pool Table 1", JOptionPane.OK_CANCEL_OPTION);
				if(input != null){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "Pool", "Table 1"});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "Pool", "Table 1"});
					} 
					else {
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		JButton pool_button2 = new JButton(new_icon);
		pool_button2.setPreferredSize(new Dimension(120, 70));
		
		pool_button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = JOptionPane.showInputDialog(left_panel, "Enter name or student ID:", "Pool Table 2", JOptionPane.OK_CANCEL_OPTION);
				if(input != null){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "Pool", "Table 2"});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "Pool", "Table 2"});
					}
					else{
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		ImageIcon wii_icon = new ImageIcon(getClass().getResource("Wii-1.png"));
		Image wii_bimg = wii_icon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon wii = new ImageIcon(wii_bimg);
		JButton wii_button = new JButton(wii);
		wii_button.setPreferredSize(new Dimension(60,60));
		wii_button.setBorderPainted(false);
		wii_button.setOpaque(false);
		wii_button.setContentAreaFilled(false);
		
		wii_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String[] items = {"Game 1", "Game 2", "Game 3"};
				JComboBox<?> jcb = new JComboBox<Object>(items);
				
				Object[] comps = {
						"Select Game", jcb,
						"Enter student ID or name"
				};
				String input = JOptionPane.showInputDialog(left_panel, comps, "Wii", JOptionPane.OK_CANCEL_OPTION);
				String wiiGame = jcb.getSelectedItem().toString();

				if(input.isEmpty()){
					JOptionPane.showMessageDialog(left_panel, "Please enter a name or student ID");
				}
				if(input != null && input.isEmpty() == false){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "Wii", wiiGame});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "Wii", wiiGame});
					}
					else{
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		ImageIcon xbox_icon = new ImageIcon(getClass().getResource("xbox.png"));
		Image xbox_bimg = xbox_icon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon xbox = new ImageIcon(xbox_bimg);
		JButton xbox_button = new JButton(xbox);
		xbox_button.setPreferredSize(new Dimension(60,60));
		xbox_button.setBorderPainted(false);
		xbox_button.setOpaque(false);
		xbox_button.setContentAreaFilled(false);
		
		xbox_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String[] items = {"Game 1", "Game 2", "Game 3"};
				JComboBox<?> jcb = new JComboBox<Object>(items);
				
				//JTextField input = new JTextField();
				
				Object[] comps = {
						"Select Game", jcb,
						"Enter student ID or name"
				};
				String input = JOptionPane.showInputDialog(left_panel, comps, "Xbox", JOptionPane.OK_CANCEL_OPTION);
				String videoGame = jcb.getSelectedItem().toString();
				if(input.isEmpty()){
					JOptionPane.showMessageDialog(left_panel, "Please enter a name or student ID");
				}
				if(input != null && input.isEmpty() == false){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "Xbox", videoGame});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "Xbox", videoGame});
					}
					else{
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		ImageIcon ddr_icon = new ImageIcon(getClass().getResource("DDR-icon.png"));
		Image ddr_bimg = ddr_icon.getImage().getScaledInstance(60, 60, java.awt.Image.SCALE_SMOOTH);
		ImageIcon ddr = new ImageIcon(ddr_bimg);
		JButton ddr_button = new JButton(ddr);
		ddr_button.setPreferredSize(new Dimension(60,60));
		ddr_button.setBorderPainted(false);
		ddr_button.setOpaque(false);
		ddr_button.setContentAreaFilled(false);
		
		ddr_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = JOptionPane.showInputDialog(left_panel, "Enter name or student ID:", "DDR", JOptionPane.OK_CANCEL_OPTION);
				if(input != null){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "DDR", "null"});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "DDR", "null"});
					}
					else{
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		JPanel box_panel = new JPanel();
		box_panel.setBackground(new Color(2, 176, 176));
		box_panel.setLayout(new GridLayout(3, 1, 10, 10));
		box_panel.add(wii_button);
		box_panel.add(xbox_button);
		box_panel.add(ddr_button);
		
		ImageIcon pool_iconr = new ImageIcon(getClass().getResource("pool1r.png"));
		Image bimgr = pool_iconr.getImage().getScaledInstance(70, 120, java.awt.Image.SCALE_SMOOTH);
		ImageIcon new_iconr = new ImageIcon(bimgr);
		JButton pool_button3 = new JButton(new_iconr);
		pool_button3.setPreferredSize(new Dimension(70, 120)); //50, 100
		pool_button3.setBorderPainted(false);
		pool_button3.setOpaque(false);
		pool_button3.setContentAreaFilled(false);
		
		pool_button3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = JOptionPane.showInputDialog(left_panel, "Enter name or student ID:", "Pool Table 3", JOptionPane.OK_CANCEL_OPTION);
				if(input != null){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "Pool", "Table 3"});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "Pool", "Table 3"});
					}
					else{
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		ImageIcon pp_icon = new ImageIcon(getClass().getResource("pp-rotate2.png"));
		Image pp_bimg = pp_icon.getImage().getScaledInstance(240, 200, java.awt.Image.SCALE_SMOOTH); //190, 150
		ImageIcon new_pp = new ImageIcon(pp_bimg);
		JButton pp_button = new JButton(new_pp);
		pp_button.setPreferredSize(new Dimension(180,150)); //140, 110
		pp_button.setOpaque(false);
		pp_button.setContentAreaFilled(false);
		pp_button.setBorderPainted(false);
		
		pp_button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String input = JOptionPane.showInputDialog(left_panel, "Enter name or student ID:", "Ping Pong", JOptionPane.OK_CANCEL_OPTION);
				if(input != null){
					if(input.matches("[A-Z a-z]*"))
					{
						model.addRow(new Object[]{getRandomID(), input, "Ping Pong", "null"});
					}
					else if(input.matches("[0-9]*") && input.length() == 9){
						model.addRow(new Object[]{input, "Database Name", "Ping Pong", "null"});
					}
					else{
						JOptionPane.showMessageDialog(left_panel, "Invalid input");
					}
				}
			}
		});
		
		Box box = Box.createVerticalBox();
		box.add(pool_button1);
		box.add(Box.createVerticalStrut(5));
		box.add(pool_button2);
		
		Box box2 = Box.createHorizontalBox();
		box2.add(pool_button3);
		box2.add(Box.createHorizontalStrut(5));
		box2.add(box);
		
		Box box3 = Box.createVerticalBox();
		box3.add(pp_button);
		box3.add(box2);
		
		JLabel logo = new JLabel("Sharky's Gameroom");
		logo.setFont(new Font("Broadway", Font.PLAIN, 70));
		logo.setForeground(Color.WHITE);
		
		JPanel logo_panel = new JPanel();
		logo_panel.setSize(820, 100);
		logo_panel.setBackground(new Color(2, 176, 176));
		logo_panel.add(logo);
		
		JPanel ping_pool = new JPanel();
		ping_pool.setLayout(new GridBagLayout());
		ping_pool.setBackground(new Color(2, 176, 176));
		
		c.gridx = 0; //0
		c.gridy = 0; //0
		c.insets = new Insets(50, 0, 0, 0); //50,0,0,0
		ping_pool.add(wii_button, c);
		
		c.gridx = 0; //0
		c.gridy = 1; //1
		c.insets = new Insets(10, 0, 0, 0); //10,0,0,0
		ping_pool.add(xbox_button, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(10, 0, 0, 0);
		ping_pool.add(ddr_button, c);
		
		c.gridx = 2; //2
		c.gridy = 0; //0
		c.insets = new Insets(50,200,0,0); // top, left, bottom, right
		ping_pool.add(pp_button, c);
		
		c.insets = new Insets(0, 200, 40, 30);
		c.gridx = 2; //2
		c.gridy = 2; //2
		ping_pool.add(box2, c);
		
		left_panel.add(logo_panel);
		left_panel.add(ping_pool);
		
		
		
		return left_panel;
	}
	
	/**
	 * Builds the right side of the Main Panel and consists of the table containing
	 * all of the customers who are currently active in the gameroom. The table shows
	 * the customers ID number, their name, what game they are playing, and any details
	 * about that game. 
	 * @return
	 */
	public Component RightPanel()
	{
		JPanel right_panel = new JPanel(new BorderLayout());
		right_panel.setBackground(Color.WHITE);
		right_panel.setPreferredSize(new Dimension(350, 400));
		
		String[] columnNames = {"ID", "Name", "Game", "Details"};
//		Object[][] data = {
//					{"850000000", "Amanda Zimecki", "Pool", "Table 1"}, 
//					{"850111111", "Kelsey Smith", "Wii", "Mario Kart"},
//					{"500000000", "Greg Gronn", "Ping Pong", "null"}
//					};
		//table = new JTable(data, columnNames);
		model = new DefaultTableModel();
		
		for(int i = 0; i < columnNames.length; i++)
		{
			model.addColumn(columnNames[i]);
		}
		model.addRow(new Object[]{"850000000", "Amanda Zimecki", "Pool", "Table 1"});

		table = new JTable(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		// This part is what adjusts the column widths
		final TableColumnModel columnModel = table.getColumnModel();
	    for (int column = 0; column < table.getColumnCount(); column++) 
	    {
	        int width = 50; // Minimum width
	        for (int row = 0; row < table.getRowCount(); row++) 
	        {
	            TableCellRenderer renderer = table.getCellRenderer(row, column);
	            Component comp = table.prepareRenderer(renderer, row, column);
	            width = Math.max(comp.getPreferredSize().width, width);
	        }
	        columnModel.getColumn(column).setPreferredWidth(width);
	    }
	    // end adjustments
	    
	    scroll = new JScrollPane(table);
		scroll.getViewport().setBackground(Color.WHITE);
		right_panel.add(scroll, BorderLayout.CENTER);
		
		return right_panel;
	}
	
	public int getRandomID()
	{
		int next_id = (random_ids.get(random_ids.size()-1)) + 1;
		random_ids.add(next_id);
		
		return next_id;
	}
	
	public static boolean authorize(String un, String pw){
		if(un.equals("") && pw.equals("")){
			return true;
		}
		return false;
	}
	public static void main(String[] args)
	{
		Sharkys7 shark = new Sharkys7();
	}
}

