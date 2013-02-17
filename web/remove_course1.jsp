<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
 <%  final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";
  
          Connection conn = null;
          Statement stmt = null;
          ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select course_id,name from course"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }
      %>
           <html>
            
            <body>
                <h2 style="text-align: center;background-color:lightskyblue;color: brown">REMOVE COURSE </h2>
            <p style='color:green;text-align:center'> SELECT COURSE TO BE REMOVED </p>
            <form action='remove_course.do' method='POST'style="text-align: center;font-size: larger;font-style: italic">
            <select name='id'>
           <% while(ex.next()){
                String val=ex.getString("course_id")+"  "+ex.getString("name"); %>
            <option value=<%=ex.getString("course_id")%> ><%=val%></option>
            <% } %>
            </select><br/><br/>
           <input type='submit' value='GO'>
            </form>
          </body>
            </html>
