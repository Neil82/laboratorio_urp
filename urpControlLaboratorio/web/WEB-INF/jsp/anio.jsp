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
                    <li><a href="<c:url value="/maestroAnio.htm" />">Volver</a></li>
                </ol>
                
                <div class="panel panel-primary panel-success">
                    <div class="panel-heading"><span class="glyphicon glyphicon-calendar"></span> &nbsp;&nbsp;<c:out value="${model.tipoAccion}"/></div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="well">  
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Año</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                                <form:input class="form-control" path="anio"/>
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Descripción</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-pencil"></span></span>
                                                <form:input class="form-control" path="descripcion"/>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <input type="submit" class="form-control btn-primary" align="center" value="${model.botonAccion}">                                        
                                    </div>
                                        
                                </div>
                                 
                                <div class="row">
                                    <br/>
                                    <div id="msgerror" class="text-warning">${model.msgError}</div>
                                    
                                    <div class="col-md-4">
                                        <form:errors path="id" cssClass="error"/>   
                                        <form:errors path="descripcion" cssClass="error"/>
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