package com.jamesmhare.viewthequeue.utils;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Serves as a utilities class to help with the saving of the database state at time of testing.
 */
public class TestUtilities {

    public TestUtilities() {}

    /**
     * Creates the database.
     */
    public void createDatabase() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Database/CreateDatabase.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Drops the database.
     */
    public void dropDatabase() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        try {
            PreparedStatement stmt = conn.getPreparedStatement("src/test/resources/SQLScripts/Utils/Database/DropDatabase.sql");
            stmt.execute();
        } catch (IOException | SQLException exception) {
            exception.printStackTrace();
        } finally {
            conn.closeConnection();
        }
    }

    /**
     * Checks to see if the database already exists.
     * @return true if the database exists, false if it does not.
     */
    public boolean databaseExists() {
        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        boolean databaseExists = false;
        try {
            databaseExists = conn.databaseExists();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        } finally {
            conn.closeConnection();
        }
        return databaseExists;
    }
}
