import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Query {

    public static JFrame frame;
    private static Connection connection;
    private static PreparedStatement stm;
    private static ResultSet rs;
    public static JTable scrollPane = new JTable();

    public Query() throws SQLException {
        connection = DriverManager.getConnection(Main.getUrl(), Main.getUser(), Main.getPass());
        frame = new JFrame();
        JPanel panel = new JPanel();
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);
        JLabel label = new JLabel("Enter Query:");
        label.setBounds(10,20,80,25);
        panel.add(label);
        JTextArea queryText = new JTextArea();
        queryText.setBounds(100,100, 200,200);
        panel.add(queryText);
        JButton button = new JButton("Submit");
        JButton back = new JButton("Cancel");
        button.setBounds(10,80,80,25);
        back.setBounds(10,110,80,25);
        panel.add(button);
        panel.add(back);

        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    String string = queryText.getText();
                    stm = connection.prepareStatement(string);
                    rs = stm.executeQuery(string);
                    ResultSetMetaData rsmd = rs.getMetaData();

                    int columnsNumber = rsmd.getColumnCount();
                    while (rs.next()) {
                        for (int i = 1; i <= columnsNumber; i++) {
                            if (i > 1) System.out.print(",  ");
                            String columnValue = rs.getString(i);
                            System.out.print(columnValue + " " + rsmd.getColumnName(i));
                        }
                        System.out.println("");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //cancel button
        back.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Menu menu = new Menu();
                scrollPane.setVisible(false);
                frame.dispose();
            }
        });

    }
}
