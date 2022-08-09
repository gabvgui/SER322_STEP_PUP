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

public class Update {
    String[] tables = {"Customer", "Dog", "Employee", "Manager", "Route"};
    //private String[] columns;
    private static JFrame frame;
    private static String selection;
    public static JTable scrollPane = new JTable();
    
    public Update() {
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
        JButton update = new JButton("Update");
        update.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                selection = (String) choice.getSelectedItem();
                showTable(selection);
            }
        });
        
        scrollPane.setBounds(10, 64, 366, 107);
        scrollPane.setSize(500,300);
        
        /*
         * Creating JFrame
         */
        frame.add(choice);
        frame.add(update);
        frame.add(back);
        frame.setTitle("Update an Entry");
        frame.setLayout(new FlowLayout());
        frame.add(scrollPane);
        frame.setVisible(true);
        frame.setSize(600, 500);
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
    
    private static void showTable(String choice) {
        if(choice.equals("Customer")) {
            Main.showCustomers();
        }
    }
}
