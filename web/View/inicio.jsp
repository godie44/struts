<%-- 
    Document   : inicio
    Created on : 10/06/2013, 06:32:08 PM
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
        <div id="page-wrap">

            <div class="info-col">

                <h2>Info Hotel</h2>

                <a class="image ej" href="#">View Image</a>

                <dl>
                    <dt>Acciones</dt>
                    <dd>
                        <sj:a id="ajaxClientes" 
                              href="goCliente" 
                              targets="infor" 
                              indicator="indicator" 
                              >
                            Clientes
                        </sj:a>
                        <br/>
                                                
                        <sj:a id="ajaxHReservas" 
                              href="goReserva" 
                              targets="infor" 
                              indicator="indicator" 
                              >
                            Reservas
                        </sj:a>
                        <br/>
                                                
                    </dd>
                    <dt>Consejos</dt>
                    <dd>
                        Siempre atienda con una sonrisa al cliente.
                    </dd>
                </dl>

            </div>

            <center>
                
                <div id="infor" style="margin-top: 75px">
                    <s:label value="%{msj}"/>
                </div></center>
        </div>
    </body>
</html>
