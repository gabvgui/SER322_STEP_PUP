import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;

import net.proteanit.sql.DbUtils;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {

    private static Connection connection;
    private static PreparedStatement ps;
    private static ResultSet rs;
    private static ResultSetMetaData rsmd;
    private static DefaultTableModel dm;
    
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
    
    public static void newDog(String own, String id, String breed, String name, int age) {
        try {
            ps = connection.prepareStatement("insert into DOG ( OWNER_EMAIL, ID, BREED, DOG_NAME, AGE "
                    + ")values(?,?,?,?,?)");
            ps.setString(1, own);
            ps.setString(2, id);
            ps.setString(3, breed);
            ps.setString(4, name);
            ps.setInt(5, age);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
        }
        
    }
    
    public static void newEmployee(String id, String first, String last, int age, String address) {
        try {
            ps = connection.prepareStatement("insert into EMPLOYEE ( EMPLOYEE_ID, FIRST_NAME, LAST_NAME, AGE, ADDRESS "
                    + ")values(?,?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.setInt(4, age);
            ps.setString(5, address);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    public static void newManager(String id, String first, String last) {
        try {
            ps = connection.prepareStatement("insert into MANAGER ( EMPLOYEE_ID, FIRST_NAME, LAST_NAME )values(?,?,?)");
            ps.setString(1, id);
            ps.setString(2, first);
            ps.setString(3, last);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    public static void newRoute(int dog, String id, int emp, String start, String end, int cost) {
        try {
            ps = connection.prepareStatement("insert into ROUTE ( DOG_ID, ROUTE_ID, EMPLOYEE_ID,"
                    + "START_POINT, END_POINT, COST )values(?,?,?,?,?,?)");
            ps.setInt(1, dog);
            ps.setString(2, id);
            ps.setInt(3, emp);
            ps.setString(4, start);
            ps.setString(5, end);
            ps.setInt(6, cost);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    /*
     * Gets customer emails
     */
    public static ArrayList<String> getCustomers() {
        try {
           ps = connection.prepareStatement("SELECT EMAIL FROM CUSTOMER"); 
           rs = ps.executeQuery();
           ArrayList<String> arr = new ArrayList<String>();
           while(rs.next()) {
               arr.add(rs.getString("EMAIL"));
           }
           return arr;
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace(); 
            return null;
        }
    }
    
    /*
     * Gets Dog IDs
     */
    public static ArrayList<Integer> getDogID() {
        try {
            ps = connection.prepareStatement("SELECT ID FROM DOG");
            rs = ps.executeQuery();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(rs.next()) {
                arr.add(rs.getInt("ID"));
            }
            return arr;
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
            return null;
        }
    }
    
    /*
     * Gets Employee IDs
     */
    public static ArrayList<Integer> getEmployeeID() {
        try {
            ps = connection.prepareStatement("SELECT EMPLOYEE_ID FROM EMPLOYEE");
            rs = ps.executeQuery();
            ArrayList<Integer> arr = new ArrayList<Integer>();
            while(rs.next()) {
                arr.add(rs.getInt("EMPLOYEE_ID"));
            }
            return arr;
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
            return null;
        }
    }
    
    /*
     * Displays Customer table
     */
    public static void showCustomers() {
        try{
            ps = connection.prepareStatement("SELECT * FROM CUSTOMER");
            rs = ps.executeQuery();
            Update.scrollPane.setModel(DbUtils.resultSetToTableModel(rs));
        }
      
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
         
}
