

package Model;

import controller.ConnectionToDatabase;
import controller.SearchBy;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DataColumn {
    
     ArrayList<String> id ;
     ArrayList<String> firstname;
     ArrayList<String> lastname;
     ArrayList<String> email;
     ArrayList<String> phonenumber;
     ArrayList<String> salary;
     
      public void CreateData(String searchby , String key) throws SQLException{
        
        String sqlShow = "";
        SearchBy search = new SearchBy();
        Connection conn = new ConnectionToDatabase().getConnection();
        if(searchby.length() != 0){
            System.out.println("not null");
          sqlShow = "SELECT * FROM employees where lower("
                  +search.SearchData(searchby)+") LIKE(lower('%"+key+"%')) order by employee_id asc"; 
            System.out.println(sqlShow);
            
            
            
        }
        else{
            System.out.println("Data is null");
            sqlShow = "SELECT * FROM employees order by employee_id asc";
        }
        ResultSet rs = conn.createStatement().executeQuery(sqlShow);
        
        id = new ArrayList<String>();
        firstname = new ArrayList<String>();
        lastname = new ArrayList<String>();
        email = new ArrayList<String>();
        phonenumber = new ArrayList<String>();
        salary = new ArrayList<String>();
        
        while(rs.next()){
            id.add(rs.getString("employee_id"));
            firstname.add(rs.getString("first_name"));
            lastname.add(rs.getString("last_name"));
            email.add(rs.getString("email"));
            phonenumber.add(rs.getString("phone_number"));
            salary.add(rs.getString("salary"));
            
        }
     } 

    public ArrayList<String> getId() {
        return id;
    }

    public void setId(ArrayList<String> id)  {
        this.id = id;
    }

    public ArrayList<String> getFirstname() {
        return firstname;
    }

    public void setFirstname(ArrayList<String> firstname)  {
        this.firstname = firstname;
    }

    public ArrayList<String> getLastname() {
        return lastname;
    }

    public void setLastname(ArrayList<String> lastname)  {
        this.lastname = lastname;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email)  {
        this.email = email;
    }

    public ArrayList<String> getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(ArrayList<String> phonenumber) throws SQLException {
        this.phonenumber = phonenumber;
    }

    public ArrayList<String> getSalary() {
        return salary;
    }

    public void setSalary(ArrayList<String> salary) throws SQLException {
        this.salary = salary;
    }
     
     
}
