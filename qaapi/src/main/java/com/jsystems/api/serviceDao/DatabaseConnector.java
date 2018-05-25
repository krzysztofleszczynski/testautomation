package com.jsystems.api.serviceDao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            initConnection();
        }
        return connection;
    }
//poniżej to jest metoda
    // dla bezpieczeństwa warto przymać te dane w pliku konfiguracyjnym w configu
    private static void initConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String user = "testUser";
            String pass = "testuser";
            connection = DriverManager.getConnection(url, user, pass);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
