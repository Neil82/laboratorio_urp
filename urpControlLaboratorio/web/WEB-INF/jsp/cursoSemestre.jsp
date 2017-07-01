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
                
                <div class="panel panel-primary">
                    <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Cursos x Semestre</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="well">  
                                
                                <div class="row">
                                    
                                    <label class="control-label col-md-2" style="text-align: right">Año</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                              
                                                 <form:select class="form-control" path="id_anio" >
                                                    <form:options items="${model.listAnio}"  
                                                    itemValue="id"
                                                    itemLabel="id"/>
                                                 </form:select>
                                        </div>
                                    </div>
                                                
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Semestre</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                              
                                                 <form:select class="form-control" path="id_semestre" >
                                                    <form:options items="${model.listSemestre}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
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
                                                    <form:options items="${model.listCurso}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
                                                 </form:select>
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Grupo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                              
                                                 <form:select class="form-control" path="id_grupo" >
                                                    <form:options items="${model.listGrupo}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
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
                                                    <form:options items="${model.listSubGrupo}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
                                                 </form:select>
                                               
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Docente</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                              <form:select class="form-control" path="id_docente" >
                                                    <form:options items="${model.listDocente}"  
                                                    itemValue="id"
                                                    itemLabel="docente_nom"/>
                                                 </form:select>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-2">
                                        <input type="submit" class="form-control btn-primary" align="center" value="Ingresar">                                        
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