import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.*;

public class NewEntry extends JFrame{
    String[] tables = {"Customer", "Dog", "Employee", "Manager", "Route"};
    private static JFrame frame;
    private static String selection;
    JTextField Email;
    JTextField First;
    JTextField Middle;
    JTextField Last;
    JTextField CCNumber;
    JTextField Address;
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
        else if(choice.equals("Manager")) {
            addManager();
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
        Email = new JTextField("Email");
        First = new JTextField("First Name");
        Middle = new JTextField("Middle Initial");
        Last = new JTextField("Last Name");
        CCNumber = new JTextField("Credit Card");
        Address = new JTextField("Address");
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
        
    }
    
    /*
     * Method that adds an employee to the database
     */
    private void addEmployee() {
        
    }
    
    /*
     * Method that adds a manager to the database
     */
    private void addManager() {
        
    }
    
    
    /*
     * Method that adds a route to the database
     */
    private void addRoute() {
        
    }
    
    /*
     * Method that makes a popup that the addition was successful
     */
    private static void success() {
        JFrame added = new JFrame();
        added.setTitle("Successful");
        JLabel successfullyAdded = new JLabel("Successfully Added New" + selection +"!");
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
