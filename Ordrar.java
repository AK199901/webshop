import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Ordrar {
    private Connection conn;

    public Ordrar(Connection conn) {
        this.conn = conn;
    }

    public void laggTillOrder(Scanner scanner) throws SQLException {
        System.out.print("Kund ID: ");
        int kundId = scanner.nextInt();
        System.out.print("Produkt ID: ");
        int produktId = scanner.nextInt();
        System.out.print("Antal: ");
        int antal = scanner.nextInt();

        String sql = "INSERT INTO orders (customer_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, kundId);
        stmt.setInt(2, produktId);
        stmt.setInt(3, antal);
        stmt.executeUpdate();
        System.out.println("Order tillagd!");
    }
}
