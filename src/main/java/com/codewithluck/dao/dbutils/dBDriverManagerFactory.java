package com.codewithluck.dao.dbutils;



public class dBDriverManagerFactory {

	public dBDriverManager getDbDriver(String databaseType) {
		if(databaseType.equals("MYSQL")) {
			return new dBDriverManagerImp();
		}
		return null;
	}
	

}
