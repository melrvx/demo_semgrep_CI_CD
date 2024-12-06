package demo_semgrep_CI_CD.code_demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Vulnerable {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter your username: ");
            String username = scanner.nextLine();

            System.out.println("Enter your password: ");
            String password = scanner.nextLine();

            // Connection details
            String jdbcURL = "jdbc:oracle:thin:@localhost:1522:xe";
            String dbUser ="SYSTEM";
            String dbPassword = "admin";

            try {
                Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
                Statement statement = connection.createStatement();

                // Vulnerable query (SQL Injection possible)
                String sql = "SELECT * FROM users WHERE username = '" + username + "' AND password = '" + password + "'";
                System.out.println(sql);
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    System.out.println("Login successful!");
                } else {
                    System.out.println("Invalid username or password.");
                }

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // SELECT * FROM users WHERE username = 'admin' -- ' AND password = ''
    }
}

