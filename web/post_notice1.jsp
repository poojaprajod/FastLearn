
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
 <html>
     <body>
         <h2 style="text-align: center;background-color:lightskyblue;color: brown">POST A NOTICE</h2>
         <br/><hr/><br/>
         
         <form action=post_notice.do method='POST'>
          Notice : <textarea cols='40' rows='10' name='message'> </textarea><br />
          <input type='submit' value='POST'>
          </form>
     </body>
           </html>
