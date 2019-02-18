package com.jamesmhare.viewthequeue.Application;

import com.jamesmhare.viewthequeue.model.connection.mysql.ConnectionProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.jamesmhare.viewthequeue.controller"})
public class Application {

    public static void main(String[] args) {

        ConnectionProxy connectionProxy = new ConnectionProxy();
        if(!connectionProxy.databaseExists()) {
            connectionProxy.initializeDatabase();
        }
        connectionProxy.closeConnection();

        SpringApplication.run(Application.class, args);
    }
}