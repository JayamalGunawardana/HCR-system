package net.flood.ocrnn.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.flood.ocrnn.util.DBConnect;
import net.flood.ocrnn.util.errorLog;

public class Register {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    JFrame f = new JFrame("System Register");
    JLabel un = new JLabel("Username:");
    JLabel pw = new JLabel("Password:");
    JTextField username = new JTextField(10);
    JTextField password = new JTextField(10);
    JButton b = new JButton("Register");

    public Register() throws Exception {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccess", "root", "");
            st = con.createStatement();
            frame();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            System.out.println("this sux");
            errorLog db_log = new errorLog("errorLog.txt");

            db_log.logger.setLevel(Level.WARNING);

            db_log.logger.info("Error");
            db_log.logger.warning("Error:" + ex);

        }

    }

    public void frame() throws Exception {

        f.setSize(500, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.add(un);
        p.add(username);

        p.add(pw);
        p.add(password);
        p.add(b);

        f.add(p);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String userName = username.getText().trim();
                    String passWord = password.getText().trim();

                    String query = "insert into Table2(user, pass) values ('" + userName + "','" + passWord + "')";

                    st.executeUpdate(query);

                    JOptionPane.showMessageDialog(null, "Information added. Continue.");

                    f.dispose();

                } catch (Exception ex) {

                    System.out.println("Error: " + ex);
                    System.out.println("Error");
                }
            }

        });

    }
}
