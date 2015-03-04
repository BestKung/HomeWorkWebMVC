/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import Model.DataColumn;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



/**
 *
 * @author Best
 */
@ManagedBean
@ViewScoped
public class ShowData {
    
     ArrayList<String> id ;
     ArrayList<String> firstname;
     ArrayList<String> lastname;
     ArrayList<String> email;
     ArrayList<String> phonenumber;
     ArrayList<String> salary;
     
    /*public void CreateData() throws SQLException{
        
        String sqlShow = "SELECT * FROM db_homework";
        Connection conn = new ConnectionToDatabase().getConnection();
        ResultSet rs = conn.createStatement().executeQuery(sqlShow);
        
        id = new ArrayList<String>();
        firstname = new ArrayList<String>();
        lastname = new ArrayList<String>();
        email = new ArrayList<String>();
        phonenumber = new ArrayList<String>();
        salary = new ArrayList<String>();
        
        while(rs.next()){
            id.add(rs.getString("id"));
            firstname.add(rs.getString("first_name"));
            lastname.add(rs.getString("last_name"));
            email.add(rs.getString("email"));
            phonenumber.add(rs.getString("phone_number"));
            salary.add(rs.getString("salary"));
            
        }
     } 
    
    public ArrayList<String> getData() throws SQLException{
        if(id == null){
            CreateData();
        }
        return id;
    }*/
    
    public static void main (String[] args) throws SQLException {
      
        DataColumn dcl = new DataColumn();
        dcl.CreateData("name", "a");
       //dcl.CreateData("name","Steven");
        //SearchBy se = new SearchBy();
        //System.out.println(se.SearchData("phone"));
        //Insert ins = new Insert();
      //  ins.InsertData("0002", "Best", "kittiporn", "kk@gmail.com","0923679647" , 30000);
        
       // System.out.println(dcl.getId().size());
      
       System.out.println( dcl.getId().size());
      for(int i = 0 ; i < dcl.getId().size() ; i++){
            System.out.println(dcl.getId().get(i)+"  "+dcl.getFirstname().get(i)+"  "+dcl.getLastname().get(i)+"  "+
                    dcl.getLastname().get(i)+"  "+dcl.getPhonenumber().get(i)+"  "+dcl.getSalary().get(i));
        }
        
    }
}
