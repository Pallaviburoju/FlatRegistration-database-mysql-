package com.cpg.frsdb.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	public Connection connect() {
		
		   Connection con=null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg","root","pal0918@");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Class.forName("com.mysql.cj.jdbc.Driver");
			//connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/capg", "root","pal0918@");
			
		
		return con;
	
	}
}
