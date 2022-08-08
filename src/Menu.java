import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.event.*;

public class Menu extends JFrame {
    public Menu() {
        JButton addEntry = new JButton("Add Entry");
        addEntry.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               new NewEntry();
               setVisible(false);
           }
        });
        JLabel label = new JLabel("Main Menu");
        
        add(label);
        add(addEntry);
        setTitle("Main Menu");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
