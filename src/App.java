import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/chinook_v2";   
        String user = "postgres";
        String password = "1234";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM artist";
            ResultSet ResultSet = statement.executeQuery(sql);

            while (ResultSet.next()) {
                int id = ResultSet.getInt("artist_id");
                String name = ResultSet.getString("name");
                System.out.println("ID: " + id + ", Nom: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

