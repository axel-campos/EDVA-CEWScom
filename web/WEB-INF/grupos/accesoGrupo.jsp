<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar información personal</title>
    </head>
    <body>
        
        <div class="container-fluid">
            <div class="panel panel-default">
                <!--div class="panel-heading">Buscar grupo</div-->
                <div class="panel-body" style="">
                    Ingrese el token para buscar el grupo al que desea ingresar.
                    <form id="accesofrm" name="accesofrm" class="form-horizontal">             
                        <div class="form-group">
                            <label class="col-md-3 control-label" for="tokenG">Token de grupo</label>
                            <div class="col-md-4">
                                <input id="tokenG" name="tokenG" type="text" class="form-control" placeholder="El token del grupo" />
                            </div>    
                        </div> 
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2" id="button-group">
                                <!--input id="search_button" type="submit" class="btn btn-primary" value="Buscar"-->
                                <button type="submit" id="search_button" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>  Buscar</button>
                            </div>
                        </div>     
                    </form>
                    <div class="form-inline" style="width: 80%;margin-left: auto;margin-right: auto">
                        <div class="panel panel-success" id="correcto" style="display:none;">
                            <div class="panel-heading" style="text-align: center">Datos del grupo</div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table id="tb_grupo" style="width:100%;">                                        
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!--div class="panel panel-danger" id="incorrecto" style="display:none;">
                            <div class="panel-heading" style="text-align: center">Token incorrecto</div>
                            <div class="panel-body">No hay grupo con ese token.</div>
                        </div-->
                        <div class="alert alert-danger" id="incorrecto" style="display: none;">
                            <span class="glyphicon glyphicon-alert"></span>  No existe grupo con el token que ingreso.
                        </div>
                    </div>
                </div>
                <s:if test="%{#parameters.resp[0] == 1}">
                    <div class="alert alert-success">
                        <span class="glyphicon glyphicon-ok"></span>  La solicitud se envío con éxito.
                    </div>
                </s:if>
                <s:elseif test="%{#parameters.resp[0] == 2}">
                    <div class="alert alert-danger">
                        <span class="glyphicon glyphicon-alert"></span>  <b>¡Error!</b> No se pudo enviar la solicitud.
                    </div>
                </s:elseif>
                <s:elseif test="%{#parameters.resp[0] == 3}">
                    <div class="alert alert-info">
                        <span class="glyphicon glyphicon-info-sign"></span>  Ya se había enviado un solicitud previa. Por favor, espere su respuesta.
                    </div>
                </s:elseif>
                <s:elseif test="%{#parameters.resp[0] == 4}">
                    <div class="alert alert-info">
                        <span class="glyphicon glyphicon-info-sign"></span>  Usted ya es miembro de este grupo.
                    </div>
                </s:elseif>
                
                
            </div>
        </div>
        
    </body>
    <script src="${pageContext.request.contextPath}/js/paginas/grupos/accesoGrupo.js"></script>
</html>
