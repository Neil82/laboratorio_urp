<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<html>
    <head>
        <link rel="stylesheet" href="urp.css" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control de Laboratorio URP</title>
        <style>
            .error { color: red; }
        </style>  
    </head>
    <body>

<div style="position: relative; padding: 0px;">
    <img src="images/fondo1.jpg" style=" width: 100%; height: 100%;" alt="Universidad Ricardo Palma" />

	
<div id="hlogin" style="position: absolute; left: 30px; bottom: 70px;">
	
	<table border="1" style="height: 40px; padding: 0px; border-width: 1px; border-color:rgba(255,255,255,0.6); " align="left">
	
	<tr style="background-color:rgba(255,255,255,0.6); padding: 0px;">
	 
	 <td valign="middle" align="center" style="padding: 0px;">
             <table style=" padding: 0px; padding-bottom: 13px;" cellpadding="0" cellspacing="0">
                <tr>
                    <td align="center">
                            <div id="tablatexto">Acceso al Control de Laboratorios</div>
                    </td>
                    <td></td>
                </tr>
            </table>
			
	   	 
	 </td>
	
	</tr>
		

	
			
	<tr style="background-color:rgba(255,255,255,0.6); padding: 0px;">
	<td align="center" style="padding: 0px;">
		
		
	  <div id="tabla">

	  <table width="100%" border="0" align="left" style="padding: 0px;" cellpadding="0" cellspacing="0">
          <form:form method="post" commandName="model">    
		
              <tr style=" padding: 0px;">
  	  		
	  	  <td align="left" style="font-size:16px; font-weight:500; font-family:'Gill Sans', 'Gill Sans MT', 'Myriad Pro', 'DejaVu Sans Condensed', Helvetica, Arial, sans-serif; width: 130px; padding-left: 30px; color: rgba(38,68,134,1.00);">Usuario</td>
	  	  
		  <td align="left" style="width: 270px;">
                            <form:input class="form-control" path="usuario" style="border-color:#bbbec0; border-radius: 0; font-size:14px; height:25px; width: 200px; padding-right: 30px;"/>
		  

		  </td>
		</tr>
		
		
	
		<tr style=" padding: 0px;">
	  	  <td align="left" style="font-size:16px; font-weight:500; font-family:'Gill Sans', 'Gill Sans MT', 'Myriad Pro', 'DejaVu Sans Condensed', Helvetica, Arial, sans-serif; padding-left: 30px; color: rgba(38,68,134,1.00);">Contrase&ntilde;a</td>
	  	  
		  <td align="left">
                      <form:input class="form-control" type="password" path="password" style="border-color:#bbbec0; border-radius: 0; font-size:14px; height:25px; width: 200px; padding-right: 30px;" />
		  
		  </td>
		</tr>
		
		
		
		<tr>
		  <td colspan="2" height="40" align="right" style="padding-right: 40px;" valign="bottom">
			<p>
				<input type="submit" class="form-control btn-primary" align="center" value="Ingresar">   
			</p>
			</td>
		</tr>
                
                <tr style=" padding: 0px;">
		  <td colspan="2" height="10" align="right" style="padding: 0px; padding-right: 40px;" valign="bottom">
			
			</td>
		</tr>
                
                <div class="row">
                    <div class="col-md-4">
                        <form:errors path="usuario" cssClass="error"/>   
                        <form:errors path="password" cssClass="error"/>
                    </div>
                </div>
	
          </form:form>
	  </table>
	   </div>


	</td></tr>
	</table>
	</div>
</div>
</body>
</html>	