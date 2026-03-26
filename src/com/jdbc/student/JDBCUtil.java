package com.jdbc.student;

import java.sql.*;

public class JDBCUtil {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getMySqlConnection() {
        String url = "jdbc:mysql://localhost:3306/studenttest?useSSL=false&serverTimezone=UTC";

        try {
            return DriverManager.getConnection(url, "root", "Kartik@2005");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeResource(ResultSet rs, Statement st, Connection con) {
        try {
            if (rs != null)
                rs.close();

            if (st != null)
                st.close();

            if (con != null)
                con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}