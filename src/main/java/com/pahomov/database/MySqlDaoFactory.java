package com.pahomov.database;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class MySqlDaoFactory implements DaoFactory {

    private static final String URL = "jdbc:mysql://localhost:3306/racingsimulation";
    private static final String USER = "root";
    private static final String PASSWORD = "Pahomov94";
    private String driver = "com.mysql.jdbc.Driver";

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    @Override
    public DaoTrack getTrackDao(Connection connection) {
        return new MySqlDaoTrack(connection);
    }

    public MySqlDaoFactory() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
