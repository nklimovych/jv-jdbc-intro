package mate.academy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import mate.academy.exception.DataProcessingException;

public class ConnectionUtil {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/books";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "password";
    private static final Properties DB_PROPERTIES;

    static {
        DB_PROPERTIES = new Properties();
        DB_PROPERTIES.put(USERNAME, "root");
        DB_PROPERTIES.put(PASSWORD, "password");

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can't load JDBC driver", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_PROPERTIES);
        } catch (SQLException e) {
            throw new DataProcessingException("Can't connect to database", e);
        }
    }
}
