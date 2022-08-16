package dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfaceDao {
    Connection getConnection() throws SQLException;
}
