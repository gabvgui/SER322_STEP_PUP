import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        //url = "jdbc:mysql://localhost:3306/Group9";
        //username = "root";
        Scanner scan;
        
        try
        {
            scan = new Scanner(System.in);
            System.out.println("Enter URL:");
            String url = scan.nextLine();
            System.out.println("Enter Username:");
            String user = scan.nextLine();
            System.out.println("Enter Password:");
            String pass = scan.nextLine();
            Connection connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");
            scan.close();
        }
        catch (SQLException e)
        {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }
    }
    
         
}
