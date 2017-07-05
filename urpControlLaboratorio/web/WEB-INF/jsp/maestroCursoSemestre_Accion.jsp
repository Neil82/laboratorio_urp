
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>


<table class="table table-hover">
<tr>  
    <th>                            
        &nbsp;&nbsp;Año
    </th>
    <th>Semestre</th>
    <th>Curso</th>
    <th>Grupo</th>
    <th>SubGrupo</th>
    <th>Profesor</th>
    <th colspan="2">Acciones</th>
</tr>   
<c:forEach items="${model.cursoSemestres}" var="cursoSemestre">
    <tr><td><c:out value="${cursoSemestre.id_anio}"/></td>
        <td><c:out value="${cursoSemestre.id_semestre}"/></td>
        <td><c:out value="${cursoSemestre.id_curso}"/></td>
        <td><c:out value="${cursoSemestre.id_grupo}"/></td>
        <td><c:out value="${cursoSemestre.id_subgrupo}"/></td>
        <td><c:out value="${cursoSemestre.id_docente}"/></td>
        <td style="width: 20px;">
            <button type="button" class="btn-sm btn-primary btnEditar"><a style="color:white" href="<c:url value="editarCursoSemestre.htm?id=${cursoSemestre.id}" />"><span class="glyphicon glyphicon-pencil"></span></a></button>
        </td>
        <td style="width: 20px;">
            <div id="del" class="divEliminarCursoSemestre" title="${cursoSemestre.id}">
                <button type="button" class="btn-sm btn-danger btnEliminar" ><a href="#" style="color:white"><span class="glyphicon glyphicon-remove"></span></a></button>

            </div>
       </td>
    </tr>       
</c:forEach>
</table>
