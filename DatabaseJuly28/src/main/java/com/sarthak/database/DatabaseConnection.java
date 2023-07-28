package com.sarthak.database;

import java.sql.*;

public class DatabaseConnection {
    private final String url = "jdbc:postgresql://localhost/student";
    private final String user = "postgres";
    private final String password = "sqlpwd404";
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
            stmt = conn.createStatement();
            String sql = "CREATE TABLE STUDENTSINBUILDING " +
                    "(ID INT PRIMARY KEY     NOT NULL," +
                    " NAME           TEXT    NOT NULL, " +
                    " AGE            INT     NOT NULL, " +
                    " ADDRESS        CHAR(50), " +
                    " LEVEL         REAL)";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        System.out.println("Table created successfully");
        return conn;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseConnection app = new DatabaseConnection();
        app.connect();
    }
}