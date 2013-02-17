
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CENTRES</title>
    </head>
    <body>
        <h1 style="text-align: center;font-style:italic;background-color:lightskyblue;color: brown">OUR CENTRES ARE AT : </h1>
  <BR/><HR/>
   <%! final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; %> 
   <%! final String DB_URL = "jdbc:mysql://localhost/fastlearn";%>
   <%! final String USER = "root";%>
   <%! final String PASS = "toor";%>
   <%! Connection conn = null;%>
   <%! ResultSet ex = null;%>
   <%
   try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select * from centre "; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();%>
     
   
   <ul>
   <% while (ex.next()){%>
       <li>
           ID  :    <strong> <%= ex.getString("centre_id")%> </strong><br/>
           <br/>
           NAME  :    <strong> <%= ex.getString("name")%> </strong><br/>
           <br/>
           LOCATION  :    <strong> <%= ex.getString("location")%> </strong> <br/>
           <br/>
           <HR/>
       </li>
  <% } %>
   </ul>
 
<% }catch(SQLException se){
       
   }catch(Exception e){
     
   }  %>
    </body>
</html>
