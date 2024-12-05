package demo_semgrep_CI_CD.code_demo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scanner.nextLine();

        System.out.println("Enter your password: ");
        String password = scanner.nextLine();

        scanner.close();

        // Connection details
        String jdbcURL = "jdbc:oracle:thin:@localhost:1522:xe";
        String dbUser ="SYSTEM";
        String dbPassword = "admin";

        try {
            // Connexion à la base de données
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        
            // Requête avec des paramètres
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
            // Remplacement des paramètres
            preparedStatement.setString(1, username); // Premier ?
            preparedStatement.setString(2, password); // Deuxième ?
        
            // Exécution de la requête
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(sql);
        
            // Vérification des résultats
            if (resultSet.next()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Invalid username or password.");
            }
        
            // Fermeture des ressources
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}

