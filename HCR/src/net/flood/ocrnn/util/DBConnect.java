package net.flood.ocrnn.util;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import net.flood.ocrnn.ui.MainFrame;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import net.flood.ocrnn.NeuralNetwork;
import net.flood.ocrnn.ui.Register;

public class DBConnect {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    public static MainFrame frame; //Mainframe implementation
    public static ExecutorService queryExecutor;
    public static ExecutorService trainExecutor;
    public static ScheduledExecutorService testExecutor;
    public static NeuralNetwork network;

    JFrame f = new JFrame("Login");
    JLabel un = new JLabel("Username:");
    JLabel pw = new JLabel("Password:");
    JTextField tun = new JTextField(10);
    JTextField tpw = new JTextField(10);
    JButton b = new JButton("Login");
    JLabel regi = new JLabel("New user: ");
    JButton register = new JButton("Register");
    JLabel spacer;

    public DBConnect() throws IOException, Exception {  //(throws IOEXception, Exception can be removed)
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccess", "root", "1111");
            st = con.createStatement();
            frame();
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            errorLog db_log = new errorLog("errorLog.txt");

            db_log.logger.setLevel(Level.WARNING);

            db_log.logger.info("Error");
            db_log.logger.warning("Error:" + ex);

        }
    }

    public void frame() {
        f.setSize(500, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        JPanel p = new JPanel();
        p.add(un);
        p.add(tun);

        p.add(pw);
        p.add(tpw);
        p.add(b);
        p.add(regi);
        p.add(register);

        f.add(p);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    String user = tun.getText().trim();
                    String pass = tpw.getText().trim();

                    String query = "select * from user where user = '" + user + "' and pass = '" + pass + "'";
                    rs = st.executeQuery(query);

                    int count = 0;
                    while (rs.next()) {

                        count = count + 1;
                    }

                    if (count == 1) {

                        JOptionPane.showMessageDialog(null, "Access Granted. Continue.");

                        f.dispose();

                        MainFrame.setSystemLookAndFeel();
                        frame = new MainFrame();
                        frame.addWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                //Dispose active resources
                                network.dispose();
                                queryExecutor.shutdown();
                                trainExecutor.shutdown();
                                testExecutor.shutdown();
                            }
                        });
                        frame.open();

                    } else {
                        JOptionPane.showMessageDialog(null, "User not Found");
                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });

        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {

                    Register rego = new Register();

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        });

    }

}
