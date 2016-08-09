//package com.pahomov.mysql;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.LinkedList;
//import java.util.List;
//
//import com.pahomov.Track;
//import com.pahomov.dao.AbstractJdbcDao;
//import com.pahomov.dao.PersistException;
//
//public class MySqlTrackDao extends AbstractJdbcDao<Track, Integer> {
//
//    private class PersistTrack extends Track {
//
//        public void setId(int id) {
//            super.setId(id);
//        }
//    }
//
//    public MySqlTrackDao(Connection connection) {
//        super(connection);
//    }
//
//    @Override
//    public String getCreateQuery() {
//        String sql = "INSERT INTO racingsimulation.track (name, distance) \n" + "VALUES (?, ?);";
//        return sql;
//    }
//
//    @Override
//    public String getDeleteQuery() {
//        return "DELETE FROM racingsimulation.track WHERE id = ?;";
//
//    }
//
//    @Override
//    public String getSelectQuery() {
//        return "SELECT id, name, distance FROM racingsimulation.track";
//
//    }
//
//    @Override
//    protected String getUpdateQuery() {
//        return "UPDATE racingsimulation.track SET name= ?, distance = ? WHERE id= ?;";
//
//    }
//
//    protected void prepareStatementForInsert(PreparedStatement statement, Track object) throws PersistException {
//        try {
//            statement.setString(1, object.getName());
//            statement.setInt(2, object.getDistance());
//
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    protected List<Track> parseResultSet(ResultSet rs) throws PersistException {
//        LinkedList<Track> result = new LinkedList<Track>();
//        try {
//            while (rs.next()) {
//                PersistTrack track = new PersistTrack();
//                track.setId(rs.getInt("id"));
//                track.setName(rs.getString("name"));
//                track.setDistance(rs.getInt("distance"));
//                result.add(track);
//            }
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//        return result;
//    }
//
//    @Override
//    protected void prepareStatementForUpdate(PreparedStatement statement, Track object) throws PersistException {
//        try {
//            statement.setString(1, object.getName());
//            statement.setInt(2, object.getDistance());
//            statement.setInt(3, object.getId());
//        } catch (Exception e) {
//            throw new PersistException(e);
//        }
//    }
//
//}
