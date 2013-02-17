<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.* "%>
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
      String sql = "select id from login"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }
     %>
         <html>
         
           <body>
               <h2 style="text-align: center;background-color:lightskyblue;color: brown">RESET PASSWORD </h2>
            <p style='color:green;text-align:center'> SELECT ID TO BE UNBLOCKED </p>
           <form action='reset_password.do' method='POST'style="text-align: center;font-size: larger;font-style: italic">
            <select name='id'>
            <% while(ex.next()){
                String val=ex.getString("id");%>
                <option value=<%=val%> ><%=val%> </option>
           <%  } %>
           </select><br/><br/>
           New Password: <input type='password' name='pass' /><br/><br />
           <input type='submit' value='GO'>
            </form>
           </body>
        </html>