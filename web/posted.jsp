<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %>
<% String c=request.getParameter("id");%>
  <%  if(c.matches("S\\d\\d\\d\\d")) { %>
          
 <template:insert template='template.jsp'>
		<template:put name='content' content='QUERY POSTED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'student_actions1.jsp' />
</template:insert>
          
 <% } %>
   <%if(c.matches("F\\d\\d\\d\\d")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='SOLUTION POSTED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'faculty_actions1.jsp' />
</template:insert>
  <% }%>
