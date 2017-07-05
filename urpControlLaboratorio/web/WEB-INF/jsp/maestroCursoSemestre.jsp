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
                                                    
                                                    <select name="selAnio" id="selAnio" class="form-control" onChange="showCursoSemestre()">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.anios}" var="anio">
                                                            <option value="${anio.id}">${anio.id}</option>
                                                        </c:forEach>
                                                    </select>
                                                    
                                                </td>
                                                <td style="width:100px;"></td>
                                                
                                                <td>Semestre</td>
                                                <td>
                                                    <select name="selSemestre" id="selSemestre" class="form-control" onChange="showCursoSemestre()">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.semestres}" var="semestre">
                                                            <option value="${semestre.id}">${semestre.descripcion}</option>
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
                                    
                                  
                                </thead>
                               
                        
                            </table>
                                                  
                        </div>
                        
                        <div id="txtHint"><b></b></div> 
                    </div>
                 
            </div>
            
        </div>
        
             
        
    </div>

  

</body>
</html>