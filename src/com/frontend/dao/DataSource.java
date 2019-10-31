package com.frontend.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataSource {
	
	//@Resource(name="")
	//public EntityManager em;
	static Connection con;
	
	
	public static void init() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/tiw","tiw","tiw");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
	
	public ResultSet selectAll(String tabla) {
		ResultSet rs = null;
		try {
			Statement stmt=con.createStatement();  
			rs = stmt.executeQuery("select * from " + tabla);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return rs;
	}
	
	public ResultSet selectById(String tabla, int id) {
		ResultSet rs = null;
		try {
			Statement stmt=con.createStatement();  
			rs = stmt.executeQuery("select * from " + tabla + " where id=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return rs;
	}
	
	
	public ResultSet selectUserByEmailAndPassword(String tabla, String email, String passwd) {
		ResultSet rs = null;
		try {
			Statement stmt=con.createStatement();  
			rs = stmt.executeQuery("select * from " + tabla + " where email=" + email + " and password=" + passwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return rs;
	}
	
	public int DeleteById(String tabla, int id) {
		int rs = 0;
		try {
			
			Statement stmt=con.createStatement();  
			rs = stmt.executeUpdate("DELETE FROM " + tabla  + " where id=" + id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return rs;
	}
	
}
