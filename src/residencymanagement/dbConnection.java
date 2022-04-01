/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package residencymanagement;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author patel
 */
public class dbConnection {
    
    public static Connection conn() {
        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/8lXBZlV3rb", "8lXBZlV3rb", "d7DpP308Ue");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return conn;
    }
}
