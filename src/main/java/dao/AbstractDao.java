package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class AbstractDao implements InterfaceDao{
    private final String URL ="jdbc:mysql://localhost:3306/cars";
    private final String USER = "root";
    private final String PASSWORD = "root";
    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL,USER,PASSWORD);
    }
}
