<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
            <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Equipos</div>
            <div class="panel-body">
                <form class="form-horizontal" role="form">
                    <div class="well">
                        <div class="form-group">
                            <table class="table table-hover">
                                <thead>
                                  <th>
                                      <button type="button" class="btn-sm btn-success" id="btnNuevo">
                                          <a style="color:white" href="<c:url value="insertarEquipo.htm"/>">
                                              <span class="glyphicon glyphicon-plus"></span>
                                          </a>
                                      </button>                                      
                                      &nbsp;&nbsp;Equipo
                                  </th>
                                  <th>Procesador</th>
                                  <th>Velocidad GHz</th>
                                  <th>Mem. RAM</th>
                                  <th>Disco D</th>
                                  <th>Tarj. Video</th>
                                  <th>Aula</th>
                                  <th colspan="2">Opciones</th>
                                </thead>
                                <tbody>
                                    <c:forEach items="${model.equipos}" var="equipo">
                                        <tr>
                                            <td><c:out value="${equipo.eqnombre}"/></td>
                                            <td><c:out value="${equipo.procesador}"/></td>
                                            <td><c:out value="${equipo.velocidad}"/></td>
                                            <td><c:out value="${equipo.ram}"/></td>
                                            <td><c:out value="${equipo.disco_d}"/></td>
                                            <td><c:out value="${equipo.tvideo}"/></td>
                                            <td><c:out value="${equipo.idaula}"/></td>
                                            <td style="width: 20px;">
                                                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarEquipo.htm?id=${equipo.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                                            </td>
                                            <td style="width: 20px;">
                                                <div id="del" class="divEliminarEquipo" title="${equipo.id}">
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
                </form>
            </div>
        </div>
        
                
        
    </div>

  

</body>
</html>