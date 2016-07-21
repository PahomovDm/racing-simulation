package com.pahomov.database;

import java.sql.SQLException;

import java.sql.Connection;

public interface DaoFactory {
    Connection getConnection() throws SQLException;

    DaoTrack getTrackDao(Connection connection);
}
