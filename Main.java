import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection conn = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webshop", "root", "password");

            Kunder kunder = new Kunder(conn);
            Produkter produkter = new Produkter(conn);
            Ordrar ordrar = new Ordrar(conn);

            System.out.println("Välj alternativ:");
            System.out.println("1: Lägg till kund");
            System.out.println("2: Uppdatera kundens email");
            System.out.println("3: Visa produkter");
            System.out.println("4: Lägg till order");

            int val = scanner.nextInt();
            scanner.nextLine();

            if (val == 1) {
                kunder.laggTillKund(scanner);
            } else if (val == 2) {
                kunder.uppdateraEmail(scanner);
            } else if (val == 3) {
                produkter.visaProdukter();
            } else if (val == 4) {
                ordrar.laggTillOrder(scanner);
            } else {
                System.out.println("Felaktigt val.");
            }

        } catch (SQLException e) {
            System.out.println("Databasfel: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Fel vid stängning: " + e.getMessage());
            }
        }
    }
}