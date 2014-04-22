<%-- 
    Document   : error
    Created on : 20/04/2014, 08:26:13 PM
    Author     : Diego
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<title>ERROR</title>
<link href="css/estilos.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<% String de = (String) request.getParameter("de"); %>
<p class="tituloError"> A ocurrido un Error <i class="error"> <%=de%> </i>
La Excepcion fue = <i class="error"> <%= exception%> </i><br/>
<% System.out.println(exception.toString()); %>
</p>
</body>
</html>