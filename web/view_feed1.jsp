<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

          Connection conn = null;
          Statement stmt = null;
          ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select feed from feedback order by feed_date desc";
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }
       %>
       <html>
            <body>
            <h2 style="text-align: center;background-color:lightskyblue;color: brown">STUDENT FEEDBACKS </h2>
            <br/>
            <ul>
            <% while(ex.next()){
                String val=ex.getString("feed");%>
           <li><%=val%><br/><hr/></li>
         <%   } %>

            </body>
            </html>
