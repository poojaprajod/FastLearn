<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.List,java.util.LinkedList,java.util.Iterator,java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   final String DB_URL = "jdbc:mysql://localhost/fastlearn";
   final String USER = "root";
   final String PASS = "toor";  
  

          Connection conn = null;
          Statement stmt = null;
          ResultSet ex = null;
     try{
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      String sql = "select student_id,first_name,last_name from student"; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }%>
   
            <html>
            <body>
                     <h2 style="text-align: center;background-color:lightskyblue;color: brown">EDIT STUDENT </h2>
       <%   List errors=(LinkedList) request.getAttribute("errors"); 
            if(errors !=null){
            Iterator item= errors.iterator(); %>
            <ul>
           <%while(item.hasNext()){
            String msg=(String) item.next();%>
            <li><%=msg%></li>
           <%}%>
             </ul>
            <% } %>
           <p style="color: green;text-align: center"> SELECT STUDENT TO BE EDITED </h3>
           <form action='edit_student.do' method='POST' style="font-size: larger;font-style: italic;text-align: center">
           <select name='id'>
          <%while(ex.next()){
                String val=ex.getString("student_id")+"  "+ex.getString("first_name")+"  "+ex.getString("last_name");%>
           <option value=<%= ex.getString("student_id")%> ><%=val%></option>
          <%}%>
           </select><br/><br/>
            <select name='feild'>
            <option value = 'course_id' >COURSE</option>
            <option value = 'faculty_id' >FACULTY</option>
          <option value = 'centre_id' >CENTRE</option>
            <option value = 'phone' >PHONE</option>
            <option value = 'address' >ADDRESS</option>
            </select><br/><br/>
            New value : <input type='text' name='value' /><br /><br/>
            <input type='submit' value='GO'>
            </form>
            </body>
            </html>