<%@page import="controller.Update"%>
<%@page import="java.sql.Connection"%>
<%@page import="controller.ConnectionToDatabase"%>
<%@page import="controller.Delete"%>
<%@page import="Model.DataColumn"%>
<%@page import="controller.Insert"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="stylesheet" href="StyleIndex.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page</title>
    </head>
    <body>

        <div id="head"><h1>Employees</h1></div>
        <button onclick="alert(<%=request.getParameter("txtcode") %>)">testcode</button>
        <button onclick="alert(<%=request.getParameter("txtfirstname") %>)">firstname</button>

        <%
            String code = "0";
            String delete = request.getParameter("txtdeleteid");
            String id = "";
            String firstname = "";
            String lastname = "";
            String email = "";
            String phone = "";
            double salary = 0;
            String searchby = "";
            String searchvalue = "";

            if (request.getParameter("txtcode") != null) {

                switch (Integer.parseInt(request.getParameter("txtcode"))) {
                    case 1:
                        code = "0";
                        id = request.getParameter("txtid");
                        firstname = request.getParameter("txtfirstname");
                        lastname = request.getParameter("txtlastname");
                        email = request.getParameter("txtemail");
                        phone = request.getParameter("txtphone");
                        salary = Double.parseDouble(request.getParameter("txtsalary"));

                        Update upd = new Update();
                        upd.UpdateData(id, firstname, lastname, email, phone, salary, id);
                        
                        break;
                    case 2:
                        code = "0";
                        Delete del = new Delete();
                        del.DeleteData(delete);
                        
                        break;
                    case 0 :
                            code = "0";
                            id = request.getParameter("txtid");
                            firstname = request.getParameter("txtfirstname");
                            lastname = request.getParameter("txtlastname");
                            email = request.getParameter("txtemail");
                            phone = request.getParameter("txtphone");
                            salary = Double.parseDouble(request.getParameter("txtsalary"));

                            Insert ins = new Insert();
                            ins.InsertData(id, firstname, lastname, email, phone, salary);
                            
                        break;
                   }
                }

            
        %>

        <form id="fromadd" method="post" action="index.jsp">
            <div id="idj"><h3>Id</h3></div>  
            <input id="inputid" name="txtid" value="<%=id%>">

            <div id="firstnamej"><h3>First Name</h3></div>  
            <input id="inputfirstname" name="txtfirstname" value="<%=firstname%>" >
            <div id="lastnamej"><h3>Last Name</h3></div>  
            <input id="inputlastname" name="txtlastname" value="<%=lastname%>">

            <div id="emailj"><h3>E-mail</h3></div>  
            <input id="inputemail" name="txtemail" value="<%=email%>">
            <div id="phonej"><h3>Phone Number</h3></div>  
            <input id="inputphone" name="txtphone" value="<%=phone%>">

            <div id="salaryj"><h3>Salary</h3></div>  
            <input id="inputsalary" name="txtsalary" value="<%=salary%>">

            <input type="hidden" name="deleteid" value="no">
            <%
                if (request.getParameter("txtcode") != null) {
                    if (request.getParameter("txtcode").equals("1")) {
                        code = "1";

                    } else {
                        code = "0";
                    }
                }
            %>
            <input type="hidden" name="txtcode" value="<%=code%>">
            <button id="btnOk" type="submit">OK</button>
        </form>

            <form method="post" action="index.jsp">
            <%
                id = "";
                firstname = "";
                lastname = "";
                email = "";
                phone = "";
                salary = 0;
            %>    
              
            <button id="btnclear" type="submit" >Clear</button>
        </form>

        <div id="containnersearch"></div>
        <div id="searchj"><h3>Search</h3></div>  

        <form method="post" action="index.jsp">
            <input id="inputsearch" name="txtsearch">
            <select id="searchselect" name="sesearch">
                <option value="name" >name</option>
                <option value="email">email</option>
                <option value="phone">phone</option>
                <option value="salary">salary</option>
            </select
            <input type="hidden" value="0">
            <button id="btnsearch" type="submit">Search</button>
        </form>

        <table>
            <thead>
                <tr class="trcon">
                    <td class="tdno">no.</td>
                    <td class="tdid">employee id</td>
                    <td class="tdfirst">first name</td>
                    <td class="tdlast">last name</td>
                    <td class="tdemail">email</td>
                    <td class="tdphone">phone number</td>
                    <td class="tdsalary">salary</td>
                    <td class="tdmodify">show data</td>
                </tr>
            </thead>
            <tbody>
                <%
                    if (request.getParameter("txtsearch") != null) {
                        searchby = request.getParameter("sesearch");
                        searchvalue = request.getParameter("txtsearch");
                    }
                    DataColumn dcl = new DataColumn();
                    dcl.CreateData(searchby, searchvalue);
                    for (int i = 0; i < dcl.getId().size(); i++) {
                %>
                <tr>
                    <td><%= i + 1%></td>
                    <td><%= dcl.getId().get(i)%></td>
                    <td><%= dcl.getFirstname().get(i)%></td>
                    <td><%= dcl.getLastname().get(i)%></td>
                    <td><%= dcl.getEmail().get(i)%></td>
                    <td><%= dcl.getPhonenumber().get(i)%></td>
                    <td><%= dcl.getSalary().get(i)%></td>
                    <td><form id="formupdate" method="post" action="index.jsp">
                            <input id="inputid" type="hidden" name="txtid" value="<%=dcl.getId().get(i)%>">
                            <input id="inputfirstname" type="hidden" name="txtfirstname" value="<%=dcl.getFirstname().get(i)%>">
                            <input id="inputlastname" type="hidden" name="txtlastname" value="<%=dcl.getLastname().get(i)%>">
                            <input id="inputemail" type="hidden" name="txtemail" value="<%=dcl.getEmail().get(i)%>">
                            <input id="inputphone" type="hidden" name="txtphone" value="<%=dcl.getPhonenumber().get(i)%>">
                            <input id="inputsalary" type="hidden" name="txtsalary" value="<%=dcl.getSalary().get(i)%>">
                            <input type="hidden" name="txtcode" value="1">
                            <button id="btnupdate" type="submit">Update</button>
                        </form>


                        <form id="formdelete" method="post" action="index.jsp">
                            <input type="hidden" name="txtcode" value="2">   
                            <input type="hidden" name="txtdeleteid" onclick="if (confirm('Delete ' +<%= dcl.getFirstname().get(i)%>))" value="<%=dcl.getId().get(i)%>">
                            <button id="btndelete" type="submit" onclick="alert(<%=dcl.getFirstname().get(i)%>)">Delete</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </body>




</html>


