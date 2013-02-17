<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %>
<html>
<head>
<title><template:get name='title'/>
</title>
</head>
<body>
<table border='0'>
<tr>
<td><template:get name='top'/></td>
</tr>
<tr>
<td bgcolor="#FF55FF">
<template:get name='middle'/></td>
</tr>
<tr>
<td><template:get name='bottom'/></td>
</tr>
</table>
</body>
</html>