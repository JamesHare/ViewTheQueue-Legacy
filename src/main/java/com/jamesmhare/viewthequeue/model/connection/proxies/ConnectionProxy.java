package com.jamesmhare.viewthequeue.model.connection.proxies;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Serves as an interface for a connection proxy.
 */
public interface ConnectionProxy {

    /**
     * Initializes the View The Queue schema and inserts initial values.
     * @param filePath the file path to the database script.
     */
    void runDatabaseScript(String filePath);

    /**
     * Closes the connection to the database.
     */
    void closeConnection();

    /**
     * Returns a new PreparedStatement given a path to a SQL file.
     * @param pathToSQLFile the path to a SQL file.
     * @return a new PreparedStatement.
     * @throws IOException
     * @throws SQLException
     */
    PreparedStatement getPreparedStatement(String pathToSQLFile) throws IOException, SQLException;

    /**
     * Returns the connection.
     * @return the connection.
     */
    Connection getConnection();

    /**
     * Returns a new PreparedStatement appended with an additional String.
     * @param pathToSQLFile the path to a SQL file.
     * @param ammendment an additional String to append the PreparedStatement with.
     * @return a new PreparedStatement.
     * @throws IOException
     * @throws SQLException
     */
    PreparedStatement getPreparedStatement(String pathToSQLFile, String ammendment) throws IOException, SQLException;

    /**
     * Determines if the View the Queue database has been initialized.
     * @return true if it has, false if it has not.
     */
    boolean databaseExists();

}
