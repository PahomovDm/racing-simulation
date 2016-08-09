package com.pahomov.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import java.io.Serializable;

import com.pahomov.Test;
import com.pahomov.dao.AbstractJdbcDao;
import com.pahomov.dao.PersistException;
import com.pahomov.machine.AbstractMachine;

public class MySqlMachineDao extends AbstractJdbcDao<AbstractMachine, Integer> implements Serializable {
    public static final Logger LOG = Logger.getLogger(Test.class);

    private class PersistAbstractMachine extends AbstractMachine {

        private static final long serialVersionUID = 1L;

        public void setId(int id) {
            super.setId(id);
        }
    }

    public MySqlMachineDao(Connection connection) {
        super(connection);
    }

    @Override
    public String getCreateQuery() {
        String sql = "INSERT INTO racingsimulation.machine (type, name, massa, maxSpeed, acceleration) \n"
                + "VALUES (?, ?, ?, ?, ?);";
        return sql;
    }

    @Override
    public String getDeleteQuery() {
        return "DELETE FROM racingsimulation.machine WHERE id = ?;";

    }

    @Override
    public String getSelectQuery() {
        return "SELECT id, type, name, massa, maxspeed, acceleration FROM racingsimulation.machine ";

    }

    public String getSelectQueryWithMassa400(int hour) {
        return "SELECT id, type, name, massa, maxspeed, acceleration FROM racingsimulation.machine WHERE "
                + "UNIX_TIMESTAMP() - unix_timestamp(modificationtime) < " + hour * 3600;

    }

    @Override
    protected String getUpdateQuery() {
        return "UPDATE racingsimulation.machine SET name= ?, massa = ?, maxspeed = ?, acceleration = ? WHERE id = ?;";

    }

    protected void prepareStatementForInsert(PreparedStatement statement, AbstractMachine object)
            throws PersistException {
        try {
            statement.setString(1, object.getType());
            statement.setString(2, object.getName());
            statement.setInt(3, object.getMassa());
            statement.setDouble(4, object.getMaxSpeed());
            statement.setDouble(5, object.getAcceleration());

        } catch (Exception e) {
            LOG.info(e.getMessage());
        }
    }

    @Override
    protected List<AbstractMachine> parseResultSet(ResultSet rs) throws PersistException {
        LinkedList<AbstractMachine> result = new LinkedList<AbstractMachine>();
        try {
            while (rs.next()) {
                PersistAbstractMachine machine = new PersistAbstractMachine();
                machine.setId(rs.getInt("id"));
                machine.setType(rs.getString("type"));
                machine.setName(rs.getString("name"));
                machine.setMassa(rs.getInt("massa"));
                machine.setMaxSpeed(rs.getDouble("maxspeed"));
                machine.setAcceleration(rs.getDouble("acceleration"));
                result.add(machine);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return result;
    }

    @Override
    protected void prepareStatementForUpdate(PreparedStatement statement, AbstractMachine object)
            throws PersistException {
        try {
            statement.setString(1, object.getName());
            statement.setInt(2, object.getMassa());
            statement.setDouble(3, object.getMaxSpeed());
            statement.setDouble(4, object.getAcceleration());
            statement.setInt(5, object.getId());
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public List<AbstractMachine> sortMachineTime(int hour) throws PersistException {
        List<AbstractMachine> list;
        String sql = getSelectQueryWithMassa400(hour);
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

}
