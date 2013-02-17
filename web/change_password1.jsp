<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List,java.util.LinkedList,java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    
    <h1 style="text-align: center;background-color:lightskyblue;color: brown">CHANGE PASSWORD </h1>
 <% List errors=(LinkedList) request.getAttribute("errors"); 
            if(errors !=null){
            Iterator item= errors.iterator(); %>
           <ul style="color: red">
            <% while(item.hasNext()){
            String msg=(String) item.next();%>
            <li> <%= msg%> </li>
           <% } %>
             </ul>
         <% } %>
      
           <body>
            <form action='change_password.do?id=<%= request.getParameter("id")%>' method='post' style="text-align: center;font-size: larger;font-style: italic">
            Username: <input type='text' name='user' /><br/><br/>
            OLD Password: <input type='password' name='oldpass' /><br/><br/>
            NEW Password: <input type='password' name='pass' /><br/><br/>
            <input type='submit' value='CHANGE'>
            </form>
            </body>
          </html>
