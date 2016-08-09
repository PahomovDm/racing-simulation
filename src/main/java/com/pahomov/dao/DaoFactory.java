package com.pahomov.dao;
//
//import java.sql.Connection;
//import java.sql.SQLException;

public interface DaoFactory<Context> {
    public interface DaoCreator<Context> {
        DaoGeneric create(Context context);
    }

//    Connection getContext() throws SQLException;

    DaoGeneric getDao(Context context, Class dtoContext) throws PersistException;
}
