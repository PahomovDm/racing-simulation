package com.pahomov.database;

import java.sql.SQLException;
import java.util.List;

public interface DaoHistory {
    History create();

    History read(int key) throws SQLException;

    void update(History track);

    void delete(History track);

    List<History> getAll() throws SQLException;
}
