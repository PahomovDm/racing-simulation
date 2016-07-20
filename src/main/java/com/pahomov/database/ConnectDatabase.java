package com.pahomov.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class ConnectDatabase {

    private static final String URL = "jdbc:mysql://localhost:3306/racingsimulation";
    private static final String USER = "root";
    private static final String PASSWORD = "Pahomov94";

    private static Connection con;
    private static Statement stmt;
    protected static ResultSet rs;
    protected String query;

    protected abstract void insert() throws SQLException;

    protected void runQuery(String query) {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            stmt = con.createStatement();

            stmt.executeUpdate(query);

        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
            } catch (SQLException se) {
            }
        }
    }

    protected void runQueryTo(String query) {
        try {
            con = DriverManager.getConnection(URL, USER, PASSWORD);

            stmt = con.createStatement();

            rs = stmt.executeQuery(query);

            insert();
        } catch (SQLException sqlEx) {
            sqlEx.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException se) {
            }
            try {
                stmt.close();
            } catch (SQLException se) {
            }
            try {
                rs.close();
            } catch (SQLException se) {
            }
        }
    }
}
