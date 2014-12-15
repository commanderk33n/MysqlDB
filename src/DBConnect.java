
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
    private Connection con;


    private String host = "localhost";
    private String port = "3306";
    private String db = "mysql";
    private String user = "root";
    private String pw = "foobar123";

    public DBConnect() {

        // Auf Treiber überprüfen
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

        } catch (Exception ex) {
            System.out.println(ex);
        }

        // DB Verbindung herstellen
        try {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + db + "?user=" + user + "&password=" + pw;
            con = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public boolean update(String query) {
        // Update, Insert, Delete
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public ResultSet select(String query) {
        // Select
        try {
            Statement stmt = con.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }

    public void close() {
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
}