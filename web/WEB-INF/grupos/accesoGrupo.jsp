<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar información personal</title>
    </head>
    <body>
        
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">Buscar grupo</div>
                <div class="panel-body" style="">
                    Ingrese el token para buscar el grupo al que desea ingresar.
                    <form id="accesofrm" name="accesofrm" class="form-horizontal">             
                        <div class="form-group">
                            <label class="col-md-2 control-label" for="token">Token de grupo</label>
                            <div class="col-md-4">
                                <input id="token" name="token" type="text" class="form-control" placeholder="El token del grupo" />
                            </div>    
                        </div> 
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2" id="button-group">
                                <input id="search_button" type="submit" class="btn btn-success" value="Buscar">
                            </div>
                        </div>     
                    </form>
                    <div class="form-group" style="width: 49%;margin: initial">
                        <div class="panel panel-success" id="correcto" style="display:none;">
                            <div class="panel-heading" style="text-align: center">Datos del grupo</div>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <table id="tb_grupo" style="width:100%">                                        
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="panel panel-danger" id="incorrecto" style="display:none;">
                            <div class="panel-heading" style="text-align: center">Token incorrecto</div>
                            <div class="panel-body">No hay grupo con ese token.</div>
                        </div>
                </div>
                </div>
                
                
                
            </div>
        </div>
        
    </body>
    <script src="${pageContext.request.contextPath}/js/paginas/grupos/accesoGrupo.js"></script>
</html>
