package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe per gestionar la connexió a la base de dades PostgreSQL.
 */
public class DatabaseConnection {
    private static final String URL = "jdbc:postgresql://localhost:5432/chinook_v2";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    /**
     * Retorna una connexió JDBC a la base de dades.
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
