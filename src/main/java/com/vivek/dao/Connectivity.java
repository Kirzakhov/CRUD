package com.vivek.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connectivity {
	public static String url = "jdbc:mysql://localhost:3306/vivek";
	public static String un = "root";
	public static String up = "0000";
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,un,up);
			if(con!=null) {
				System.out.println("Connection established");
			}
			else {
				System.out.println("Connection not established");
			}
		}
		catch(Exception e) {
			
		}
		return con;
	}
}
