package net.flood.ocrnn.ui;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class login {

    Connection con;
    Statement st;
    ResultSet rs;

    static final String DB_URL = "jdbc:mysql://localhost/db1";

    JFrame f = new JFrame("User Login");
    JLabel un = new JLabel("Username:");
    JLabel pw = new JLabel("Password:");
    JTextField tun = new JTextField(10);
    JTextField tpw = new JTextField(10);
    JButton b = new JButton("Login");

    public login() {
        connect();

    }

    public void connect() {

        try {
            String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
            Class.forName(driver);

            String db = "jdbc:odbc:db1";
            con = DriverManager.getConnection(db);
            st = con.createStatement();

        } catch (Exception ex) {

        }

    }

}
