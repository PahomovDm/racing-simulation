package com.pahomov;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

public class DbcpConfig {
    public static final Logger LOG = Logger.getLogger(DbcpConfig.class);
    private Connection conn;
    private static BasicDataSource ds = new BasicDataSource();

    public Connection connect() {
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/racingsimulation");
        ds.setUsername("root");
        ds.setPassword("Pahomov94");

        ds.setMaxIdle(1);
        ds.setMaxActive(5);
        ds.setRemoveAbandoned(true);
        ds.setMaxWait(10);

        try {
            conn = ds.getConnection();
            LOG.info("Connect DBCP OPEN!");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
        return conn;
    }

    public void close() {
        try {
            if (conn != null) {
            conn.close();
            conn = null;
            }
            LOG.info("Connect DBCP Close!");
        } catch (SQLException e) {
            LOG.error(e.getMessage());
        }
    }
}
