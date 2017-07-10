
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>


<table class="table table-hover">
    <tr>  
      <th>&nbsp;&nbsp;Hora Inicio</th>
      <th>Hora Fin</th>
      <th>Lunes</th>
      <th>Martes</th>
      <th>Miércoles</th>
      <th>Jueves</th>
      <th>Viernes</th>
      <th>Sábado</th>
      <th>Opciones</th>
    </tr>

    <c:forEach items="${model.horarios}" var="horario">
        <tr>
            <td><c:out value="${horario.id_anio}"/></td>
            <td><c:out value="${horario.id_semestre}"/></td>
            <td><c:out value="${horario.id_aula}"/></td>
            <td><c:out value="${horario.id_dia}"/></td>
            <td><c:out value="${horario.id_hinicio}"/></td>
            <td><c:out value="${horario.id_duracion}"/></td>
            <td><c:out value="${horario.id_cursosemestre}"/></td>
            <td>
                <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarHorario.htm?id=${horario.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
                <button type="button" class="btn-sm btn-danger btnEliminar" ><a style="color:white" href="<c:url value="eliminarHorario.htm?id=${horario.id}" />"><span class="glyphicon glyphicon-remove"></span></a></button>
            </td>
        </tr>       
    </c:forEach>

</table>