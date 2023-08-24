package com.codewithluck.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.codewithluck.dao.dbutils.dBDriverManager;
import com.codewithluck.dao.dbutils.dBDriverManagerFactory;
import com.codewithluck.model.Consulter;

public class ConsulterLoginImp implements ConsulterLogin {
	
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		dBDriverManagerFactory driverFactory=new dBDriverManagerFactory();
		dBDriverManager driverManager=driverFactory.getDbDriver("MYSQL");
		return driverManager.getConnection();
		
	}


	@Override
	public Consulter fetchSingleConsulter(String email) throws SQLException, ClassNotFoundException {
	
		Connection connection=getConnection();
		String query="SELECT * FROM  Consulter WHERE email=?";
		PreparedStatement ps=connection.prepareStatement(query);
		ps.setString(1,email);
		
		ResultSet  rs=ps.executeQuery();
		Consulter consulter=new Consulter();
		
		while(rs.next()) {
			consulter.setEmail(rs.getString("email"));
			consulter.setPassword(rs.getString("password"));
			
		}
		rs.close();
		connection.close();
		return consulter;
	}

	
}	
