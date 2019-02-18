package com.jamesmhare.viewthequeue.model.connection.mysql;

import com.ibatis.common.jdbc.ScriptRunner;
import com.jamesmhare.viewthequeue.properties.ApplicationProperties;
import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Serves as a class to manage a connection to a MySQL instance.
 */
public class ConnectionProxy {

    private ApplicationProperties properties;
    private Connection connection;

    private String connectionURL;
    private String user;
    private String password;
    private String databaseName;

    public ConnectionProxy() {
        initializeProperties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, user, password);
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Initializes the View The Queue schema and inserts initial values.
     */
    public void initializeDatabase() {
        try {
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, true);
            scriptRunner.runScript(new BufferedReader(new FileReader("src/main/resources/setup/SQLScripts/ViewTheQueueDBInit.sql")));
        } catch (SQLException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Closes the connection to the database.
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * Determines if the View the Queue database has been initialized.
     * @return true if it has, false if it has not.
     */
    public boolean databaseExists() {
        boolean databaseExists = false;
        try {
            ResultSet rs = connection.getMetaData().getCatalogs();
            while(rs.next()) {
                if(databaseName.equals(rs.getString(1))) {
                    databaseExists = true;
                }
            }
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
        return databaseExists;
    }

    private void initializeProperties() {
        properties = new ApplicationProperties();
        connectionURL = properties.getProperty("ConnectionURL");
        user = properties.getProperty("DBUser");
        password = properties.getProperty("DBPassword");
        databaseName = properties.getProperty("DBName");
    }

    private String getSetupQuery() {
        StringBuilder query = new StringBuilder();
        try{
            query.append(IOUtils.toString(new FileInputStream("src/main/resources/setup/SQLScripts/ViewTheQueueDBInit.sql")));
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return query.toString();
    }
}
