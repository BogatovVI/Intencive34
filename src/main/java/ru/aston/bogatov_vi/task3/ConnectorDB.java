package ru.aston.bogatov_vi.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectorDB {
    private static Connection connection;

    private ConnectorDB() {}

    public static Connection getConnection() throws SQLException{
        if (connection == null){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("application");
            String url = resourceBundle.getString("db.url");
            String user = resourceBundle.getString("db.user");
            String password = resourceBundle.getString("db.password");
            String dbName = resourceBundle.getString("db.name");

            connection = DriverManager.getConnection(url + dbName, user, password);
            return connection;
        }

        return connection;
    }
}