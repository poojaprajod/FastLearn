<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
   <% final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

        String id=request.getParameter("id");
        Connection conn = null;
        ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select * from student where student_id=? "; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      pst.setString(1,id);

      ex = pst.executeQuery();
      boolean next = ex.next();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }%>
 
       

            <html>
            <head>
            <title>PROFILE</title> 
            </head>
            <body>
            <h2 style="text-align: center;background-color:lightskyblue;color: brown">PROFILE </h2>
            <hr/>
            *** In case of any errors report to admin immmediately
            <br/> <br/>
            <hr/>
            <p style="text-align: center">
            Name :   <strong><%= ex.getString("first_name")%>  <%= ex.getString("last_name")%> </strong>
            <br/><br/>
            ID  :  <strong> <%= ex.getString("student_id")%></strong>
            <br/><br/>
            Course ID :  <strong> <%= ex.getString("course_id")%> </strong>
            <br/><br/>
            Centre ID :  <strong> <%=ex.getString("centre_id") %> </strong>
            <br/><br/>
            Faculty ID :  <strong> <%= ex.getString("faculty_id")%> </strong>
            <br/><br/>
            Address :  <strong> <%= ex.getString("address") %> </strong>
            <br/><br/>
            Phone :  <strong> <%= ex.getString("phone") %></strong>
            </p>
            <br/><br/>
            <br/>
            <br/>
            <hr/>
            YOUR STUDY MATERIAL IS AVAILABLE <a href='<%= ex.getString("course_id") %>.pdf' target="_blank"><img src="pdf.png" height="50" width="50" alt="pdf" />HERE</a>
            <br/>
            <hr/>
            </body>
            </html>