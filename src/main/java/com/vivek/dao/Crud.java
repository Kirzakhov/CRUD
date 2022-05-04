package com.vivek.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class Crud {
	public static int insert(String name, String pass) throws SQLException {
		Connection con = Connectivity.getConnection();
		String s = "insert into login values(?, ?)";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, name);
		pst.setString(2, pass);
		int i = pst.executeUpdate();
		con.close();
		return i;
	}
	public static int update(String name, String pass) throws SQLException {
		Connection con = Connectivity.getConnection();
		String s = "select * from login where uname=?";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		int i = 0;
		if(rs.next()) {
			String q = "update login set upass=? where uname=?";
			pst = con.prepareStatement(q);
			pst.setString(1, pass);
			pst.setString(2, name);
			i = pst.executeUpdate();
		}
		return i;
	}
	public static int delete(String name) throws SQLException {
		Connection con = Connectivity.getConnection();
		String s = "select * from login where uname=?";
		PreparedStatement pst = con.prepareStatement(s);
		pst.setString(1, name);
		ResultSet rs = pst.executeQuery();
		int i = 0;
		if(rs.next()) {
			String q = "delete from login where uname=?";
			pst = con.prepareStatement(q);
			pst.setString(1, name);
			i = pst.executeUpdate();
		}
		return i;
	}
	public static HashMap<String, String> display() throws SQLException {
		HashMap<String, String> hm = new HashMap<String, String>();
		Connection con = Connectivity.getConnection();
		String s = "select * from login";
		PreparedStatement pst = con.prepareStatement(s);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			String name = rs.getString(1);
			String pass = rs.getString(2);
			hm.put(name, pass);
		}
		con.close();
		return hm;
	}
}
