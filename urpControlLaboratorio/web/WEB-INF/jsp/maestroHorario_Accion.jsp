
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

    </tr>

    <c:forEach items="${model.horarios}" var="horario">
        <tr>
            <td><c:out value="${horario.rep_horaInicio}"/></td>
            <td><c:out value="${horario.rep_horaFin}"/></td>
            <td><c:out value="${horario.rep_lunes}"/></td>
            <td><c:out value="${horario.rep_martes}"/></td>
            <td><c:out value="${horario.rep_miercoles}"/></td>
            <td><c:out value="${horario.rep_jueves}"/></td>
            <td><c:out value="${horario.rep_viernes}"/></td>
            <td><c:out value="${horario.rep_sabado}"/></td>
            
        </tr>       
    </c:forEach>

</table>