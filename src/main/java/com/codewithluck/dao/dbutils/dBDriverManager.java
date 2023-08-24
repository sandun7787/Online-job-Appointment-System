package com.codewithluck.dao.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

public interface dBDriverManager {
	
	public Connection getConnection()throws ClassNotFoundException, SQLException;

}
