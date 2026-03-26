package com.jdbc.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentApp {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement psInsert = null;
		PreparedStatement psSelect = null;
	//	PreparedStatement psDelete = null;
		ResultSet rs = null;
		Statement st = null;

		try {
		    // 1. Get connection
		    con = JDBCUtil.getMySqlConnection();

		    // 🔥 CREATE TABLE
		    st = con.createStatement();

		    String createTableQuery = "CREATE TABLE IF NOT EXISTS studenttest (" +
		                              "id INT PRIMARY KEY, " +
		                              "name VARCHAR(50), " +
		                              "marks DOUBLE, " +
		                              "mobileNo VARCHAR(15))";

		    st.executeUpdate(createTableQuery);
		    System.out.println("Table created successfully");

		    // 2. INSERT QUERY
		    String insertQuery = "INSERT INTO studenttest (id, name, marks, mobileNo) VALUES (?, ?, ?, ?)";
		    psInsert = con.prepareStatement(insertQuery);
		//	int rows = psInsert.executeUpdate();
//1
			psInsert.setInt(1, 101);
			psInsert.setString(2, "Kartik");
			psInsert.setDouble(3, 85.5);
			psInsert.setString(4, "7828201241");
			psInsert.executeUpdate();
//2
			psInsert.setInt(1, 102);
			psInsert.setString(2, "Rahul");
			psInsert.setDouble(3, 78.0);
			psInsert.setString(4, "9876543210");
			psInsert.executeUpdate();
//3
			psInsert.setInt(1, 103);
			psInsert.setString(2, "Aman");
			psInsert.setDouble(3, 91.2);
			psInsert.setString(4, "9123456780");
			psInsert.executeUpdate();
//4
			psInsert.setInt(1, 104);
			psInsert.setString(2, "Priya");
			psInsert.setDouble(3, 88.7);
			psInsert.setString(4, "9988776655");
			psInsert.executeUpdate();
//5
			psInsert.setInt(1, 105);
			psInsert.setString(2, "Sneha");
			psInsert.setDouble(3, 82.3);
			psInsert.setString(4, "9090909090");
			psInsert.executeUpdate();

			System.out.println("Multiple students inserted ");
			
			System.out.println("Inserted rows: " + insertQuery);

			// 3. SELECT QUERY
			String selectQuery = "SELECT * FROM studenttest";
			psSelect = con.prepareStatement(selectQuery);

			rs = psSelect.executeQuery();

			System.out.println("\n--- Student Data ---");
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("marks") + " "
						+ rs.getString("mobileNo"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(rs, psInsert, con);
		}
	}
}