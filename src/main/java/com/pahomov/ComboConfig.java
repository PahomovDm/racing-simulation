//package com.pahomov;
//
//import java.beans.PropertyVetoException;
//import java.sql.Connection;
//import java.sql.SQLException;
//import java.util.Properties;
//
//import org.apache.log4j.Logger;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//
//public final class ComboConfig {
//
//    public static final Logger LOG = Logger.getLogger(Test.class);
//    private Connection connection = null;
//    private static int maxPoolSize = 10;
//    private static int minPoolSize = 5;
//    private static int acquireIncrement = 5;
//    private static int maxStatements = 180;
//    static ComboPooledDataSource ds = new ComboPooledDataSource();
//
//    public ComboConfig() {
//
//    }
//
//    public static void main(final String[] args) throws PropertyVetoException {
//        ds.setDriverClass("com.mysql.jdbc.Driver");
//        ds.setUser("root");
//        ds.setPassword("Pahomov94");
//        ds.setJdbcUrl("jdbc:mysql://localhost:3306/racingsimulation");
//
//        Properties properties = new Properties();
//        properties.setProperty("user", "root");
//        properties.setProperty("password", "Pahomov94");
//        properties.setProperty("useUnicode", "true");
//        properties.setProperty("characterEncoding", "UTF8");
//        ds.setProperties(properties);
//
//        ds.setMaxPoolSize(maxPoolSize);
//        ds.setMinPoolSize(minPoolSize);
//        ds.setAcquireIncrement(acquireIncrement);
//        ds.setMaxStatements(maxStatements);
//    }
//
//    public Connection connect() {
//        LOG.info("Start ComboConfig");
//        try {
//            connection = ds.getConnection();
//        } catch (SQLException e) {
//            LOG.error(e.getMessage());
//        }
//        LOG.info("Return connection");
//        return connection;
//
//    }
//
//    public void close() {
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            LOG.error(e.getMessage());
//        }
//    }
//}
