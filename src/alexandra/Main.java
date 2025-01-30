/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package alexandra;

import java.sql.*;
/**
 *
 * @author 20221074010051
 */
public class Main {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Connection con = null;

        try {
            con = new ConnectionFactory().getConnection();
            System.out.println("Connection OK!");

            // ********** CRUD ********** 

            String sql = "";

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            con.close();
            System.out.println("Connection closed!");
        }

    }
}
