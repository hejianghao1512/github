package com.zucc.hjh.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseUtil implements IController{
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class .forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/coresesystem?useUnicode=true&characterEncoding=utf-8";
			conn=DriverManager.getConnection(url,"root","root");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
	}
	public static void closeConnection(Connection conn){
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
