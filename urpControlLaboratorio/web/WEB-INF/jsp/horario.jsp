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
        <form:form method="post" commandName="model"  action="insertarHorario.htm">
            <div class="container">
                
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/maestroHorario.htm" />">Volver<a></li>
                </ol>
                
                <div class="panel panel-primary">
                    <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Ingresar Horario</div>
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
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_semestre" >
                                                    <form:options items="${model.listSemestre}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
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
                                                    <form:options items="${model.listAula}"  
                                                    itemValue="id"
                                                    itemLabel="id"/>
                                                 </form:select>
                                            
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Día</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_dia" >
                                                    <form:options items="${model.listDia}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
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
                                                    <form:options items="${model.listHora}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
                                                 </form:select>
                                            
                                        </div>
                                    </div>
                                                
                                    <label class="control-label col-md-2" style="text-align: right">Duración</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:select class="form-control" path="id_duracion" >
                                                    <form:options items="${model.listDuracion}"  
                                                    itemValue="id"
                                                    itemLabel="descripcion"/>
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
                                                    <form:options items="${model.listCursoSemestre}"  
                                                    itemValue="id"
                                                    itemLabel="cursoDocente"/>
                                                 </form:select>
                                            
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-2">
                                        <input type="submit" class="form-control btn-primary" align="center" value="Ingresar">                                        
                                    </div>
                                        
                                </div>                 
                                 
                                <div class="row">
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