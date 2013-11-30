<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>TEST MVC</title>
        <meta http-equiv="content-Type" conent="text/html; charset=UTF-8">
        <%@include file="/public/header.jsp" %>
  
    </head>
    <body>
        <%@include file="/public/menuGeneral.jsp" %>
        
        <div class="container-fluid">
            <div class="row-fluid">
                <%@include file="/public/menuAdm.jsp" %>
                <div class="span9">
                    
                    <h1>FIRST DAY SPRING MVC</h1>
                    <p>${mensaje}</p>

                    <hr/>

                    <form  action="guardar" method="post">
                        <label> Nombres </label>
                        <input type="text" name="nombres"/>

                        <label> Apellidos </label>
                        <input type="text" name="apellidos"/>

                        <input type="submit"/>
                    </form>
                    
                </div>
            </div>
            <hr>
        </div>
        
        <%@include file="/public/footer.jsp" %>
    </body>
</html>
