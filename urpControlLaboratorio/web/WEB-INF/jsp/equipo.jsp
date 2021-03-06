<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<html>
    <head>
        <meta charset="utf-8"/>
        <title>Control de Laboratorio URP</title>
        <style>
            .error { color: red; }
        </style>  
    </head>
    <body>
        <form:form method="post" commandName="model">
            <div class="container">
                
                <ol class="breadcrumb">
                    <li><a href="<c:url value="/maestroEquipo.htm" />">Volver</a></li>
                </ol>
                
                <div class="panel panel-primary panel-success">
                    <div class="panel-heading"><span class="glyphicon glyphicon-list"></span> &nbsp;&nbsp;<c:out value="${model.tipoAccion}"/></div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="well">
                                
                                
                                
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Equipo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-list"></span></span>
                                                <form:input class="form-control" path="eqnombre"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Aula</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-blackboard"></span></span>
                                            
                                                <form:select class="form-control" path="idaula" >
                                                    
                                                    <c:forEach items="${model.listAula}" var="laula">
                                                    <c:choose>
                                                        <c:when test="${laula.id == model.selAula}">
                                                            <option value="${laula.id}" selected>${laula.aula}</option>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <option value="${laula.id}" >${laula.aula}</option>
                                                        </c:otherwise> 
                                                    </c:choose> 
                                                    </c:forEach>
                                                    
                                                </form:select>
                                               
                                        </div>
                                    </div>
                                   
                                </div>
                                                
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">CPU Marca</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="cpu_marca"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">CPU Modelo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="cpu_modelo"/>
                                            
                                        </div>
                                    </div>

                                </div> 
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">CPU Serie</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="cpu_serie"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Procesador</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                           <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="procesador"/>
                                            
                                        </div>
                                    </div>
                                   
                                </div>
                                                
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Velocidad GHz</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="velocidad"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Memoria RAM</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="ram"/>
                                            
                                        </div>
                                    </div>

                                </div> 
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Total HDD</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-hdd"></span></span>
                                                <form:input class="form-control" path="disco_d"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Tarj. Video</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="tvideo"/>
                                            
                                        </div>
                                    </div>
                                        
                                </div>  
                                                
                               
                                                
                                                
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right"></label>
                                </div>
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: left">Monitor</label>
                                </div>
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Marca</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="monitor_marca"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Modelo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="monitor_modelo"/>
                                            
                                        </div>
                                    </div>
                                </div>  
                                            
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Serie</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="monitor_serie"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right"></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            
                                        </div>
                                    </div>   
                                </div>   
                                                
                                                
                                                
                         
                                                
                                <div class="row">
                                </div>
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: left">Teclado</label>
                                </div>
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Marca</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="teclado_marca"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Modelo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="teclado_modelo"/>
                                            
                                        </div>
                                    </div>
                                </div>  
                                            
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Serie</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="teclado_serie"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right"></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            
                                        </div>
                                    </div>   
                                </div> 
                                                
                                                
                                                
                                                
                                                
              
                                                
                                <div class="row">
                                </div>
                                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: left">Mouse</label>
                                </div>
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Marca</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="mouse_marca"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Modelo</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-saved"></span></span>
                                                <form:input class="form-control" path="mouse_modelo"/>
                                            
                                        </div>
                                    </div>
                                </div>  
                                            
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Serie</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="mouse_serie"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right"></label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            
                                        </div>
                                    </div>   
                                    
                                    <div class="col-md-2">
                                        <input type="submit" class="form-control btn-primary" align="center" value="${model.botonAccion}">                                        
                                    </div>
                                </div>                  
                                 
                                <div class="row">
                                    <br/>
                                    <div id="msgerror" class="text-warning">${model.msgError}</div>
                                    
                                    <div class="col-md-4">
                                        <form:errors path="eqnombre" cssClass="error"/>   
                                        <form:errors path="cpu_marca" cssClass="error"/>   
                                        <form:errors path="cpu_modelo" cssClass="error"/>   
                                        <form:errors path="cpu_serie" cssClass="error"/>   
                                        <form:errors path="procesador" cssClass="error"/>
                                        <form:errors path="velocidad" cssClass="error"/>
                                        <form:errors path="ram" cssClass="error"/>
                                        <form:errors path="disco_d" cssClass="error"/>
                                        <form:errors path="tvideo" cssClass="error"/>
                                        <form:errors path="idaula" cssClass="error"/>
                                        
                                        <form:errors path="monitor_marca" cssClass="error"/>   
                                        <form:errors path="monitor_modelo" cssClass="error"/>   
                                        <form:errors path="monitor_serie" cssClass="error"/>   
                                        
                                        <form:errors path="teclado_marca" cssClass="error"/>   
                                        <form:errors path="teclado_modelo" cssClass="error"/>   
                                        <form:errors path="teclado_serie" cssClass="error"/>   
                                        
                                        <form:errors path="mouse_marca" cssClass="error"/>   
                                        <form:errors path="mouse_modelo" cssClass="error"/>   
                                        <form:errors path="mouse_serie" cssClass="error"/>   
                                    </div>
                                </div>
                                
                                
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </form:form>
        
</body>
</html>