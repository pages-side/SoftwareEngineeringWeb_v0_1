package com.dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class DbConn {
	private final String REMOTE_HOST = "webdev.cislabs.uncw.edu";
	private final int REMOTE_PORT = 3306;
	private final int LOCAL_PORT = 3309;
	private final String DATABASE_NAME="test";
	private final String USER_NAME = "gg5855";
	private final String DB_PASSWORD = "bike1117";
	private final String SSH_PASSWORD = "vdNAkzfJF";
	protected static Connection conn = null;
	protected Session session = null;
	private int assigned_port=-1;
	public DbConn(){

		conn = null;
		try {
			JSch jsch = new JSch();
			Class.forName("com.mysql.jdbc.Driver");
			if(session == null){
				session=jsch.getSession(USER_NAME, REMOTE_HOST, 22);
				session.setPassword(SSH_PASSWORD);
				java.util.Properties config = new java.util.Properties(); 
				config.put("StrictHostKeyChecking", "no");
				session.setConfig(config);
				session.connect();
				assigned_port=session.setPortForwardingL(LOCAL_PORT, REMOTE_HOST, REMOTE_PORT);
			}
			System.out.println("CONNECTED:localhost:"+assigned_port+" -> "+REMOTE_HOST+":"+REMOTE_PORT);
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:"+assigned_port+"/" + DATABASE_NAME + "?" +  "user="+ USER_NAME +"?password=" + DB_PASSWORD);

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConn(){
		return conn;
	}
	public static Object getSession() {
		// TODO Auto-generated method stub
		return null;
	}
	public static void setSession(Object object) {
		// TODO Auto-generated method stub
		
	}
	public static void setConnection(Object object) {
		// TODO Auto-generated method stub
		
	}
// This is kelseys new stuff
/*	java.sql.Statement stmt = conn.createStatement();
    stmt.executeUpdate(
                    "insert into s_product values (1234569, 'Mario Karttttt', 'WII', 20100203, 0, false)");
    conn.close();
    }catch(SQLException err){
            System.err.println(err.getMessage());
    }*/
}
