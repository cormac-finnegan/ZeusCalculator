package com.ait.Database;

import java.sql.DriverManager;

import java.sql.Connection;

public class Dao {

	public Connection getConnection() {
		Connection con = null;
		try {
			/*String url = "jdbc:mysql://localhost:3306/zeus_maths";
			con = DriverManager.getConnection(url, "root", "admin");*/	//localhost db
			
			String url = "jdbc:sqlserver://masezeusdb.database.windows.net:1433;database=masezeusdb;user=zeus2017@masezeusdb;password=Mase2017;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
			con = DriverManager.getConnection(url);	//Azure cloud db
		} catch (Exception e) {
			System.out.print("Failed to initialise DB Connection");
			System.out.println(e);
		}
		return con;
	}
}
