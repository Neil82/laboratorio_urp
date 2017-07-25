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
            <div class="panel-heading"><span class="glyphicon glyphicon-blackboard"></span> &nbsp;&nbsp;Usuarios</div>
            <div class="panel-body">
                <form class="form-horizontal" role="form">
                    <div class="well">
                        <div class="form-group">
                            <table class="table table-hover">
                                <thead>
                                  <th>
                                      <button type="button" class="btn-sm btn-success" id="btnNuevo">
                                          <a style="color:white" href="<c:url value="insertarUsuario.htm"/>">
                                              <span class="glyphicon glyphicon-plus"></span>
                                          </a>
                                      </button>                                      
                                      &nbsp;&nbsp;Usuario
                                  </th>
                                  <th>DNI</th>
                                  <th>Nombres</th>
                                  <th>Apellidos</th>
                                  <th colspan="2">Opciones</th>
                                </thead>
                                <tbody>
                                    <c:forEach items="${model.usuarios}" var="usuario">
                                        <tr><td><c:out value="${usuario.usuario}"/></td>
                                            <td><c:out value="${usuario.dni}"/></td>
                                            <td><c:out value="${usuario.nombres}"/></td>
                                            <td><c:out value="${usuario.apellidos}"/></td>
                                          
                                            <td style="width: 20px;">
                                                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarUsuario.htm?idusuario=${usuario.idusuario}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                                            </td>
                                            <td style="width: 20px;">
                                                <div id="del" class="divEliminarUsuario" title="${usuario.idusuario}">
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