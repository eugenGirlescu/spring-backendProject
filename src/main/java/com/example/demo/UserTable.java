package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserTable {

    private static final String url = "jdbc:postgresql://localhost/inchirieridb";
    private static final String user = "postgres";
    private static final String password = "ciuriburic1";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            stmt = conn.createStatement();
            String sql = "INSERT INTO users ( firstName, lastName, email , password)"
                    + "VALUES ( '$(user.firstName)', '$(user.lastName)', '$(user.email)', '$(user.password)'" +
                    ")";


            stmt.executeUpdate(sql);
            System.out.println("Succesfull inserted...");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
