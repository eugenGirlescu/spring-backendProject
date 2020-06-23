package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class User {

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
            String sql = "CREATE TABLE USERS" +
                    "(id SERIAL not NULL, " +
                    " firstName VARCHAR(255) not NULL, " +
                    " lastName VARCHAR(255) not NULL, " +
                    " email VARCHAR(255) UNIQUE not NULL, " +
                    " password VARCHAR(255) not NULL, " +
                    " PRIMARY KEY ( id ))";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
