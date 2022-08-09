import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Menu extends JFrame {
    public Menu() {
        JButton addEntry = new JButton("Add Entry");
        JPanel menu = new JPanel();
        
        /*
         * Button functionalities
         */
        addEntry.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new NewEntry();
               setVisible(false);
           }
        });
        
        
        //Panel Layout
        menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
        menu.add(addEntry);
        
        //Frame Information
        add(menu);
        setTitle("Main Menu");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
