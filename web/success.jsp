<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %>
<% String c=request.getParameter("page");%>
  <%  if(c.matches("add_centre")) { %>
          
 <template:insert template='template.jsp'>
		<template:put name='content' content='CENTRE ADDED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
          
 <% } %>
   <%if(c.matches("add_course")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='COURSE ADDED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
  <%if(c.matches("add_faculty")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='FACULTY ADDED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
 <%if(c.matches("add_student")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='STUDENT ADDED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>

  <%if(c.matches("block_student")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='STUDENT BLOCKED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
     
<%if(c.matches("block_faculty")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='FACULTY BLOCKED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
    <%if(c.matches("edit_student")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='STUDENT EDITED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
  <%if(c.matches("edit_faculty")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='FACULTY EDITED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
  <%if(c.matches("post_notice")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='NOTICE POSTED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
  <%if(c.matches("remove_course")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='COURSE REMOVED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  <%if(c.matches("reset_password")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='PASSWORD REST SUCCESSFULL' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>
  
  <%if(c.matches("initial")){%>
       <template:insert template='template.jsp'>
		<template:put name='content' content='TABLES CREATED SUCCESSFULLY' direct="true" />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content = 'admin_actions1.html' />
</template:insert>
  <% }%>