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
        <s:form action="reservar">
            <s:select 
                
                label="Tarjeta"  
                list="listaTarjetas"  
                name="tarjeta.numero" 
                listValue="numero"  
                listKey="numero"
                emptyOption="false"  
                headerKey="None"  
                headerValue="None"
                
                />
            
            <s:textfield label="Monto" name="transac.monto"/>
            <s:textfield label="Descripcion" name="transac.descripcion"/>
            <s:submit label="prueba de boton" value="Depositar"/>
            
        </s:form>
    </body>
</html>
