
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>COURSE</title>
    </head>
    <body>
        <h1 style="text-align: center;font-style:italic;background-color:lightskyblue;color: brown">OUR COURSES </h1>
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
      String sql = "select * from course "; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }  %>
   <br/>
   <hr/>
   <ul style="font-style: italic">
   <% while (ex.next()){%>
       <li>
           ID    :     <strong> <%= ex.getString("course_id")%> </strong><br/>
           NAME  :     <strong> <%= ex.getString("name")%> </strong><br/>
           FEE   :  <strong> <%= ex.getString("fee")%> </strong><br/>
           PREREQUISITE :  <strong> <%= ex.getString("prerequisite")%> </strong> <br/>
           DURATION :   <strong> <%= ex.getString("duration")%> months </strong> <br/>
       <hr/></li>
       <br/><br/>
  <% } %>
   </ul>
 

    </body>
</html>
