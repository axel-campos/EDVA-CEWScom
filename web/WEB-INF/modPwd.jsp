<%-- 
    Document   : modPwd
    Created on : 26/06/2016, 01:35:05 PM
    Author     : Christian Campos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Contraseña</title>
    </head>
    <body>
        <form role="form" id="mod_pwd_frm" method="" class="form-group" action=""> 
            <div class="form-group"> 
                <label for="recipient-name" class="control-label">Contraseña actual</label>                       
                <input type="password" class="form-control" id="new_pwd">                                                            
                <label for="recipient-name" class="control-label">Contraseña nueva</label>                      
                <input type="password" class="form-control" id="old_pwd">                                                               
                <label for="recipient-name" class="control-label">Repetir su Contraseña</label>                       
                <input type="password" class="form-control" id="old_pwd_rpt">                    
            </div>                  
        </form>  
    </body>
</html>
