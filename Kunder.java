import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Kunder {
    private Connection conn;

    public Kunder(Connection conn) {
        this.conn = conn;
    }

    public void laggTillKund(Scanner scanner) throws SQLException {
        System.out.print("Namn: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        String sql = "INSERT INTO customers (name, email) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.executeUpdate();
        System.out.println("Kund tillagd!");
    }

    public void uppdateraEmail(Scanner scanner) throws SQLException {
        System.out.print("Kund ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Ny email: ");
        String email = scanner.nextLine();

        String sql = "UPDATE customers SET email = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email);
        stmt.setInt(2, id);
        stmt.executeUpdate();
        System.out.println("Email uppdaterad!");
    }
}