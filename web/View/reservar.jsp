<%-- 
    Document   : reservar
    Created on : 11/06/2013, 10:30:52 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@taglib uri="/struts-jquery-tags" prefix="sj"%>
    <head>
        <sj:head compressed="false"/>
        <title>JSP Page</title>
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/View/style.css" />

        <script type='text/javascript' src='${pageContext.request.contextPath}/View/infogrid.js'></script>   
    </head>
    <body>
        <s:form action="insertar">
                        
            <s:textfield label="Nombre:" name="cliente.nombre"/>
            <s:textfield label="Direccion:" name="cliente.direccion"/>
            <s:textfield label="Telefono residencia:" name="cliente.telefono"/>
            <s:textfield label="Celular:" name="cliente.celular"/>
            <s:submit label="Ingresar Cliente" value="Añadir"/>
            
        </s:form>
    </body>
</html>
