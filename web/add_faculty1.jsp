<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.List,java.util.LinkedList,java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <body>
        <h2 style="text-align: center;color: brown;background-color: lightskyblue">ADD FACULTY DETAILS</h2>
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
        
<p style='color:green;text-align:center'>Enter details of faculty to be added</p>
  <form action='add_faculty.do' method='POST' style="text-align: center;font-size: larger;font-style: italic">
    Faculty ID (5 character): <input type='text' name='faculty_id' /><br /><br/>
    First name: <input type='text' name='first_name' /><br /><br/>
    Last name: <input type='text' name='last_name' /><br /><br/>
    Course ID (5 character): <input type='text' name='course_id' /><br /><br/>
    Centre ID (5 character): <input type='text' name='centre_id' /><br /><br/>
    Phone : <input type='text' name='phone' /><br /><br/>
    Address : <input type='text' name='address' /><br /><br/>
     <input type='submit' value='SUBMIT' />
    </form>
      </body>
           </html>

