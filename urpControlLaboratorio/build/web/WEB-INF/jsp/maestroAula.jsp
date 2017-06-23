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
            <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Aulas</div>
            <div class="panel-body">
                <form class="form-horizontal" role="form">
                    <div class="well">
                        <div class="form-group">
                            <table class="table table-hover">
                                <thead>
                                  <th>
                                      <button type="button" class="btn-sm btn-success" id="btnNuevo">
                                          <a style="color:white" href="<c:url value="insertarAula.htm"/>">
                                              <span class="glyphicon glyphicon-plus"></span>
                                          </a>
                                      </button>                                      
                                      &nbsp;&nbsp;Aula
                                  </th>
                                  <th>PC Asociada</th>
                                  <th>Opciones</th>
                                </thead>
                                <tbody>
                                    <c:forEach items="${model.aulas}" var="aula">
                                        <tr><td><c:out value="${aula.id}"/></td>
                                            <td><c:out value="${aula.pc}"/></td>
                                            <td>
                                                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarAula.htm?id=${aula.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                                                <button type="button" class="btn-sm btn-danger btnEliminar" ><a style="color:white" href="<c:url value="eliminarAula.htm?id=${aula.id}" />"><span class="glyphicon glyphicon-remove"></span></a></button>
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