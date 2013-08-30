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
    <%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
    
    <head>
        <sj:head compressed="false"/>
        <title>JSP Page</title>
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/View/style.css" />
       
        <script type='text/javascript' src='${pageContext.request.contextPath}/View/infogrid.js'></script>  
           
            
    </head>
    <body>
        <s:form action="reservar">
                        
            <s:label value="%{nombreHotel}" />
            
            <s:select 
                
                label="Cliente"  
                list="listaClientes"  
                name="idCliente" 
                listValue="nombre"  
                listKey="idCliente"
                emptyOption="nombre"  
                headerKey="None"  
                headerValue="None"
                
                accesskey=""/>
            
            <s:select 
                
                label="Habitacion a reservar"  
                list="listaHabitaciones"  
                name="reserva.idHabitacion" 
                listValue="numeroHabitacion"  
                listKey="idHabitacion"
                emptyOption="numeroHabitacion"  
                headerKey="None"  
                headerValue="None"
                
                accesskey=""/>
            <s:textfield label="Direccion:" name="cliente.direccion"/>
            <sj:datepicker id="tiempoEntrada" label="Fecha entrada:" name="tiempoEntrada" />
            <sj:datepicker id="tiempoSalida" label="Fecha salida:" name="tiempoSalida"/>
            <s:textfield label="Adelanto:" name="reserva.adelanto"/>
            <s:submit label="Reservar" value="Añadir"/>
            
        </s:form>
        <s:label value="%{msj}" />
    </body>
</html>
