import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Main {
    
    private static Connection connection;
    private static PreparedStatement ps;
    
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
            connection = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected");
            scan.close();
            Menu obj = new Menu();
        }
        catch (SQLException e)
        {
            System.out.println("Oops, error!");
            e.printStackTrace();
        }
    }
     
    public static void newCustomer(String email, String first, char middle, String last, String cc, String address) {
        System.out.println("working here");
        try { 
            ps = connection.prepareStatement("insert into CUSTOMER ( EMAIL , FIRST_NAME , MIDDLE_INITIAL , "
                + " LAST_NAME , CC_NUMBER , ADDRESS )values(?,?,?,?,?,?)");
            ps.setString(1, email);
            ps.setString(2, first);
            ps.setString(3, String.valueOf(middle));
            ps.setString(4, last);
            ps.setString(5, cc);
            ps.setString(6, address);
            ps.executeUpdate();
            ps.close();
            }
        catch (SQLException e){
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
        }
    }
    
    public static void newDog() {
        
    }
    
    public static void newManager() {
        
    }
    
    public static void newRoute() {
        
    }
         
}
