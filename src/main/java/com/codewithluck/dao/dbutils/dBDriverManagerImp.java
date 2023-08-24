package com.codewithluck.dao.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dBDriverManagerImp implements dBDriverManager {


	public Connection getConnection() throws ClassNotFoundException, SQLException {
		 Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://127.0.0.1:3306/job-online";
			String userName = "root";
			String password = "Sandun19680129";
			
			return DriverManager.getConnection(url, userName, password);
		}

	}