package com.placement;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/placement_management",
                    "root",
                    "admin@123"
            );

            System.out.println("Database connected successfully!");

        } catch (Exception e) {

            System.out.println("Database connection error:");
            System.out.println(e.getMessage());

        }
        return connection;
    }
}