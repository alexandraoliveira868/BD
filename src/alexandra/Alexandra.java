/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alexandra;
import java.sql.*;
/**
 *
 * @author 20221074010051
 */
public class Alexandra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        String url = "jdbc:mysql://localhost/sakila";
        String usr = "root";
        String pwd = "1234";
       
        Connection con = null;
        
        try{
            con = new ConnectionFactory().getConnection();
            System.out.println("Connection OK!");
            String sql = "insert into customer(store_id, first_name, last_name, email, address_id, active)"
                    + "values(?, ?, ?, ?, ?, ?)";
       
        PreparedStatement pst = con.prepareStatement(sql);
       
        pst.setInt(1,1);
        pst.setString(2,"Alcemy");
        pst.setString(3,"Severino");
        pst.setString(4,"alcemy@gmail.com");
        pst.setInt(5,10);
        pst.setInt(6,1);
        pst.execute();
         String query = " select * from customer"
              + " order by customer_id desc"
              + " limit 5";
             Statement qst = con.createStatement();
            ResultSet rs = qst.executeQuery(query);
            ResultSetMetaData md = rs.getMetaData();
            int col = md.getColumnCount();
            for (int i = 1; i <= col; i++){
                System.out.print(md.getColumnName(i)+"\t");
            } System.out.println("");
       
            while (rs.next()){
                for (int i = 1; i <= col; i++) {
                    System.out.print(rs.getString(i)+ "\t");
               
                }System.out.println("");
            }
        pst.close();
       
        sql = "update customer"
              + "set store_id = ?"
              + "where address_id = ?";
       
        pst = con.prepareStatement(sql);
       
        pst.setInt(1,2);
        pst.setInt(2,5);
   
      
       pst.execute();
       pst.close();
       
       
        sql = "delete customer"
                +"where store_id = ?";
        }
        catch (SQLException e){
            e.printStackTrace();
             System.out.println("Erro");
        }
        finally{
         con.close();
       System.out.println("closed!");
    }
    }
       
    }
    



