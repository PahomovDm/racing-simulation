package com.pahomov.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySqlDaoTrack implements GenericDao {

    public MySqlDaoTrack(Connection connection) {
        this.connection = connection;
    }

    private Connection connection;

    @Override
    public Track create() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Track read(int key) throws SQLException {
        String sql = "SELECT * FROM racingsimulation.track WHERE id = ?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setInt(1, key);

        ResultSet rs = stm.executeQuery();
        rs.next();
        Track track = new Track();
        track.setId(rs.getInt("id"));
        track.setName(rs.getString("name"));
        track.setDistance(rs.getInt("distance"));
        return track;
    }

    @Override
    public void update(Track track) {
        // TODO Auto-generated method stub

    }

    @Override
    public void delete(Track track) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Track> getAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object persist(Object object) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Object getByPK(int key) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void update(Object object) throws SQLException {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Object object) throws SQLException {
        // TODO Auto-generated method stub
        
    }

}
