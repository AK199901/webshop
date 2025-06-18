import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Produkter {
    private Connection conn;

    public Produkter(Connection conn) {
        this.conn = conn;
    }

    public void visaProdukter() throws SQLException {
        String sql = "SELECT * FROM products";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                    ", Namn: " + rs.getString("name") +
                    ", Pris: " + rs.getDouble("price") +
                    ", Lagersaldo: " + rs.getInt("stock_quantity"));
        }
    }
}