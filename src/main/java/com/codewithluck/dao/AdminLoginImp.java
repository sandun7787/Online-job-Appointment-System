package com.codewithluck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codewithluck.dao.dbutils.dBDriverManager;
import com.codewithluck.dao.dbutils.dBDriverManagerFactory;
import com.codewithluck.model.Admin;



public class AdminLoginImp implements AdminLogin {
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		dBDriverManagerFactory driverFactory=new dBDriverManagerFactory();
		dBDriverManager driverManager=driverFactory.getDbDriver("MYSQL");
		return driverManager.getConnection();
		
	}
	

		

	@Override
	public Admin fetchSingleAdmin(String email)throws SQLException,ClassNotFoundException {
		Connection connection=getConnection();
		String query="SELECT * FROM  admin WHERE email=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1,email);
		
		ResultSet  rs=ps.executeQuery();
		Admin admin=new Admin();
		
		while(rs.next()) {
			admin.setEmail(rs.getString("email"));
			admin.setPassword(rs.getString("password"));
		}
		rs.close();
		connection.close();
		return admin;
	}

	
}	
