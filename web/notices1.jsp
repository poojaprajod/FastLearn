
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>NOTICE</title>
    </head>
    <body>
        <h2 style="text-align: center;background-color:lightskyblue;color: brown"> NOTICES </h2>
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
      String sql = "select message from notice order by message_date desc limit 50 "; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }  %>
   
   <ul style="font-size: large">
   <% while (ex.next()){%>
       <li>
          <%= ex.getString("message")%> <br/>
       </li>
       <br/>
  <% } %>
   </ul>
 

    </body>
</html>