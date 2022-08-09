import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class NewEntry extends JFrame{
    
    ArrayList<String> customers = Main.getCustomers();
    ArrayList<Integer> dogID = Main.getDogID();
    ArrayList<Integer> empID = Main.getEmployeeID();
    String[] tables = {"Customer", "Dog", "Employee", "Route"};
    private static JFrame frame;
    private static String selection;
    JButton enter;
    JPanel form;
    
    public NewEntry() {
        frame = new JFrame();
        
        //choices for adding an entry
        JComboBox choice = new JComboBox(tables);
        
        //cancel button
        JButton back = new JButton("Cancel");
        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Menu menu = new Menu();
               frame.dispose();
           }
        });
        //add entry button
        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                selection = (String) choice.getSelectedItem();
                entryForm(selection);
            }
        });
        
        enter = new JButton("Enter");
        
        
        /*
         * Creating JFrame
         */
        frame.add(choice);
        frame.add(add);
        frame.add(back);
        frame.setTitle("Add an Entry");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                Menu menu = new Menu();
            }
        });
        
    }
    
    /*
     * Creates entry form based on user choice
     */
    private void entryForm(String choice) {
        if(choice.equals("Customer")) {
            addCustomer();
        }
        else if(choice.equals("Dog")) {
            addDog();
        }
        else if(choice.equals("Employee")) {
            addEmployee();
        }
        else {
            addRoute();
        }
    }
    
    /*
     * Method that adds a customer to the database
     */
    private void addCustomer() 
    {
        form = new JPanel();
        JTextField Email = new JTextField("Email");
        JTextField First = new JTextField("First Name");
        JTextField Middle = new JTextField("Middle Initial");
        JTextField Last = new JTextField("Last Name");
        JTextField CCNumber = new JTextField("Credit Card");
        JTextField Address = new JTextField("Address");
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = Email.getText();
                String first = First.getText();
                char middle = Middle.getText().charAt(0);
                String last = Last.getText();
                String ccNumber = CCNumber.getText();
                String address = Address.getText();
                Main.newCustomer(email, first, middle, last, ccNumber, address);
                frame.dispose();
                success();
            }
        });
        form.add(Email);
        form.add(First);
        form.add(Middle);
        form.add(Last);
        form.add(CCNumber);
        form.add(Address);
        form.add(enter);
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        frame.add(form);
        frame.setVisible(true);
        
    }
    
    /*
     * Method that adds a dog to the database
     */
    private void addDog() {
        form = new JPanel();
        JComboBox Owner = new JComboBox(customers.toArray());
        JTextField Breed = new JTextField("Breed");
        JTextField Name = new JTextField("Name");
        JTextField Age = new JTextField("Age");
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String owner = (String) Owner.getSelectedItem();
                String breed = Breed.getText();
                String name = Name.getText();
                int age = Integer.parseInt(Age.getText());
                Main.newDog(owner, null, breed, name, age);
                frame.dispose();
                success();
            }
        });
        form.add(Owner);
        form.add(Breed);
        form.add(Name);
        form.add(Age);
        form.add(enter);
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        frame.add(form);
        frame.setVisible(true);
    }
    
    /*
     * Method that adds an employee to the database
     */
    private void addEmployee() {
        form = new JPanel();
        String[] yNo = {"Yes", "No"};
        JTextField First = new JTextField("First Name");
        JTextField Last = new JTextField("Last Name");
        JTextField Age = new JTextField("Age");
        JTextField Address = new JTextField("Address");
        JLabel employeeType = new JLabel("Manager?");
        JComboBox manager = new JComboBox(yNo);
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String type = (String) manager.getSelectedItem();
                String first = First.getText();
                String last = Last.getText();
                int age = Integer.parseInt(Age.getText());
                String address = Address.getText();
                Main.newEmployee(null, first, last, age, address);
                if(type.equals("Yes")) {
                    Main.newManager(null, first, last);
                }
                frame.dispose();
                success();
                
            }
        });
        form.add(First);
        form.add(Last);
        form.add(Age);
        form.add(Address);
        form.add(employeeType);
        form.add(manager);
        form.add(enter);
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        frame.add(form);
        frame.setVisible(true);
    }
    
    
    /*
     * Method that adds a route to the database
     */
    private void addRoute() {
        form = new JPanel();
        JLabel dogid = new JLabel("Dog ID:");
        JLabel empid = new JLabel("Employee ID:");
        JComboBox Dog = new JComboBox(dogID.toArray());
        JComboBox Emp = new JComboBox(empID.toArray());
        JTextField Start = new JTextField("Start");
        JTextField End = new JTextField("End");
        JTextField Cost = new JTextField("Cost");
        enter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dog = (int) Dog.getSelectedItem();
                int emp = (int) Emp.getSelectedItem();
                String start = Start.getSelectedText();
                String end = End.getSelectedText();
                int cost = Integer.parseInt(Cost.getText());
                Main.newRoute(dog, null, emp, start, end, cost);
                frame.dispose();
                success();
            }
        });
        form.add(dogid);
        form.add(Dog);
        form.add(empid);
        form.add(Emp);
        form.add(Start);
        form.add(End);
        form.add(Cost);
        form.add(enter);
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        frame.add(form);
        frame.setVisible(true);
    }
    
    /*
     * Method that makes a popup that the addition was successful
     */
    private static void success() {
        JFrame added = new JFrame();
        added.setTitle("Successful");
        JLabel successfullyAdded = new JLabel("Successfully Added!");
        added.add(successfullyAdded);
        added.setSize(200,200);
        added.setVisible(true);
        added.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                Menu menu = new Menu();
            }
        });
        
    }
}
