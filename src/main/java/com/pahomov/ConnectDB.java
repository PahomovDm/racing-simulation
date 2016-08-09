package com.pahomov;

import java.sql.Connection;

import org.apache.log4j.Logger;

import com.pahomov.dao.DaoFactory;
import com.pahomov.dao.DaoGeneric;
import com.pahomov.dao.PersistException;
import com.pahomov.machine.AbstractMachine;
import com.pahomov.mysql.MySqlDaoFactory;

public class ConnectDB {
    public static final Logger LOG = Logger.getLogger(ConnectDB.class);
    private DaoFactory factory;
    private DaoGeneric dao;
    private Connection connection = null;
    private DbcpConfig dbcp = new DbcpConfig();

    protected DaoGeneric connect() {
        factory = new MySqlDaoFactory();
        try {
            connection = dbcp.connect();
            dao = factory.getDao(connection, AbstractMachine.class);
        } catch (PersistException e) {
            LOG.error(e.getMessage());
        }
        return dao;
    }

    protected void close() {
        this.dbcp.close();
    }
}
