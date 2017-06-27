<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="../js/maestroAula.js" type="text/javascript"></script>
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
            <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Horarios</div>
            <div class="panel-body">
                <form class="form-horizontal" role="form">
                    <div class="well">
                        <div class="form-group">
                            <table class="table table-hover">
                         
                                <thead>
                                 
                                  <tr>
                                    <th colspan="4">
                                        
                                        <table>
                                            
                                            <tr>
                                                <td>Aula</td>
                                                <td>
                                                
                                                    <select name="selAula" class="form-control">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.aulas}" var="aula">
                                                            <option value="${aula.id}">${aula.id}</option>
                                                        </c:forEach>
                                                    </select>

                                                </td>
                                                <td style="width:100px;"></td>
                                                <td>Año</td>
                                                <td>
                                                    
                                                    <select name="selAnio" class="form-control">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.anios}" var="anio">
                                                            <option value="${anio.id}">${anio.id}</option>
                                                        </c:forEach>
                                                    </select>
                                                    
                                                </td>
                                                <td style="width:100px;"></td>
                                                
                                                <td>Semestre</td>
                                                <td>
                                                    <select name="selSemestre" class="form-control">
                                                        <option value="-1">--Seleccione--</option>
                                                        <c:forEach items="${model.semestres}" var="semestre">
                                                            <option value="${semestre.descripcion}">${semestre.descripcion}</option>
                                                        </c:forEach>
                                                    </select>
                                                </td>
                                                
                                                <td style="width:50px;"></td>
                                                
                                                <td>
                                                    <button type="button" class="btn-sm btn-success" id="btnNuevo">
                                                        <a style="color:white" href="<c:url value="insertarHorario.htm"/>">
                                                            <span class="glyphicon glyphicon-plus"></span>
                                                        </a>
                                                    </button>
                                                </td>
                                                
                                            </tr>
                                            
                                        </table>
                                        
                                    </th>
                                </tr>  
                                    
                                  <tr>  
                                    <th>                            
                                        &nbsp;&nbsp;Id.Horario
                                    </th>
                                    <th>Nombres</th>
                                    <th>Apellidos</th>
                                    <th>Opciones</th>
                                  </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${model.horarios}" var="horario">
                                        <tr><td><c:out value="${horario.id}"/></td>
                                            <td><c:out value="${horario.nombres}"/></td>
                                            <td><c:out value="${horario.apellidos}"/></td>
                                            <td>
                                                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarHorario.htm?id=${horario.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                                                <button type="button" class="btn-sm btn-danger btnEliminar" ><a style="color:white" href="<c:url value="eliminarHorario.htm?id=${horario.id}" />"><span class="glyphicon glyphicon-remove"></span></a></button>
                                            </td>
                                        </tr>       
                                    </c:forEach>
                                </tbody>      
                            </table>
                            <br>                            
                        </div>
                    </div>
                </form>
            </div>
        </div>
        
                
        
    </div>

  

</body>
</html>