
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>


<table class="table table-hover">
    <tr>  
      <th>&nbsp;&nbsp;Docente</th>
      <th>Aula</th>
      <th>Curso</th>
      <th>Semestre</th>
      <th>H. Inicio</th>
      <th>Tipo</th>
    </tr>
        
    <c:forEach items="${model.marcaciones}" var="marcacion">
        <tr>
            <td style="text-align: left;"><c:out value="${marcacion.docente}"/></td>
            <td style="text-align: left;"><c:out value="${marcacion.aula}"/></td>
            <td style="text-align: left;"><c:out value="${marcacion.curso}"/></td>
            <td><c:out value="${marcacion.semestre}"/></td>
            <td style="text-align: left;"><c:out value="${marcacion.inicio}"/></td>
            <td style="text-align: left;"><c:out value="${marcacion.tipo}"/></td>
           
            <td style="width: 20px;">
                <div id="del" class="divEliminarMarcacion" title="${marcacion.id_marcacion}">
                    <button type="button" class="btn-sm btn-danger btnEliminar" ><a href="#" style="color:white"><span class="glyphicon glyphicon-remove"></span></a></button>

                </div>
           </td>
        </tr>       
    </c:forEach>

</table>