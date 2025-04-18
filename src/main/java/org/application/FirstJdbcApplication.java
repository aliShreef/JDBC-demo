package org.application;

import java.sql.*;

/**
 * FirstJdbcApplication
 */
public class FirstJdbcApplication {
    public static void main(String[] args) {
        Connection conn = null;

        try {
            // First way to register the driver, this more flexible since it's can be passed from property file or command argument
            loadDriver1();

            // second way to register the driver, this hard code and less flexible since it's accept the type
//            loadDriver2();

            System.out.println("Connecting to database...");
            String url = "jdbc:mysql://localhost:3306/jdbc-demo";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();
            String sql = "select * from employee";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("PK_ID");
                String name = rs.getString("NAME");
                Date hireDate = rs.getDate(3);
                double salary = rs.getDouble(4);
                System.out.println("ID: " + id + ", Name: " + name + ", Salary: " + salary + ", Hire Date: " + hireDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static void loadDriver1() throws ClassNotFoundException {
        String driver = "com.mysql.jdbc.Driver";
        Class.forName(driver);
    }

    private static void loadDriver2() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    }
}
