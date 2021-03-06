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
        
        <div class="panel panel-primary panel-success">
            <div class="panel-heading"><span class="glyphicon glyphicon-calendar"></span> &nbsp;&nbsp;Horarios</div>
            <div class="panel-body">
                
                    <div class="well">
                        <div class="form-group">
                            <form:form method="post" commandName="model" action="addHorario.htm" onsubmit="return validarAdddHorario(this)">
                            <table class="table table-hover">
                         
                                <thead>
                                 
                                  <tr>
                                    <th colspan="9">
                                        
                                        <table>
                                            
                                            <tr>
                                                <td>Aula&nbsp;&nbsp;</td>
                                                <td>
                                                
                                                    <select name="selAula" id="selAula" class="form-control" onChange="showHorario()">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.listAula}" var="aula">
                                                            <c:choose>
                                                                <c:when test="${aula.id == model.selAula}">
                                                                    <option value="${aula.id}" selected>${aula.aula}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${aula.id}" >${aula.aula}</option>
                                                                </c:otherwise> 
                                                            </c:choose> 
                                                        </c:forEach>
                                                       
                                                    </select>

                                                </td>
                                                <td style="width:100px;"></td>
                                                <td>Año&nbsp;&nbsp;</td>
                                                <td>
                                                    
                                                    <select name="selAnio" id="selAnio" class="form-control" onChange="showHorario()">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.listAnio}" var="anio">
                                                            <c:choose>
                                                                <c:when test="${anio.id == model.selAnio}">
                                                                    <option value="${anio.id}" selected>${anio.anio}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${anio.id}" >${anio.anio}</option>
                                                                </c:otherwise> 
                                                            </c:choose> 
                                                        </c:forEach>
                                                       
                                                    </select>
                                                    
                                                </td>
                                                <td style="width:100px;"></td>
                                                
                                                <td>Semestre&nbsp;&nbsp;</td>
                                                <td>
                                                    <select name="selSemestre" id="selSemestre" class="form-control" onChange="showHorario()">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.listSemestre}" var="semestre">
                                                            <c:choose>
                                                                <c:when test="${semestre.id == model.selSemestre}">
                                                                    <option value="${semestre.id}" selected>${semestre.descripcion}</option>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <option value="${semestre.id}" >${semestre.descripcion}</option>
                                                                </c:otherwise> 
                                                            </c:choose> 
                                                        </c:forEach>
                                                   
                                                    </select>
                                                </td>
                                                
                                                <td style="width:50px;"></td>
                                                
                                                <td>
                                                   
                                                    
                                                    <input type="submit" class="form-control btn-primary" align="center" value="+">
                                                </td>
                                                
                                            </tr>
                                            
                                        </table>
                                    
                                    </th>
                                </tr>  
                                    
                           
                                </thead>
                                
                            </table>
                           </form:form>
                                                    
                        </div>
                        <div id="txtHint"><b></b></div> 
                    </div>
                
            </div>
        </div>
        
                
        
    </div>

    <script>
        window.onload = function() {
           showHorario();
        }
    </script>
        

</body>
</html>