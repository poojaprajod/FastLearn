<%@page contentType="text/html" pageEncoding="UTF-8" import="java.util.List,java.util.LinkedList,java.util.Iterator"%>
 <html>
    <head>
          <title></title>
     </head>
       <body>
           
           <h2 style="text-align: center;background-color:lightskyblue;color: brown">LOGIN </h2>
<% List errors=(LinkedList) request.getAttribute("errors"); %>
            <% if(errors !=null){ %>
            <% Iterator item= errors.iterator(); %>
            <ul style='color:red'>
               <% while(item.hasNext()){
               String msg=(String) item.next();%> 
               <li><%= msg %>  </li>
                <% } %>
             </ul>
         <% } %>
         <form action='login.do' method='post' style="text-align: center;font-size: larger;font-style: italic">
          <br/>
            &nbsp   Username: <input type='text' name='user' /><br/><br/>
            &nbsp   Password: <input type='password' name='pass' /><br/><br/>
            <input type='submit' value='LOG IN' />
            </form>
            </body>
            </html>
    


