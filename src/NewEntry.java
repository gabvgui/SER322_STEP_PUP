import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.*;

public class NewEntry extends JFrame{
    
    public NewEntry() {
        JButton back = new JButton("Cancel");
        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Menu menu = new Menu();
               System.exit(0);
           }
        });
        
        add(back);
        setTitle("Add an Entry");
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400,400);
        addWindowListener(new WindowAdapter()
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
