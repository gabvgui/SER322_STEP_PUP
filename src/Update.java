import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.util.ArrayList;

public class Update {
    String[] tables = {"Customer", "Dog", "Employee", "Manager", "Route"};
    private static ArrayList<String> customers = Main.getCustomers();
    private static ArrayList<Integer> dogID = Main.getDogID();
    private static ArrayList<Integer> empID = Main.getEmployeeID();
    //private String[] columns;
    public static JFrame frame;
    private static JFrame updateFrame;
    private static String selection;
    private static JPanel form;
    private static JPanel updateForm;
    private static JButton update;
    private static JButton submit;
    public static JTable scrollPane = new JTable();
    private static Main main = new Main();
    
    public Update() {
        frame = new JFrame();
        form = new JPanel();
        
        //choices for adding an entry
        JComboBox choice = new JComboBox(tables);
        
        
        //cancel button
        JButton back = new JButton("Cancel");
        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Menu menu = new Menu();
               scrollPane.setVisible(false);
               frame.dispose();
           }
        });
        //select table button
        JButton select = new JButton("Select");
        select.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                selection = (String) choice.getSelectedItem();
                showTable(selection);
                scrollPane.setVisible(true);
            }
        });
        
        //update button
        update = new JButton("Update");
        submit = new JButton("Submit");
        
        //scrollPane.setBounds(10, 64, 366, 107);
        scrollPane.setSize(550,300);
        
        /*
         * Creating JFrame
         */
        form.add(choice);
        form.add(select);
        form.add(back);
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        frame.setTitle("Update an Entry");
        frame.setLayout(new FlowLayout());
        frame.add(form);
        frame.add(scrollPane);
       
        frame.setVisible(true);
        frame.setSize(600, 500);
        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                scrollPane.setVisible(false);
                Menu menu = new Menu();
            }
        });
        
    }
    
    private static void showTable(String choice) {
        if(choice.equals("Customer")) {
            main.showCustomers();
            form.add(update);
            frame.add(form);
            frame.setVisible(true);
            update.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    scrollPane.setVisible(true);
                    frame.setVisible(false);
                    updateCustomer();
                }
            });
        }
        else if(choice.equals("Dog")) {
            main.showDogs();
            form.add(update);
            frame.add(form);
            update.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    scrollPane.setVisible(true);
                    frame.setVisible(false);
                    updateDog();
                }
            });
        }
        else if(choice.equals("Employee")) {
            main.showEmployees();
            form.add(update);
            frame.add(form);
            update.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    scrollPane.setVisible(true);
                    frame.setVisible(false);
                    updateEmployee();
                }
            });
        }
        else if(choice.equals("Manager")) {
            main.showManagers();
            form.add(update);
            frame.add(form);
            update.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    scrollPane.setVisible(true);
                    frame.setVisible(false);
                    updateManager();
                }
            });
        }
        else {
            main.showRoutes();
            form.add(update);
            frame.add(form);
            update.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    scrollPane.setVisible(true);
                    frame.setVisible(false);
                    updateRoute();
                }
            });
        }
    }
    
    private static void updateCustomer() {
        updateForm = new JPanel();
        updateFrame = new JFrame();
        updateFrame.setSize(400,400);
        updateFrame.setTitle("Update Customer");
        int i = scrollPane.getSelectedRow();
        JLabel Email = new JLabel((String) scrollPane.getValueAt(i, 0));
        JTextField First = new JTextField((String) scrollPane.getValueAt(i, 1));
        JTextField Middle = new JTextField((String) scrollPane.getValueAt(i, 2));
        JTextField Last = new JTextField((String) scrollPane.getValueAt(i, 3));
        JTextField CCNumber = new JTextField((String) scrollPane.getValueAt(i, 4));
        JTextField Address = new JTextField((String) scrollPane.getValueAt(i, 5));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = Email.getText();
                String first = First.getText();
                char middle = Middle.getText().charAt(0);
                String last = Last.getText();
                String ccNumber = CCNumber.getText();
                String address = Address.getText();
                updateFrame.dispose();
                Main.updateCustomer(email, first, middle, last, ccNumber, address);
                frame.setVisible(true);
            }
        });
        updateFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                new Update();
            }
        });
        updateForm.add(Email);
        updateForm.add(First);
        updateForm.add(Middle);
        updateForm.add(Last);
        updateForm.add(CCNumber);
        updateForm.add(Address);
        updateForm.add(submit);
        updateFrame.add(updateForm);
        updateFrame.setVisible(true);
    }
    
    private static void updateDog() {
        updateForm = new JPanel();
        updateFrame = new JFrame();
        updateFrame.setSize(400,400);
        updateFrame.setTitle("Update Dog");
        int i = scrollPane.getSelectedRow();
        JLabel Owner = new JLabel((String) scrollPane.getValueAt(i, 0));
        JLabel ID = new JLabel((String) scrollPane.getValueAt(i, 1));
        JTextField Breed = new JTextField((String) scrollPane.getValueAt(i, 2));
        JTextField Name = new JTextField((String) scrollPane.getValueAt(i, 3));
        JTextField Age = new JTextField((String) scrollPane.getValueAt(i, 4));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String owner = Owner.getText();
                int id = Integer.parseInt(ID.getText());
                String breed = Breed.getText();
                String name = Name.getText();
                int age = Integer.parseInt(Age.getText());
                main.updateDog(owner, id, breed, name, age);
                updateFrame.dispose();
                frame.setVisible(true);
            }
        });
        updateFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                new Update();
            }
        });
        updateForm.add(Owner);
        updateForm.add(ID);
        updateForm.add(Breed);
        updateForm.add(Name);
        updateForm.add(Age);
        updateForm.add(submit);
        updateForm.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        updateFrame.add(updateForm);
        updateFrame.setVisible(true);
    }
    
    private static void updateEmployee() {
        updateForm = new JPanel();
        updateFrame = new JFrame();
        updateFrame.setSize(400,400);
        updateFrame.setTitle("Update Employee");
        int i = scrollPane.getSelectedRow();
        JLabel ID = new JLabel((String) scrollPane.getValueAt(i, 0));
        JTextField First = new JTextField((String) scrollPane.getValueAt(i, 1));
        JTextField Last = new JTextField((String) scrollPane.getValueAt(i, 2));
        JTextField Age = new JTextField((String) scrollPane.getValueAt(i, 3));
        JTextField Address = new JTextField((String) scrollPane.getValueAt(i, 4));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(ID.getText());
                String first = First.getText();
                String last = Last.getText();
                int age = Integer.parseInt(Age.getText());
                String address = Address.getText();
                main.updateEmployee(id, first, last, age, address);
                updateFrame.dispose();
                frame.setVisible(true);
            }
        });
        updateFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                new Update();
            }
        });
        updateForm.add(ID);
        updateForm.add(First);
        updateForm.add(Last);
        updateForm.add(Age);
        updateForm.add(Address);
        updateForm.add(submit);
        updateForm.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        updateFrame.add(form);
        updateFrame.setVisible(true);
    }
    
    private static void updateManager() {
        updateForm = new JPanel();
        updateFrame = new JFrame();
        updateFrame.setSize(400,400);
        updateFrame.setTitle("Update Manager");
        int i = scrollPane.getSelectedRow();
        JLabel ID = new JLabel((String) scrollPane.getValueAt(i, 0));
        JTextField First = new JTextField((String) scrollPane.getValueAt(i, 1));
        JTextField Last = new JTextField((String) scrollPane.getValueAt(i, 2));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(ID.getText());
                String first = First.getText();
                String last = Last.getText();
                main.updateManager(id, first, last);
                updateFrame.dispose();
                frame.setVisible(true);
            }
        });
        updateFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                new Update();
            }
        });
        updateForm.add(ID);
        updateForm.add(First);
        updateForm.add(Last);
        updateForm.add(submit);
        updateForm.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        updateFrame.add(form);
        updateFrame.setVisible(true);
    }
    
    private static void updateRoute() {
        updateForm = new JPanel();
        updateFrame = new JFrame();
        updateFrame.setSize(400,400);
        updateFrame.setTitle("Update Route");
        int i = scrollPane.getSelectedRow();
        JLabel Dog = new JLabel((String) scrollPane.getValueAt(i, 0));
        JLabel Emp = new JLabel((String) scrollPane.getValueAt(i, 1));
        JLabel ID = new JLabel((String) scrollPane.getValueAt(i, 2));
        JTextField Start = new JTextField((String) scrollPane.getValueAt(i, 3));
        JTextField End = new JTextField((String) scrollPane.getValueAt(i, 4));
        JTextField Cost = new JTextField((String) scrollPane.getValueAt(i, 5));
        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dog = Integer.parseInt(Dog.getText());
                int id = Integer.parseInt(ID.getText());
                int emp = Integer.parseInt(Emp.getText());
                String start = Start.getText();
                String end = End.getText();
                int cost = Integer.parseInt(Cost.getText());
                Main.updateRoute(dog, id, emp, start, end, cost);
                updateFrame.dispose();
                frame.setVisible(true);
            }
        });
        updateFrame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                e.getWindow().dispose();
                new Update();
            }
        });
        updateForm.add(Dog);
        updateForm.add(Emp);
        updateForm.add(ID);
        updateForm.add(Start);
        updateForm.add(End);
        updateForm.add(Cost);
        updateForm.add(submit);
        updateForm.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        updateFrame.add(form);
        updateFrame.setVisible(true);
    }
     
}
