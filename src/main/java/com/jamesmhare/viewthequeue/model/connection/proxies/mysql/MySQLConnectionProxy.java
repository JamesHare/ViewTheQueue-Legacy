package com.jamesmhare.viewthequeue.model.connection.proxies.mysql;

import com.ibatis.common.jdbc.ScriptRunner;
import com.jamesmhare.viewthequeue.model.connection.proxies.ConnectionProxy;
import com.jamesmhare.viewthequeue.properties.ApplicationProperties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;

/**
 * Serves as a class to manage a connection to a MySQL instance.
 */
public class MySQLConnectionProxy implements ConnectionProxy {

    private ApplicationProperties properties;
    private Connection connection;

    private String connectionURL, user, password, databaseName;

    public MySQLConnectionProxy() {
        initializeProperties();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(connectionURL, user, password);
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void runDatabaseScript(String filePath) {
        try {
            ScriptRunner scriptRunner = new ScriptRunner(connection, false, true);
            scriptRunner.runScript(new BufferedReader(new FileReader(filePath)));
        } catch (SQLException | IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
        }
    }

    /**
     * {@inheritDoc}
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * {@inheritDoc}
     */
    public PreparedStatement getPreparedStatement(String pathToSQLFile) throws IOException, SQLException {
        return connection.prepareStatement(new String(Files.readAllBytes(Paths.get(pathToSQLFile))));
    }

    /**
     * {@inheritDoc}
     */
    public PreparedStatement getPreparedStatement(String pathToSQLFile, String ammendment) throws IOException, SQLException {
        return connection.prepareStatement(new String(Files.readAllBytes(Paths.get(pathToSQLFile))) + " " + ammendment);
    }

    /**
     * {@inheritDoc}
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
}
