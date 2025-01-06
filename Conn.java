package electricitybillingsystem2;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;
    Conn() {
        try {
            c = DriverManager.getConnection("jdbc:mysql:///Ebs_1", "root", "Zack321.#");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
      public Connection getConnection() {
        return c;
    }
}