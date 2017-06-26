<%@ include file="/WEB-INF/jsp/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<html>
    <head>
        <title><fmt:message key="title"/></title>
        <style>
            .error { color: red; }
        </style>  
    </head>
    <body>
        <form:form method="post" commandName="model">
            <div class="container">
                <div class="panel panel-primary">
                    <div class="panel-heading"><span class="glyphicon glyphicon-user"></span> &nbsp;&nbsp;Acceso</div>
                    <div class="panel-body">
                        <form class="form-horizontal" role="form">
                            <div class="well">  
                                
                                <div class="row">
                                    <label class="control-label col-md-2" style="text-align: right">Usuario</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                                <form:input class="form-control" path="usuario"/>
                                                
                                        </div>
                                    </div>
                                    <label class="control-label col-md-2" style="text-align: right">Password</label>
                                    <div class="col-md-3">
                                        <div class="input-group">
                                            <span class="input-group-addon"><span class="glyphicon glyphicon-barcode"></span></span>
                                                <form:input class="form-control" path="password" />
                                            
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <input type="submit" class="form-control btn-primary" align="center" value="Ingresar">                                        
                                    </div>
                                        
                                </div>
                                 
                                <div class="row">
                                    <div class="col-md-4">
                                        <form:errors path="usuario" cssClass="error"/>   
                                        <form:errors path="password" cssClass="error"/>
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