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
        <form:form method="post" commandName="model"  action="${model.accion}">
            <div class="container">
                
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/maestroHorario.htm" />">Volver<a></li>
                </ol>
                
                <div class="panel panel-primary panel-success">
                    <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;<c:out value="${model.tipoAccion}"/></div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="well">  
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Año</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                                
                                                <form:select class="form-control" path="id_anio" >
                                                    
                                                    <c:forEach items="${model.listAnio}" var="lanios">
                                                    <c:choose>
                                                        <c:when test="${lanios.id == model.selAnio}">
                                                            <option value="${lanios.id}" selected>${lanios.id}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lanios.id}" >${lanios.id}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                 </form:select>
                                                
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Semestre</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_semestre" >
                                                    
                                                    <c:forEach items="${model.listSemestre}" var="lsemestre">
                                                    <c:choose>
                                                        <c:when test="${lsemestre.id == model.selSemestre}">
                                                            <option value="${lsemestre.id}" selected>${lsemestre.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lsemestre.id}" >${lsemestre.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                        </div>
                                    </div>
                                                
                                </div>            
                                
                                <div class="row">                
                                    <label class="control-label col-md-2" style="text-align: right">Aula</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_aula" >
                                                    
                                                    <c:forEach items="${model.listAula}" var="lAula">
                                                    <c:choose>
                                                        <c:when test="${lAula.id == model.selAula}">
                                                            <option value="${lAula.id}" selected>${lAula.aula}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lAula.id}" >${lAula.aula}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                               
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Día</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_dia" >
                                                    
                                                    <c:forEach items="${model.listDia}" var="lDia">
                                                    <c:choose>
                                                        <c:when test="${lDia.id == model.selDia}">
                                                            <option value="${lDia.id}" selected>${lDia.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lDia.id}" >${lDia.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                                
                                        </div>
                                    </div>
                               
                                </div>
                                                
                                <div class="row">                
                                    <label class="control-label col-md-2" style="text-align: right">Hora Inicio</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_hinicio" >
                                                    
                                                    <c:forEach items="${model.listHora}" var="lHora">
                                                    <c:choose>
                                                        <c:when test="${lHora.id == model.selHoraInicio}">
                                                            <option value="${lHora.id}" selected>${lHora.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lHora.id}" >${lHora.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                                
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Duración</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_duracion" >
                                                    
                                                    <c:forEach items="${model.listDuracion}" var="lDuracion">
                                                    <c:choose>
                                                        <c:when test="${lDuracion.id == model.selDuracion}">
                                                            <option value="${lDuracion.id}" selected>${lDuracion.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lDuracion.id}" >${lDuracion.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                               
                                        </div>
                                    </div>
                           
                                </div> 
                                                
                                <div class="row">     
                                    
                                    <label class="control-label col-md-2" style="text-align: right">Curso/Profesor</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_cursosemestre" >
                                                    
                                                    <c:forEach items="${model.listCursoSemestre}" var="lCS">
                                                    <c:choose>
                                                        <c:when test="${lCS.id == model.selcursoSemestre}">
                                                            <option value="${lCS.id}" selected>${lCS.cursoDocente}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lCS.id}" >${lCS.cursoDocente}</option>
                                                        </c:otherwise>  
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                               
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
                                        <form:errors path="id_anio" cssClass="error"/>   
                                        <form:errors path="id_semestre" cssClass="error"/>
                                        <form:errors path="id_aula" cssClass="error"/>
                                        <form:errors path="id_dia" cssClass="error"/>
                                        <form:errors path="id_hinicio" cssClass="error"/>
                                        <form:errors path="id_duracion" cssClass="error"/>
                                        <form:errors path="id_cursosemestre" cssClass="error"/>
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