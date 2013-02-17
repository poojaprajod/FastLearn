<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">

<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
   
            <ul style="text-align: center">
                <% String url1="student_profile.jsp?id="+request.getParameter("id"); %>
                <li><a href = <%= url1%> >PROFILE</a></li>
                <br/>
                <% String url2="student_faq.jsp?id="+request.getParameter("id"); %>
                
                <li><a href = <%= url2%> >FAQ'S</a></li>
                <br/>
                <% String url3="change_password.jsp?id="+request.getParameter("id"); %>
                <li><a href = <%= url3%> >CHANGE PASSWORD</a></li>
                <br/>
                <% String url4="get_feed.jsp?id="+request.getParameter("id"); %>
                <li><a href = <%= url4%> >GIVE US A FEEDBACK</a></li>
                <br/>
                <li><a href ="login.jsp">LOGOUT</a></li><br/>
            </ul>

    </body>
</html>
