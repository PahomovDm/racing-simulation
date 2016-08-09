//package com.pahomov.mysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.List;
//
//import com.pahomov.History;
//import com.pahomov.dao.AbstractJdbcDao;
//import com.pahomov.dao.PersistException;
//
//public class MySqlHistoryDao extends AbstractJdbcDao<History, Integer> {
//
//    public MySqlHistoryDao(Connection connection) {
//        super(connection);
//        // TODO Auto-generated constructor stub
//    }
//
//    @Override
//    protected String getCreateQuery() {
//        String sql = "INSERT INTO racingsimulation.history (idmachine, idrace, position, avespeed, errors) \n"
//                + "VALUES (?, ?, ?, ?, ?);";
//        return sql;
//    }
//
//    @Override
//    protected void prepareStatementForInsert(PreparedStatement statement, History object) throws PersistException {
//        try {
//            statement.setInt(1, object.getIdMachine());
//            statement.setInt(2, object.getIdRace());
//            statement.setInt(3, object.getPosition());
//            statement.setInt(4, object.getAvespeed());
//            statement.setInt(5, object.getErrors());
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected String getSelectQuery() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    protected List<History> parseResultSet(ResultSet rs) throws PersistException {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    protected String getDeleteQuery() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    protected String getUpdateQuery() {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, History object) throws PersistException {
//        // TODO Auto-generated method stub
//
//    }
//
//}
