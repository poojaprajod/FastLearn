
<%@ taglib uri='/WEB-INF/struts-tiles.tld' prefix='template' %>
<template:insert template='template.jsp'>
		
		<template:put name='content' content='intro.jsp' />
		<template:put name='sidebarA' content='options.jsp' />
                <template:put name='sidebarB' content='' />
</template:insert>

