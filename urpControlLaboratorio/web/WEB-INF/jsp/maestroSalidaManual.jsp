<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
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
            <div class="panel-heading"><span class="glyphicon glyphicon-hourglass"></span> &nbsp;&nbsp;Marcación Manual de Salida</div>
            <div class="panel-body">
                
                    <div class="well">
                        <div class="form-group">
                            <form:form method="post" commandName="model" action="addHorario.htm">
                            <table class="table table-hover">
                         
                                <thead>
                                 
                                  <tr>
                                    <th>
                                 
                                        <label class="control-label col-md-2" style="text-align: right">Código de Docente</label>
                                   
                                        <div class="col-md-3">
                                            <div class="input-group">
                                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                                    <form:input class="form-control" path="cod_docente" />

                                            </div>
                                        </div>

                                    </th>
                                    <th>
                                        <input type="button" class="form-control btn-primary" align="center" onclick="showMarcaciones()" value="Buscar" />
                                    </th>
                                </tr>  
                                    
                           
                                </thead>
                                
                            </table>
                           </form:form>
                                                    
                        </div>
                        <div id="txtHint"><b></b></div> 
                    </div>
                
            </div>
        </div>
        
                
        
    </div>

    <script>
        window.onload = function() {
           showMarcaciones();
        }
    </script>
        

</body>
</html>