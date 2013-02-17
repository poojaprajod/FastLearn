<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.List,java.util.LinkedList,java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <body>
        <h2 style="text-align: center;color: brown;background-color: lightskyblue">ADD CENTRE DETAILS</h2>
           <br/>
           <hr/>
           <br/>
        <% List errors=(LinkedList) request.getAttribute("errors"); 
            if(errors !=null){
            Iterator item= errors.iterator(); %>
            <ul style="color: red">
            <% while(item.hasNext()){
            String msg=(String) item.next();%>
            <li> <%=msg%> </li
          <%  } %>
            </ul>
        <%  } %>
     <p style='color:green;text-align:center;font-size: large'>Enter details of centre to be added</p>
     <form action='add_centre.do' method='POST' style='text-align: center;font-size: larger;font-style: italic'>
      Centre ID (5 character) : <input type='text' name='centre_id' /><br /><br/>
      Name : <input type='text' name='name' /><br /><br/>
      Location : <input type='text' name='location' /><br /><br/>
     <input type='submit' value='Submit' />
     </form>
       </body>
           </html>