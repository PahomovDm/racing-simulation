package com.pahomov;

import java.sql.Connection;
import java.sql.SQLException;

import com.pahomov.database.*;

final class Test {

    private Test() {

    }

    public static void main(String[] args) throws SQLException {

        DaoFactory dF = new MySqlDaoFactory();
        try (Connection con = dF.getConnection()) {
            DaoTrack dao = dF.getTrackDao(con);
            Track track = dao.read(8);
            System.out.println(track.toString());
        }
    }
}
