package com.Worker.Zefa.util;

import java.sql.DriverManager;
import java.sql.Connection;

public class ConnManager {
    public Connection con;
    public Connection Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/" +
                    "worker?useJDBCCompliantTimezoneShift=true&serverTimezone=UTC",
                    "root", "root");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}

