<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<script src="bootbox-4.4.0.js" type="text/javascript"></script>
<script src="laboratorio.js" type="text/javascript"></script>
<html>
<head>
  <title>Control de Laboratorio URP</title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
    <div class="container">
        
        <div class="panel panel-primary">
            <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Cursos x Semestre</div>
            <div class="panel-body">
                
                    <div class="well">
                        <div class="form-group">
                            <table class="table table-hover">
                         
                                <thead>
                                 
                                  <tr>
                                    <th colspan="6">
                                        <form:form method="post" commandName="model" action="addCursoSemestre.htm">
                                        <table>
                                            
                                            <tr>
                       
                                                <td>Año</td>
                                                <td>
                                                    
                                                    <select name="selAnio" class="form-control" path="selAnio">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.anios}" var="anio">
                                                            <option value="${anio.id}">${anio.id}</option>
                                                        </c:forEach>
                                                    </select>
                                                    
                                                </td>
                                                <td style="width:100px;"></td>
                                                
                                                <td>Semestre</td>
                                                <td>
                                                    <select name="selSemestre" class="form-control" path="selSemestre">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.semestres}" var="semestre">
                                                            <option value="${semestre.descripcion}">${semestre.descripcion}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                
                                                <td style="width:50px;"></td>
                                                
                                                <td>
                                                    <!--<button type="button" class="btn-sm btn-success" id="btnNuevo">
                                                        <a style="color:white" href="<c:url value="insertarCursoSemestre.htm?id=${semestre.id}"/>">
                                                            <span class="glyphicon glyphicon-plus"></span>
                                                        </a>
                                                    </button>-->
                                                    
                                                    <input type="submit" class="form-control btn-primary" align="center" value="Add">        
                                                    
                                                </td>
                                                
                                            </tr>
                                            
                                        </table>
                                        </form:form>
                                        
                                    </th>
                                </tr>  
                                    
                                  <tr>  
                                    <th>                            
                                        &nbsp;&nbsp;Año
                                    </th>
                                    <th>Semestre</th>
                                    <th>Curso</th>
                                    <th>Grupo</th>
                                    <th>SubGrupo</th>
                                    <th>Profesor</th>
                                    <th colspan="2">Acciones</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${model.cursoSemestres}" var="cursoSemestre">
                                        <tr><td><c:out value="${cursoSemestre.id_anio}"/></td>
                                            <td><c:out value="${cursoSemestre.id_semestre}"/></td>
                                            <td><c:out value="${cursoSemestre.id_curso}"/></td>
                                            <td><c:out value="${cursoSemestre.id_grupo}"/></td>
                                            <td><c:out value="${cursoSemestre.id_subgrupo}"/></td>
                                            <td><c:out value="${cursoSemestre.id_docente}"/></td>
                                            <td style="width: 20px;">
                                                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarCursoSemestre.htm?id=${cursoSemestre.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                                            </td>
                                            <td style="width: 20px;">
                                                <div id="del" class="divEliminarCursoSemestre" title="${cursoSemestre.id}">
                                                    <button type="button" class="btn-sm btn-danger btnEliminar" ><a href="#" style="color:white"><span class="glyphicon glyphicon-remove"></span></a></button>
                                                    
                                                </div>
                                           </td>
                                        </tr>       
                                    </c:forEach>
                                </tbody>      
                            </table>
                            <br>                            
                        </div>
                    </div>
               
            </div>
        </div>
        
                
        
    </div>

  

</body>
</html>