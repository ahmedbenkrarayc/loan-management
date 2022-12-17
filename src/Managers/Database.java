package Managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Database class
 */
public class Database {
    /**
     * constant attribut for the address ip of database
     */
    private static final String DB_IP = "127.0.0.1";
    /**
     * constant attribut for the port of mysql database
     */
    private static final String DB_PORT = "3306";
    /**
     * constant attribut for database name
     */
    private static final String DB_NAME = "library";
    /**
     * constant for database url
     */
    private static final String DB_URL = "jdbc:mysql://"+DB_IP+":"+DB_PORT+"/"+DB_NAME;
    /**
     * constant for database username
     */
    private static final String DB_USERNAME = "root";
    /**
     * constant for database password
     */
    private static final String DB_PASSWORD = "";
    /**
     * Declaring an object of Connection interface
     */
    private Connection connection;
    /**
     * Declaring an object of Statement interface
     */
    private Statement statement;

    /**
     * getter for connection object
     * @return
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * getter for statement object
     * @return
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * Database initialization constructor
     */
    public Database(){
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("error! "+ex.getMessage());
        }
    }
}
