package controller;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Insert {
    public void InsertData (String id, String firstname, String lastname, 
            String email, String phone, double salary){
         Connection conn = new ConnectionToDatabase().getConnection();
        try {
              
             String idemp = id+"";
             String sql = "INSERT INTO employees "
                          +"(employee_id,first_name,last_name,email,phone_number,salary,job_id,hire_date)" 
                          + "values (?,?,?,?,?,?,?,SYSDATE)";
             
             PreparedStatement pre = conn.prepareStatement(sql);
             pre.setString(1, idemp);
             pre.setString(2, firstname);
             pre.setString(3, lastname);
             pre.setString(4, email);
             pre.setString(5, phone);
             pre.setDouble(6, salary);
             pre.setString(7, "IT_PROG");
             if(pre.executeUpdate() != -1){
                 System.out.println("Success");
             }
             
            } catch (SQLException ex) {
             ex.printStackTrace();
         }finally{
             if(conn != null){
                 try {
                     conn.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
        
    }
    public static void main(String[] args) {
        Insert ins = new Insert();
                ins.InsertData("0005", "uhgg", "kjshfg", "ihafhuagf", "afkhag", 9803);
    }
    
}
