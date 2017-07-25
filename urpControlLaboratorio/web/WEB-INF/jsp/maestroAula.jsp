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
                                      &nbsp;&nbsp;Item
                                  </th>
                                  <th>Aula</th>
                                  <th>Equipo Asociado</th>
                                  <th>Marca Equipo</th>
                                  <th>Procesador</th>
                                  <th colspan="2">Opciones</th>
                                </thead>
                                <tbody>
                                    <c:set var="item" value="0" /> 
                                    <c:forEach items="${model.aulas}" var="aula">
                                        <c:set var="item" value="${item+1}" /> 
                                        
                                        <tr><td><c:out value="${item}"/></td>
                                            <td><c:out value="${aula.aula}"/></td>
                                            <td><c:out value="${aula.equipo}"/></td>
                                            <td><c:out value="${aula.marca}"/></td>
                                            <td><c:out value="${aula.procesador}"/></td>
                                            <td style="width: 20px;">
                                                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarAula.htm?id=${aula.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                                            </td>
                                            <td style="width: 20px;">
                                                <div id="del" class="divEliminarAula" title="${aula.id}">
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