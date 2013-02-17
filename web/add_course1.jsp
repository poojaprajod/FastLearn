<%@page contentType="text/html" pageEncoding="UTF-8" import ="java.util.List,java.util.LinkedList,java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <body>
        <h2 style="text-align: center;color: brown;background-color: lightskyblue">ADD COURSE DETAILS</h2>
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
        
<p style='color:green;text-align:center'>Enter details of course to be added</p>
   <form action='add_course.do' method='POST' style="text-align: center;font-size: larger;font-style: italic">
        Course ID (5 character) : <input type='text' name='course_id' /><br /><br/>
        Name : <input type='text' name='name' /><br /><br/>
        Fee : <input type='text' name='fee' /><br /><br/>
        Pre-requisite : <input type='text' name='prerequisite' /><br /><br/>
        Duration (in months) : <input type='text' name='duration' /><br /><br/>
        <input type='submit' value='Submit' />
    </form>
      </body>
           </html>
