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
        <form:form method="post" commandName="model" action="insertarCursoSemestre.htm">
            <div class="container">
                
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/maestroCursoSemestre.htm" />">Volver<a></li>
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
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                                
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
                                    <label class="control-label col-md-2" style="text-align: right">Curso</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                              
                                                <form:select class="form-control" path="id_curso" >
                                                    
                                                    <c:forEach items="${model.listCurso}" var="lcurso">
                                                    <c:choose>
                                                        <c:when test="${lcurso.id == model.selCurso}">
                                                            <option value="${lcurso.id}" selected>${lcurso.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lcurso.id}" >${lcurso.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                                
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Grupo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                              
                                                <form:select class="form-control" path="id_grupo" >
                                                    
                                                    <c:forEach items="${model.listGrupo}" var="lgrupo">
                                                    <c:choose>
                                                        <c:when test="${lgrupo.id == model.selGrupo}">
                                                            <option value="${lgrupo.id}" selected>${lgrupo.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lgrupo.id}" >${lgrupo.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                               
                                        </div>
                                    </div>
                                                
                                </div>
                                
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">SubGrupo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                            
                                                <form:select class="form-control" path="id_subgrupo" >
                                                    
                                                    <c:forEach items="${model.listSubGrupo}" var="lsubgrupo">
                                                    <c:choose>
                                                        <c:when test="${lsubgrupo.id == model.selSubgrupo}">
                                                            <option value="${lsubgrupo.id}" selected>${lsubgrupo.descripcion}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${lsubgrupo.id}" >${lsubgrupo.descripcion}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                               
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Docente</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                            
                                                <form:select class="form-control" path="id_docente" >
                                                    
                                                    <c:forEach items="${model.listDocente}" var="ldocente">
                                                    <c:choose>
                                                        <c:when test="${ldocente.id == model.selDocente}">
                                                            <option value="${ldocente.id}" selected>${ldocente.docente_nom}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${ldocente.id}" >${ldocente.docente_nom}</option>
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
                                    <div class="col-md-4">
                                        <form:errors path="id" cssClass="error"/>   
                                        <form:errors path="id_anio" cssClass="error"/>
                                        <form:errors path="id_semestre" cssClass="error"/>
                                        <form:errors path="id_curso" cssClass="error"/>
                                        <form:errors path="id_grupo" cssClass="error"/>
                                        <form:errors path="id_subgrupo" cssClass="error"/>
                                        <form:errors path="id_docente" cssClass="error"/>
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