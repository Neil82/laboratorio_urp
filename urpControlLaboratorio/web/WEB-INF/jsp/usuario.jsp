<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <meta charset="utf-8"/>
        <title>Control de Laboratorio URP</title>
        <style>
            .error { color: red; }
        </style>  
    </head>
    <body>
        <form:form method="post" commandName="model">
            <div class="container">
                
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/maestroUsuario.htm" />">Volver<a></li>
                </ol>
                
                <div class="panel panel-primary panel-success">
                    <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Ingresar Usuario</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="well">  
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">DNI</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                                <form:input class="form-control" path="dni"/>
                                                
                                        </div>
                                    </div>
                                                
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Usuario</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="usuario"/>
                                            
                                        </div>
                                    </div>  
                                </div>
                                                
                                                
                                <div class="row">                
                                    <label class="control-label col-md-2" style="text-align: right">Nombres</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="nombres"/>
                                            
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Apellidos</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="apellidos"/>
                                            
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="row">                
                                    <label class="control-label col-md-2" style="text-align: right">Password</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:password class="form-control" path="password"/>
                                            
                                        </div>
                                    </div>
                                                
                                    <div class="col-md-2">
                                        <input type="submit" class="form-control btn-primary" align="center" value="Ingresar">                                        
                                    </div>
                                        
                                </div>
                                 
                                <div class="row">
                                    <div class="col-md-4">
                                        <form:errors path="dni" cssClass="error"/>   
                                        <form:errors path="usuario" cssClass="error"/>
                                        <form:errors path="nombres" cssClass="error"/>
                                        <form:errors path="apellidos" cssClass="error"/>
                                        <form:errors path="password" cssClass="error"/>
                                    </div>
                                </div>
                                
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </form:form>





        
</body>
</html>