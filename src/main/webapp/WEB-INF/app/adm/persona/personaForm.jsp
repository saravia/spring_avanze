<%-- 
    Document   : personaForm
    Created on : 29-nov-2013, 21:59:39
    Author     : saravia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title> Servicio </title>
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
                        <h1 class="span9 offset1"> Nueva Persona </h1>
                    </div>

                    <form action="<%=contextPath%>/adm/persona/save" method="POST" class="form-horizontal">

                        <input type="hidden" value="${persona.id}" name="id">

                        <div class="control-group">
                            <label class="control-label">Nombres</label>
                            <div class="controls">
                                <input type="text" name="nombres" value="${persona.nombres}">
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Apellido Paterno</label>
                            <div class="controls">
                                <input type="text" name="paterno" value="${persona.paterno}">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Apellido Materno</label>
                            <div class="controls">
                                <input type="text" name="materno" value="${persona.materno}">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Email</label>
                            <div class="controls">
                                <input type="text" name="email" value="${persona.email}">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label">Dirección</label>
                            <div class="controls">
                                <input type="text" name="direccion" value="${persona.direccion}">
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Sexo</label>
                            <div class="controls">
                                <input type="text" name="sexo" value="${persona.sexo}">
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label">Celular</label>
                            <div class="controls">
                                <input type="text" name="celular" value="${persona.celular}">
                            </div>
                        </div>

                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                                <a class="btn" href="<%=contextPath%>/adm/local">Cancelar</a>

                            </div>
                        </div>
                    </form>


                </div>
            </div>
            <hr>
        </div>
        <%@include file="/public/footer.jsp" %>
    </body>
</html>
