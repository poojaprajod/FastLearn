            <html>
        
            <body>
           <h2 style="text-align: center;background-color:lightskyblue;color: brown">FEEDBACK FORM </h2>
           <% String url="post_feed.do?id="+request.getParameter("id");%>
           <form action=<%= url%> method='POST'>
           My feedback : <textarea cols='40' rows='10' name='feed'> </textarea><br />
            <input type='submit' value='POST'>
            </form>
            </body>
            </html>
