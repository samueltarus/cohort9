package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbcon {

    String Url = "jdbc:mysql://localhost:3306/java_db_test";
    String User = "root";
    String Password = "";
    Connection connection =null;
    {
        try {
            connection = DriverManager.getConnection(Url,User,Password);

            System.out.println("Connection Established");

        } catch (SQLException throwables) {
            System.out.println("System Failed to connect");
            throwables.printStackTrace();
        }
    }


}
