/**
 * 
 */
package com.rslakra.healthtracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author lakra
 *
 */
public class DBTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// JDBC 3.0
		String dbName = "test";
		String hostUrl = "jdbc:mysql://localhost:3306/" + dbName;
		String user = "rslakra";
		String password = "Lakra@Sql";

		// JDBC 4.0
		String databaseURL = hostUrl + "?user=" + user + "&password=" + password;

		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// JDBC 3.0
//			conn = DriverManager.getConnection(hostUrl, user, password);

			// JDBC 4.0
			conn = DriverManager.getConnection(databaseURL);

			if (conn != null) {
				System.out.println("Connected to the database");
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Could not find database driver class");
			ex.printStackTrace();
		} catch (SQLException ex) {
			System.out.println("An error occurred. Maybe user/password is invalid");
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

}
