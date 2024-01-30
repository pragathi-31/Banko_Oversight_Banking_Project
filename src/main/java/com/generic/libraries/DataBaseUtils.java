package com.generic.libraries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtils {


	Connection conn;
	/**
	 * This method is used to register the driver and build connection
	 * @throws SQLException
	 */
	public void registerDriver() throws SQLException {

		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn = DriverManager.getConnection(IpathConstants.DURL, IpathConstants.DUSERNAME, IpathConstants.DPASSWORD);
	}
	/**
	 * This method will verify whether data is present in database or not
	 * @param query
	 * @param colIndex
	 * @param ExpectedData
	 * @return
	 * @throws SQLException
	 */
	public String exeQuery(String query, int colIndex, String ExpectedData) throws SQLException {

		Statement state = conn.createStatement();
		ResultSet res = state.executeQuery(query);
		String actual="";
		boolean flag=false;
		while(res.next()) {
			actual = res.getString(colIndex);
			if(actual.equalsIgnoreCase(ExpectedData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			return actual;
		}else {
			return "";
		}

	}
	/**
	 * this method is used to close the connection
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		conn.close();
	}


}

