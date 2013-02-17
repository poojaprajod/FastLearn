 <%@page contentType="text/html" pageEncoding="UTF-8" import ="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<% final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";

          Connection conn = null;
          Statement stmt = null;
          ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select faculty_id,first_name,last_name from faculty"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   } %>
        
            <html>
            <head>
            <title>BLOCK FACULTY</title>
            </head>
            <body>
                <h2 style="text-align: center;color: brown;background-color: lightskyblue">BLOCK FACULTY</h2>
           <br/>
           <hr/>
           <br/>
            <p style="color:green;text-align: center"> SELECT FACULTY TO BE BLOCKED </p>
            <form action='block_faculty.do' method='POST'style="text-align: center;font-size: larger;font-style: italic">
            <select name='id'>
           <% while(ex.next()){
                String val=ex.getString("faculty_id")+"  "+ex.getString("first_name")+"  "+ex.getString("last_name");%>
            <option value=<%=ex.getString("faculty_id")%>><%=val%></option>
           <% } %>
            </select>
            <input type='submit' value='GO'>
            </form>
            </body>
          </html>
