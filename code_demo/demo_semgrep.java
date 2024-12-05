package demo_semgrep_CI_CD.code_demo;
import java.sql.Connection;
import java.sql.DriverManager;

public class demo_semgrep {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1522:xe";
        String user ="SYSTEM";
        String password = "admin";
        
        try {
            System.out.println("Connecting to DAtabase");
            Class.forName("oracle.jdbc.driver.OracleDriver");  /*added this line*/
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println( connection.toString());
            System.out.println("Connection Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
