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

public class Update {
    String[] tables = {"Customer", "Dog", "Employee", "Manager", "Route"};
    private static JFrame frame;
    private static String selection;
    
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
        JButton add = new JButton("Add");
        add.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                selection = (String) choice.getSelectedItem();
                //entryForm(selection);
            }
        });
        
        //enter = new JButton("Enter");
        
        
        /*
         * Creating JFrame
         */
        frame.add(choice);
        frame.add(add);
        frame.add(back);
        frame.setTitle("Update an Entry");
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(700, 700);
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
}
