import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.*;

public class NewEntry extends JFrame{
    
    JFrame frame;
    
    public NewEntry() {
        frame = new JFrame();
        JButton back = new JButton("Cancel");
        back.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               Menu menu = new Menu();
               frame.dispose();
           }
        });
        
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
}
