package com.pahomov.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public abstract class AbstractJdbcDao<T extends Identified<PK>, PK extends Integer> implements DaoGeneric<T, PK> {

    protected Connection connection;

    public AbstractJdbcDao(Connection connection) {
        this.connection = connection;
    }

    public AbstractJdbcDao() {
    }

    protected abstract String getUpdateQuery();

    protected abstract String getCreateQuery(); // sql команда на добавление

    protected abstract String getSelectQuery(); // sql команда на просмотр

    protected abstract List<T> parseResultSet(ResultSet rs) throws PersistException; // обработка
                                                                                     // из
                                                                                     // бд
    // в класс

    protected abstract void prepareStatementForUpdate(PreparedStatement statement, T object)
            throws com.pahomov.dao.PersistException;

    protected abstract String getDeleteQuery();

    protected abstract void prepareStatementForInsert(PreparedStatement statement, T object) throws PersistException;

    public void create(T object) throws PersistException {
        String sql = getCreateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            prepareStatementForInsert(statement, object);
            int count = statement.executeUpdate();
            if (count != 1) {
                throw new PersistException("On persist modify more then 1 record: " + count);
            }
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public T read(Integer key) throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        sql += " WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, key);
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list.iterator().next();

    }

    @Override
    public void update(T object) throws PersistException {
        String sql = getUpdateQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql);) {
            prepareStatementForUpdate(statement, object);
            statement.executeUpdate();

        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    @Override
    public void delete(int id) throws PersistException {
        String sql = getDeleteQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            try {
                statement.setInt(1, id);
            } catch (Exception e) {
                throw new PersistException(e);
            }
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            throw new PersistException(e);
        }
    }

    public List<T> getAll() throws PersistException {
        List<T> list;
        String sql = getSelectQuery();
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            list = parseResultSet(rs);
        } catch (Exception e) {
            throw new PersistException(e);
        }
        return list;
    }

}
