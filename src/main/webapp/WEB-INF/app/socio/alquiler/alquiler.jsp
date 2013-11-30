<%-- 
Document   : alquiler
    Created on : 29-nov-2013, 22:04:43
    Author     : saravia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Locales </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <%@include file="/public/header.jsp" %>
    </head>
    <body>

        <%@include file="/public/menuGeneral.jsp" %>

        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="/public/menuSocio.jsp" %>
                <div class="span9">
                    <div class="row">
                        <a class=" btn btn-primary pull-right" href="<%=contextPath%>/socio/alquiler/new"> Nuevo </a>
                        <h1> campo </h1>
                    </div>
                    <table class="table table-striped table-hover"> 
                        <tr>
                            <th>Hora Ini.</th>
                            <th>Hora Fin </th>
                            <th>Día </th>
                            <th>Servicio </th>
                            <th>Socio </th>
                            <th>Campo </th>
                            <th>estado </th>
                        </tr>
                        <c:forEach var="item" items="${alquileres}">
                            <tr>
                                <td> <c:out value="${item.horaInicio}"/></td>
                                <td> <c:out value="${item.horaFin}"/></td>
                                <td> <c:out value="${item.dia}"/></td>
                                <td> <c:out value="${item.servicios}"/></td>

                                <td> <c:out value="${item.socio.persona.nombres}"/></td>
                                <td> <c:out value="${item.campo.descripcion}"/></td>
                                <td>
                                    <c:if test="${item.estado == 1}">
                                        <label class="label label-success"><c:out value="Activo"/> </label>
                                    </c:if>
                                    <c:if test="${item.estado != 1}">
                                        <label class="label label-warning"><c:out value="Inactivo"/> </label>
                                    </c:if>
                                </td>
                                <td> 
                                    <div class="btn-group">
                                        <a class="dropdown-toggle" data-toggle="dropdown" role="menu"  href="#">
                                          <i class="icon-cog"></i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li>
                                                <a href="<%=contextPath%>/socio/alquiler/update/${item.id}">Editar<a>
                                            </li>
                                            <li>
                                                <a href="<%=contextPath%>/socio/alquiler/delete/${item.id}">Eliminar<a>
                                            </li>
                                        </ul>
                                      </div>
                                </td>
                            </tr>
                        </c:forEach>

                    </table>
                </div>
            </div>
        </div>

        <%@include file="/public/footer.jsp" %>
    </body>
</html>
