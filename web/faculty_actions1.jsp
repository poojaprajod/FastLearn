
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div>
            <ul style="text-align: center">
                <% String url1="faculty_profile.jsp?id="+request.getParameter("id"); %>
                <li><a href = <%=url1%> >PROFILE</a></li>
                <br/>
                <% String url2="faculty_faq.jsp?id="+request.getParameter("id"); %>
                <li><a href = <%=url2%> >FAQ'S</a></li>
                <br/>
                <% String url3="change_password.jsp?id="+request.getParameter("id"); %>
                <li><a href = <%= url3%> >CHANGE PASSWORD</a></li>
                <br/>
                <li><a href ="login.jsp">LOGOUT</a></li><BR/>
            </ul>
        </div>
    </body>
</html>
