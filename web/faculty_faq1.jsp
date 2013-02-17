
<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>FAQ</title>
    </head>
    <body>
        <h2 style="text-align: center;background-color:lightskyblue;color: brown">FAQ'S </h2><BR/>
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
      String sql = "select query_id,query,solution from faq order by query_date desc "; 
      PreparedStatement pst =  conn.prepareStatement(sql);
      ex = pst.executeQuery();
     }catch(SQLException se){
       
   }catch(Exception e){
     
   }  %>
   
   
   <ul>
   <% while (ex.next()){%>
       <li>
          ID : <strong> <%= ex.getString("query_id")%> </strong><br/>
          QUERY : <%= ex.getString("query")%> <br/>
          <% if(ex.getString("solution").equals("NOT ANSWERED YET")) {%>
             
              <% String url="post_solution.do?id="+request.getParameter("id"); %>
               <form action=<%=url%> method='POST'>
                    QUERY ID :<input type="text" name="qid" ><br/>
                      YOUR ANSWER :<textarea name="solution" cols="20" rows="20"></textarea>
                      <input type="submit" value="SUBMIT ANSWER">
                </form>
           <% } %>
           <%if(!ex.getString("solution").equals("NOT ANSWERED YET")) { %>
          SOLUTION : <%= ex.getString("solution")%> <br/>
          <% } %>
            <BR/><HR/>    
       </li>
  <% } %>
   </ul>
 

    </body>
</html>
