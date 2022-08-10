import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

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
    private static String url;
    private static String user;
    private static String pass;
  
    
    public static void main(String[] args) {
        //url = "jdbc:mysql://localhost:3306/Group9";
        //username = "root";
        Scanner scan;
        
        try
        {
            scan = new Scanner(System.in);
            System.out.println("Enter URL:");
            url = scan.nextLine();
            System.out.println("Enter Username:");
            user = scan.nextLine();
            System.out.println("Enter Password:");
            pass = scan.nextLine();
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

    public static String getUrl() {
        return url;
    }

    public static String getPass() {
        return pass;
    }

    public static String getUser() {
        return user;
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
            String[] cust = {"Email", "First Name", "Middle Initial", "Last Name", "Credit Card", "Address"};
            ps = connection.prepareStatement("SELECT * FROM CUSTOMER");
            rs = ps.executeQuery();
            Update.scrollPane.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Displays Dog table
     */
    public static void showDogs() {
        try {
            ps = connection.prepareStatement("SELECT * FROM DOG");
            rs = ps.executeQuery();
            Update.scrollPane.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Displays Employee table
     */
    public static void showEmployees() {
        try {
            ps = connection.prepareStatement("SELECT * FROM EMPLOYEE");
            rs = ps.executeQuery();
            Update.scrollPane.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Displays Manager table
     */
    public static void showManagers() {
        try {
            ps = connection.prepareStatement("SELECT * FROM MANAGER");
            rs = ps.executeQuery();
            Update.scrollPane.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Displays Route table
     */
    public static void showRoutes() {
        try {
            ps = connection.prepareStatement("SELECT * FROM ROUTE");
            rs = ps.executeQuery();
            Update.scrollPane.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*
     * Updates Customer table
     */
    public static void updateCustomer(String email, String first, char middle, String last, String cc, String address) {
        try {
            ps = connection.prepareStatement("update CUSTOMER set FIRST_NAME=?, MIDDLE_INITIAL=?, LAST_NAME=?, "
                    + "CC_NUMBER=?, ADDRESS=? where EMAIL=?");
            ps.setString(1, first);
            ps.setString(2, String.valueOf(middle));
            ps.setString(3, last);
            ps.setString(4, cc);
            ps.setString(5, address);
            ps.setString(6, email);
            ps.executeUpdate();
            success();
            
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
        }
    }
    
    /*
     * Updates Dog table
     */
    public static void updateDog(String owner, int id, String breed, String name, int age) {
        try {
            ps = connection.prepareStatement("update DOG set BREED=?, DOG_NAME=?, AGE=?  where ID=?");
            ps.setString(1, breed);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setInt(4, id);
            ps.executeUpdate();
            success();
            
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong!");
            e.printStackTrace();
        }
    }
    
    /*
     * Updates Employee table
     */
    public static void updateEmployee(int id, String first, String last, int age, String address) {
        try {
            ps = connection.prepareStatement("update EMPLOYEE set FIRST_NAME=?, LAST_NAME=?, AGE=?, ADDRESS=? where EMPLOYEE_ID=?");
            ps.setString(1, first);
            ps.setString(2, last);
            ps.setInt(3, age);
            ps.setString(4, address);
            ps.setInt(5, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    /*
     * Updates Manager table
     */
    public static void updateManager(int id, String first, String last) {
        try {
            ps = connection.prepareStatement("update MANAGER set FIRST_NAME=?, LAST_NAME=? where EMPLOYEE_ID=?");
            ps.setString(1, first);
            ps.setString(2, last);
            ps.setInt(3, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    /*
     * Updates Route table
     */
    public static void updateRoute(int dog, int id, int emp, String start, String end, int cost) {
        try {
            ps = connection.prepareStatement("update ROUTE set START_POINT=?, END_POINT=?, COST=? where ROUTE_ID=?");
            ps.setString(1, start);
            ps.setString(2, end);
            ps.setInt(3, cost);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    public static void deleteCustomer(String email) {
        try {
            ps = connection.prepareStatement("DELETE FROM CUSTOMER where EMAIL=?");
            ps.setString(1, email);
            ps.executeUpdate();
            ps.close();
            successDelete();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    public static void deleteDog(int id) {
        try {
            ps = connection.prepareStatement("DELETE FROM DOG where ID=?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            successDelete();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    public static void deleteEmployee(int emp_id) {
        try {
            ps = connection.prepareStatement("DELETE FROM EMPLOYEE where EMPLOYEE_ID=?");
            ps.setInt(1, emp_id);
            ps.executeUpdate();
            ps.close();
            successDelete();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    public static void deleteManager(int emp_id) {
        try {
            ps = connection.prepareStatement("DELETE FROM MANAGER where EMPLOYEE_ID=?");
            ps.setInt(1, emp_id);
            ps.executeUpdate();
            ps.close();
            successDelete();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    public static void deleteRoute(int route_id) {
        try {
            ps = connection.prepareStatement("DELETE FROM ROUTE where ROUTE_ID=?");
            ps.setInt(1, route_id);
            ps.executeUpdate();
            ps.close();
            successDelete();
        }
        catch(SQLException e) {
            System.out.println("Oops, something went wrong");
            e.printStackTrace();
        }
    }
    
    /*
     * Displays success message
     */
    private static void success() {
        JFrame added = new JFrame();
        added.setTitle("Successful");
        JLabel successfullyAdded = new JLabel("Successfully Updated!");
        added.add(successfullyAdded);
        added.setSize(200,200);
        added.setVisible(true);
        added.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
            }
        });
        
    }
    
    private static void successDelete() {
        JFrame added = new JFrame();
        added.setTitle("Delete Successful");
        JLabel successfullyAdded = new JLabel("Successfully Deleted!");
        added.add(successfullyAdded);
        added.setSize(200,200);
        added.setVisible(true);
        added.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
            }
        });
        
    }
   
    
    
         
}
