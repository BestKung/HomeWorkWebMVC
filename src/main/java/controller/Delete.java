package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Delete {
    
    public void DeleteData(String id){
        Connection conn = ConnectionToDatabase.getConnection();
        String sql = "delete from employees where employee_id = ?";
         String callid = id;
         String index = "";
          if(callid.length() < 4 ){
                   char[] arrc = {'0','0','0','0'};
                   int tmp = 0;
                   tmp = 4 - callid.length();
                   for(int i = tmp ; i < 4 ; i++ ){
                       char c = callid.charAt(i-tmp);
                       arrc[i] = c;
                   }
                   for(int i = 0 ; i < arrc.length ; i++){
                       index = index + arrc[i];
                   }
                   System.out.println(index);
               }
               else{
                   index = callid;
               }
         try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, index);
            pre.executeUpdate();
          } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
             if(conn != null){
                 try {
                     conn.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(Delete.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         }
    }
    
    public static void main(String[] args) {
        Delete d = new Delete();
        d.DeleteData("0005");
        //System.out.println(d.DeleteData("5453"));
    }
}
