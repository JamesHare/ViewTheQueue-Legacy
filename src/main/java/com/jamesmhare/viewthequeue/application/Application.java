package com.jamesmhare.viewthequeue.application;

import com.jamesmhare.viewthequeue.model.connection.proxies.mysql.MySQLConnectionProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jamesmhare.viewthequeue.controller"})
public class Application {

    public static void main(String[] args) {

        MySQLConnectionProxy conn = new MySQLConnectionProxy();
        if(!conn.databaseExists()) {
            conn.runDatabaseScript("src/main/resources/SQLScripts/Setup/ViewTheQueueDBInit.sql");
        }
        conn.closeConnection();

        SpringApplication.run(Application.class, args);
    }
}