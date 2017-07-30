
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

    <c:set var="rep_lunes_dur_X" value="0" scope = "session" /> 
    <c:set var="rep_martes_dur_X" value="0" scope = "session" /> 
    <c:set var="rep_miercoles_dur_X" value="0" scope = "session" /> 
    <c:set var="rep_jueves_dur_X" value="0" scope = "session" /> 
    <c:set var="rep_viernes_dur_X" value="0" scope = "session" /> 
    <c:set var="rep_sabado_dur_X" value="0" scope = "session" /> 
    
    <c:forEach items="${model.horarios}" var="horario">
        
        <c:set var="rep_horaInicio" value="${horario.rep_horaInicio}" />  
        <c:set var="rep_horaFin" value="${horario.rep_horaFin}" /> 
        
        <c:set var="rep_lunes" value="${horario.rep_lunes}" />  
        <c:set var="rep_lunes_dur" value="${horario.rep_lunes_dur}" />  
        <c:set var="rep_lunes_doc" value="${horario.rep_lunes_docente}" />  
        <c:set var="rep_lunes_grupo" value="${horario.rep_lunes_grupo}" />  
        
        <c:set var="rep_martes" value="${horario.rep_martes}" />
        <c:set var="rep_martes_dur" value="${horario.rep_martes_dur}" />
        <c:set var="rep_martes_doc" value="${horario.rep_martes_docente}" />
        <c:set var="rep_martes_grupo" value="${horario.rep_martes_grupo}" />
        
        <c:set var="rep_miercoles" value="${horario.rep_miercoles}" />  
        <c:set var="rep_miercoles_dur" value="${horario.rep_miercoles_dur}" />  
        <c:set var="rep_miercoles_doc" value="${horario.rep_miercoles_docente}" />   
        <c:set var="rep_miercoles_grupo" value="${horario.rep_miercoles_grupo}" />   
        
        <c:set var="rep_jueves" value="${horario.rep_jueves}" />
        <c:set var="rep_jueves_dur" value="${horario.rep_jueves_dur}" />
        <c:set var="rep_jueves_doc" value="${horario.rep_jueves_docente}" />
        <c:set var="rep_jueves_doc" value="${horario.rep_jueves_grupo}" />
        
        <c:set var="rep_viernes" value="${horario.rep_viernes}" /> 
        <c:set var="rep_viernes_dur" value="${horario.rep_viernes_dur}" /> 
        <c:set var="rep_viernes_grupo" value="${horario.rep_viernes_docente}" /> 
        
        <c:set var="rep_sabado" value="${horario.rep_sabado}" />  
        <c:set var="rep_sabado_dur" value="${horario.rep_sabado_dur}" />  
        <c:set var="rep_sabado_doc" value="${horario.rep_sabado_docente}" />  
        <c:set var="rep_sabado_grupo" value="${horario.rep_sabado_grupo}" />  
        
        <c:set var="rep_duracion" value="${horario.rep_sabado}" />  
        <c:set var="rep_duracion_dur" value="${horario.rep_sabado_dur}" />  
        <c:set var="rep_duracion_doc" value="${horario.rep_sabado_docente}" />  
        <c:set var="rep_duracion_grupo" value="${horario.rep_sabado_grupo}" />  
          
        <c:choose>
            <c:when test="${rep_lunes_dur_X == 0}">
                
                <c:set var="rep_lunes_ok" value="${horario.rep_lunes}" />  
                <c:set var="rep_lunes_dur_ok" value="${horario.rep_lunes_dur}" />  
                <c:set var="rep_lunes_doc_ok" value="${horario.rep_lunes_docente}" /> 
                <c:set var="rep_lunes_gru_ok" value="${horario.rep_lunes_grupo}" /> 
                
                <c:set var="rep_lunes" value="${rep_lunes_ok}" />  
                <c:set var="rep_lunes_dur" value="${rep_lunes_dur_ok}" />  
                <c:set var="rep_lunes_doc" value="${rep_lunes_doc_ok}" />  
                <c:set var="rep_lunes_gru" value="${rep_lunes_gru_ok}" />  
                
                <c:set var="rep_lunes_dur_X" value="${rep_lunes_dur_ok - 1}" />  
                
            </c:when>
           
            <c:otherwise>
                <c:set var="rep_lunes" value="${rep_lunes_ok}" />  
                <c:set var="rep_lunes_dur" value="${rep_lunes_dur_ok}" />  
                <c:set var="rep_lunes_doc" value="${rep_lunes_doc_ok}" />  
                <c:set var="rep_lunes_gru" value="${rep_lunes_gru_ok}" />  
                
                <c:set var="rep_lunes_dur_X" value="${rep_lunes_dur_X - 1}" />  
                
            </c:otherwise>
        </c:choose>
        
        <c:choose>
            <c:when test="${rep_martes_dur_X == 0}">
                
                <c:set var="rep_martes_ok" value="${horario.rep_martes}" />  
                <c:set var="rep_martes_dur_ok" value="${horario.rep_martes_dur}" />  
                <c:set var="rep_martes_doc_ok" value="${horario.rep_martes_docente}" />
                <c:set var="rep_martes_gru_ok" value="${horario.rep_martes_grupo}" />
                
                <c:set var="rep_martes" value="${rep_martes_ok}" />  
                <c:set var="rep_martes_dur" value="${rep_martes_dur_ok}" />  
                <c:set var="rep_martes_doc" value="${rep_martes_doc_ok}" />  
                <c:set var="rep_martes_gru" value="${rep_martes_gru_ok}" />  
                
                <c:set var="rep_martes_dur_X" value="${rep_martes_dur_ok - 1}" />  
                
            </c:when>
           
            <c:otherwise>
                <c:set var="rep_martes" value="${rep_martes_ok}" />  
                <c:set var="rep_martes_dur" value="${rep_martes_dur_ok}" />  
                <c:set var="rep_martes_doc" value="${rep_martes_doc_ok}" />  
                <c:set var="rep_martes_gru" value="${rep_martes_gru_ok}" />  
                
                <c:set var="rep_martes_dur_X" value="${rep_martes_dur_X - 1}" />  
                
            </c:otherwise>
        </c:choose>

        
        <c:choose>
            <c:when test="${rep_miercoles_dur_X == 0}">
                
                <c:set var="rep_miercoles_ok" value="${horario.rep_miercoles}" />  
                <c:set var="rep_miercoles_dur_ok" value="${horario.rep_miercoles_dur}" />  
                <c:set var="rep_miercoles_doc_ok" value="${horario.rep_miercoles_docente}" /> 
                <c:set var="rep_miercoles_gru_ok" value="${horario.rep_miercoles_grupo}" /> 
                
                <c:set var="rep_miercoles" value="${rep_miercoles_ok}" />  
                <c:set var="rep_miercoles_dur" value="${rep_miercoles_dur_ok}" />  
                <c:set var="rep_miercoles_doc" value="${rep_miercoles_doc_ok}" /> 
                <c:set var="rep_miercoles_gru" value="${rep_miercoles_gru_ok}" /> 
                
                <c:set var="rep_miercoles_dur_X" value="${rep_miercoles_dur_ok - 1}" />  
                
            </c:when>
           
            <c:otherwise>
                <c:set var="rep_miercoles" value="${rep_miercoles_ok}" />  
                <c:set var="rep_miercoles_dur" value="${rep_miercoles_dur_ok}" />  
                <c:set var="rep_miercoles_doc" value="${rep_miercoles_doc_ok}" />  
                <c:set var="rep_miercoles_gru" value="${rep_miercoles_gru_ok}" />  
                
                <c:set var="rep_miercoles_dur_X" value="${rep_miercoles_dur_X - 1}" />  
                
            </c:otherwise>
            
        </c:choose>
        
        
        
        <c:choose>
            <c:when test="${rep_jueves_dur_X == 0}">
                
                <c:set var="rep_jueves_ok" value="${horario.rep_jueves}" />  
                <c:set var="rep_jueves_dur_ok" value="${horario.rep_jueves_dur}" />  
                <c:set var="rep_jueves_doc_ok" value="${horario.rep_jueves_docente}" /> 
                <c:set var="rep_jueves_gru_ok" value="${horario.rep_jueves_grupo}" /> 
                
                <c:set var="rep_jueves" value="${rep_jueves_ok}" />  
                <c:set var="rep_jueves_dur" value="${rep_jueves_dur_ok}" />  
                <c:set var="rep_jueves_doc" value="${rep_jueves_doc_ok}" />  
                <c:set var="rep_jueves_gru" value="${rep_jueves_gru_ok}" />  
                
                <c:set var="rep_jueves_dur_X" value="${rep_jueves_dur_ok - 1}" />  
                
            </c:when>
           
            <c:otherwise>
                <c:set var="rep_jueves" value="${rep_jueves_ok}" />  
                <c:set var="rep_jueves_dur" value="${rep_jueves_dur_ok}" />  
                <c:set var="rep_jueves_doc" value="${rep_jueves_doc_ok}" /> 
                <c:set var="rep_jueves_gru" value="${rep_jueves_gru_ok}" /> 
                
                <c:set var="rep_jueves_dur_X" value="${rep_jueves_dur_X - 1}" />  
                
            </c:otherwise>
        </c:choose>
        
        
        
        <c:choose>
            <c:when test="${rep_viernes_dur_X == 0}">
                
                <c:set var="rep_viernes_ok" value="${horario.rep_viernes}" />  
                <c:set var="rep_viernes_dur_ok" value="${horario.rep_viernes_dur}" />  
                <c:set var="rep_viernes_doc_ok" value="${horario.rep_viernes_docente}" /> 
                <c:set var="rep_viernes_gru_ok" value="${horario.rep_viernes_grupo}" /> 
                
                <c:set var="rep_viernes" value="${rep_viernes_ok}" />  
                <c:set var="rep_viernes_dur" value="${rep_viernes_dur_ok}" />  
                <c:set var="rep_viernes_doc" value="${rep_viernes_doc_ok}" />  
                <c:set var="rep_viernes_gru" value="${rep_viernes_gru_ok}" />  
                
                <c:set var="rep_viernes_dur_X" value="${rep_viernes_dur_ok - 1}" />  
                
            </c:when>
           
            <c:otherwise>
                <c:set var="rep_viernes" value="${rep_viernes_ok}" />  
                <c:set var="rep_viernes_dur" value="${rep_viernes_dur_ok}" />  
                <c:set var="rep_viernes_doc" value="${rep_viernes_doc_ok}" /> 
                <c:set var="rep_viernes_gru" value="${rep_viernes_gru_ok}" /> 
                
                <c:set var="rep_viernes_dur_X" value="${rep_viernes_dur_X - 1}" />  
                
            </c:otherwise>
        </c:choose>
        
        
        
        <c:choose>
            <c:when test="${rep_sabado_dur_X == 0}">
                
                <c:set var="rep_sabado_ok" value="${horario.rep_sabado}" />  
                <c:set var="rep_sabado_dur_ok" value="${horario.rep_sabado_dur}" />  
                <c:set var="rep_sabado_doc_ok" value="${horario.rep_sabado_docente}" /> 
                <c:set var="rep_sabado_gru_ok" value="${horario.rep_sabado_grupo}" /> 
                
                <c:set var="rep_sabado" value="${rep_sabado_ok}" />  
                <c:set var="rep_sabado_dur" value="${rep_sabado_dur_ok}" />  
                <c:set var="rep_sabado_doc" value="${rep_sabado_doc_ok}" />  
                <c:set var="rep_sabado_gru" value="${rep_sabado_gru_ok}" />  
                
                <c:set var="rep_sabado_dur_X" value="${rep_sabado_dur_ok - 1}" />  
                
            </c:when>
           
            <c:otherwise>
                <c:set var="rep_sabado" value="${rep_sabado_ok}" />  
                <c:set var="rep_sabado_dur" value="${rep_sabado_dur_ok}" />  
                <c:set var="rep_sabado_doc" value="${rep_sabado_doc_ok}" />  
                <c:set var="rep_sabado_gru" value="${rep_sabado_gru_ok}" />  
                
                <c:set var="rep_sabado_dur_X" value="${rep_sabado_dur_X - 1}" />  
                
            </c:otherwise>
        </c:choose>
        
        
        <c:if test="${rep_lunes_dur_X <= 0}">
            <c:set var="rep_lunes_dur_X" value="0" /> 
        </c:if>
        <c:if test="${rep_martes_dur_X <= 0}">
            <c:set var="rep_martes_dur_X" value="0" /> 
        </c:if>
        <c:if test="${rep_miercoles_dur_X <= 0}">
            <c:set var="rep_miercoles_dur_X" value="0" /> 
        </c:if>
        <c:if test="${rep_jueves_dur_X <= 0}">
            <c:set var="rep_jueves_dur_X" value="0" /> 
        </c:if>
        <c:if test="${rep_viernes_dur_X <= 0}">
            <c:set var="rep_viernes_dur_X" value="0" /> 
        </c:if>
        <c:if test="${rep_sabado_dur_X <= 0}">
            <c:set var="rep_sabado_dur_X" value="0" /> 
        </c:if>
        
        
        <tr>
            <td style="vertical-align: middle"><c:out value="${rep_horaInicio}"/></td>
            <td style="vertical-align: middle"><c:out value="${rep_horaFin}"/></td>
            
            <td>
                <c:out value="${rep_lunes}"/><br/>
                <c:out value="${rep_lunes_doc}"/><br/>
                <c:out value="${rep_lunes_gru}"/>
            </td>
            
            <td>
                <c:out value="${rep_martes}"/><br/>
                <c:out value="${rep_martes_doc}"/><br/>
                <c:out value="${rep_martes_gru}"/>
            </td>
            
            <td>
                <c:out value="${rep_miercoles}"/><br/>
                <c:out value="${rep_miercoles_doc}"/><br/>
                <c:out value="${rep_miercoles_gru}"/>
            </td>
            
            <td>
                <c:out value="${rep_jueves}"/><br/>
                <c:out value="${rep_jueves_doc}"/><br/>
                <c:out value="${rep_jueves_gru}"/>
            </td>
            
            <td>
                <c:out value="${rep_viernes}"/><br/>
                <c:out value="${rep_viernes_doc}"/><br/>
                <c:out value="${rep_viernes_gru}"/>
            </td>
            
            <td>
                <c:out value="${rep_sabado}"/><br/>
                <c:out value="${rep_sabado_doc}"/><br/>
                <c:out value="${rep_sabado_gru}"/>
            </td>
            
        </tr>       
    </c:forEach>

</table>