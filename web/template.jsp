<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %>
<html>
<head>
<title>FAST LEARN
</title>
</head>
<body> 
<table border="0" cellspacing="0" cellpadding="0" width="1200">
<tr> 
    <td width="220"><img src = 'icon.jpg'></td>
    <td width="650" bgcolor="#cc6699" >
        <h2 style="color:white;text-align:right;font-size:xx-large">FAST LEARN</h2></td>
    <td width="300" bgcolor="#cc6699" ></td>
</tr> 
<tr>
    <td width="220" bgcolor="#ffff99"><template:get name='sidebarA'/></td>
    <td width="650" bgcolor="009999"background="books.jpg"><template:get name='content'/></td>
    <td width="300"bgcolor="#FFcccc"><template:get name='sidebarB'/></td>
</tr>
</table>
</body>
</html>