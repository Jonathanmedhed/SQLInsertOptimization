package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {

	/**
	 * Database info
	 */
	private String db = "jdbc:mysql://127.0.0.1/oop";
	private String un = "root";
	private String pw = "";

	private Connection conn;
	private Statement stmt;

	public DataSource() {

		/**
		 * Create connection and statement
		 */
		try {

			/**
			 * Connect to database
			 */
			conn = DriverManager.getConnection(db, un, pw);
			/**
			 * Get Statement from the connection
			 */
			stmt = conn.createStatement();

		} catch (SQLException se) {
			System.out.println("SQL Exception:");

			/**
			 * Loop for any SQL exception
			 */
			while (se != null) {
				System.out.println("State  : " + se.getSQLState());
				System.out.println("Message: " + se.getMessage());
				System.out.println("Error  : " + se.getErrorCode());

				se = se.getNextException();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Method to select from the database
	 */
	public ResultSet select(String query) {

		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return rs;
	}

	/**
	 * Method to insert into the database
	 */
	public boolean save(String query) {

		try {

			stmt.execute(query);
			return true;
		} catch (SQLException e) {

			e.printStackTrace();
			return false;
		}

	}

	/**
	 * Method to close the statement and the connection
	 */
	public void closing() {
		try {
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
