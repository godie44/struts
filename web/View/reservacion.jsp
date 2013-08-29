<%-- 
    Document   : reservacion
    Created on : 28/08/2013, 09:27:01 PM
    Author     : godie44
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
                
                label="Hotel"  
                list="listaHoteles"  
                name="idHotel" 
                listValue="nombre"  
                listKey="idHotel"
                emptyOption="false"  
                headerKey="None"  
                headerValue="None"
                
                accesskey=""/>
            
            <s:select 
                
                label="Cliente"  
                list="listaClientes"  
                name="idHotel" 
                listValue="nombre"  
                listKey="idCliente"
                emptyOption="nombre"  
                headerKey="None"  
                headerValue="None"
                
                accesskey=""/>
            <s:textfield label="Nombre:" name="cliente.nombre"/>
            <s:textfield label="Direccion:" name="cliente.direccion"/>
            <s:textfield label="Telefono residencia:" name="cliente.telefono"/>
            <s:textfield label="Celular:" name="cliente.celular"/>
            <s:submit label="Ingresar Cliente" value="Añadir"/>
            
        </s:form>
    </body>
</html>
