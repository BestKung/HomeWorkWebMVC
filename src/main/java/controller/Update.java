

package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Update {
    
    public void UpdateData(String id , String firstname , String lastname , String email ,
                           String phone , double salary , String index){
        Connection conn = new ConnectionToDatabase().getConnection();
        String callid = id+"";
        String callindex = index+"";
        
        try {
             String sql = "update employees set "
                + "employee_id = ? , "
                + "first_name = ?,"
                + "last_name = ?,"
                + "email = ?,"
                + "phone_number = ?,"
                + "salary = ?"
                + "where employee_id = ?";
        
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1, id);
        pre.setString(2, firstname);
        pre.setString(3, lastname);
        pre.setString(4, email);
        pre.setString(5, phone);
        pre.setDouble(6, salary);
        pre.setString(7, index);
       
        if(pre.executeUpdate() != -1){
            System.out.println("Success");
        }
        
                
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
       // Update up = new Update();
        //up.UpdateData("0005","Kittiporn","Khamlai" ,"best@gmail.com","0923679647", 70000, "0005");
        String s = "";
        if(s.equals("")){
            System.out.println(1);
        }
    }
}
