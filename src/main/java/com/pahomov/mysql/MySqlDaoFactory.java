package com.pahomov.mysql;

import java.sql.Connection;
//import java.sql.SQLException;
//import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import com.pahomov.dao.*;
import com.pahomov.machine.AbstractMachine;

public class MySqlDaoFactory implements DaoFactory<Connection> {

    private String user = "root";
    private String password = "Pahomov94";
    private String url = "jdbc:mysql://localhost:3306/racingsimulation";
    private String driver = "com.mysql.jdbc.Driver";
    private Map<Class, DaoCreator> creators;

    public MySqlDaoFactory() {
        try {
            Class.forName(driver); // Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        creators = new HashMap<Class, DaoCreator>();

        creators.put(AbstractMachine.class, new DaoCreator<Connection>() {

            public MySqlMachineDao create(Connection connection) {
                return new MySqlMachineDao(connection);
            }

        });

    }

//    public Connection getContext() throws SQLException {
//        return DriverManager.getConnection(url, user, password);
//    }

    public DaoGeneric getDao(Connection connection, Class dtoClass) throws PersistException {
        DaoCreator creator = creators.get(dtoClass);
        if (creator == null) {
            throw new PersistException("Dao object for " + dtoClass + " not found.");
        }
        return creator.create(connection);

    }
}
