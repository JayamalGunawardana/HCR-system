
package net.flood.ocrnn.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import net.flood.ocrnn.ui.Register;

public class db_conn {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Connection DBConnect() throws IOException, Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/useraccess", "root", "1111");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
            errorLog db_log = new errorLog("errorLog.txt");

            db_log.logger.setLevel(Level.WARNING);

            db_log.logger.info("Error");
            db_log.logger.warning("Error:" + ex);

        }
        return con;
    }

    public Object getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
