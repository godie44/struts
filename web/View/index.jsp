<%-- 
    Document   : index
    Created on : 05/06/2013, 11:34:49 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/cssActas.css" />
        <title>Login</title>
    </head>
    <body>
        <div id="contenido">
        <center>
        <h1>Bienvenido!</h1>
        <s:label value="%{msj}"/>
        <s:form action="validar">
            <s:textfield label="Usuario" name="empleado.usuario"/>
            <s:password label="Clave" name="empleado.password"/>
            <s:submit label="prueba de boton" value="Entrar"/>
            
        </s:form>
            </center>      
        </div>
    </body>
</html>
