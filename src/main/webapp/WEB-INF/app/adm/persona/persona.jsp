<%-- 
    Document   : persona
    Created on : 29-nov-2013, 21:59:15
    Author     : saravia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Persona </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <%@include file="/public/header.jsp" %>
    </head>
    <body>
        <%@include file="/public/menuGeneral.jsp" %>

        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="/public/menuAdm.jsp" %>
                <div class="span9">
                    <div class="row">
                        <a class="btn btn-primary pull-right" 
                           href="<%=contextPath%>/adm/persona/new"> Nuevo </a>

                    </div>

                    <table class="table table-hover">
                        <h1> Personas </h1>
                        <tr>
                            <th class="span3">Nombres</th>
                            <th>Direccion</th>
                            <th>Email</th>
                            <th>Celular</th>
                            <th>Sexo</th>
                            <th> </th>
                        </tr>
                        <c:forEach var="serv" items="${personas}">
                            <tr>
                                <td><c:out value="${serv.paterno}" /></td>
                                <td><c:out value="${serv.direccion}"/></td>
                                <td><c:out value="${serv.email}"/></td>
                                <td><c:out value="${serv.celular}"/></td>
                                <td><c:out value="${serv.sexo}"/></td>
                                <td>


                                </td>
                                <td>
                                    <div class="btn-group">
                                        <a class="dropdown-toggle" data-toggle="dropdown" role="menu"  href="#">
                                            <i class="icon-cog"></i>
                                        </a>
                                        <ul class="dropdown-menu pull-right">
                                            <li>
                                                <a href="<%=contextPath%>/adm/persona/update/${serv.id}">
                                                    Editar</a>
                                            </li>
                                            <li>
                                                <a href="<%=contextPath%>/adm/persona/delete/${serv.id}">
                                                    Eliminar</a>
                                            </li>
                                        </ul>
                                    </div>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <hr>
        </div>
        <%@include file="/public/footer.jsp" %>
    </body>
</html>
