package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHandler extends Configs {
    Connection dbConnection;

    public Connection getConnection() throws SQLException {
        String connectionString = "jdbc:mysql://" + Configs.dbhost + ":" + Configs.dbport + "/" + Configs.dbname+"?autoReconnect=true&useSSL=false";
        dbConnection= DriverManager.getConnection(connectionString, Configs.dbuser, Configs.dbpast);
        return dbConnection;
    }
}
