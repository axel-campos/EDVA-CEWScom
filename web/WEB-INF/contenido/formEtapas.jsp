<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.pojo.Etapa"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/contenido/altaEtapasVersion.js"></script>
        <link href="${pageContext.request.contextPath}/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
        <title>JSP Page</title>
    </head>
    <body>
        <s:set name="etapa" value="etapa"/>
        <div class="container-fluid">
            <s:if test="version == ''">
                Selecciona la etapa a la que quieras agregar una nueva versión.
            </s:if>
            <s:else>
                Si quieres aplazar el tiempo de modificación de la versión, da clic en el botón <b>Editar</b>
            </s:else>
            <form id="frmTiempos" name="frmTiempos" class="form-horizontal">
                <input type="hidden" id="version" value="<s:property value="version"/>"/>
                <input type="hidden" id="etapaActiva" value="<s:property value="etapa"/>"/>
                <div class="form-group">
                    <label for="etapa">Etapa:</label>
                    <select id="etapa" name="etapa" class='form-control' onchange="cargarVersiones(this.value);" style="width: 45%">
                        <option value='0'>Seleccione una etapa</option>
                        <s:iterator value="etapas" var="etapita">
                            <% String selected = "";%>
                            <s:if test="%{#etapa == #etapita.getIdEtapa()}">
                                <% selected = "selected";%>
                            </s:if>
                            <option value='<s:property value="%{#etapita.getIdEtapa()}"/>' <%= selected%>><s:property value="%{#etapita.getNombre()}"/></option>                                
                        </s:iterator>
                    </select>
                    <!--a onclick="agregarVersion()" title="Nueva versión" id="btnAgregar" style="display: none;"><span class="glyphicon glyphicon-plus" style="float: right; cursor: pointer"></span></a-->
                    <!--a title="Nueva versión" id="btnAgregar" class="addButton" style="display: none;"><span class="glyphicon glyphicon-plus" style="float: right; cursor: pointer"></span></a-->
                    <button onclick="" type="button" id="btnAgregar" class="btn btn-default addButton" style="float: right; display: none"><span class="glyphicon glyphicon-plus"></span></button>
                    <!--button type="button" onclick="myfunction()" class="btn btn-default addButton" style="float: right;"><span class="glyphicon glyphicon-plus"></span></button-->
                </div>
                <div class="form-group">
                    <label class="col-md-4 control-label"><p align="center">Versión</p></label>
                    <label class="col-md-8 control-label"><p align="center">Tiempo Límite</p></label>
                </div>
                <input type="hidden" value="<s:property value="idContenido"/>" id="idContenido" name="idContenido"/> 
                <!--Botones normales para crear -->
                <button type="button" class="btn btn-sm btn-danger" id="btnCancelar" style="float:right;display: none;" onclick="cancelarGuardar()"><span class="glyphicon glyphicon-repeat"></span> Cancelar</button>
                <button type="submit" class="btn btn-sm btn-success" id="btnSubmit" style="float:right;display:none"><span class="glyphicon glyphicon-ok"></span> Guardar</button>
                <!--Botones para editar -->
                <button type="button" class="btn btn-sm btn-success" id="btnEditar" style="float:right;display:none"><span class="glyphicon glyphicon-edit"></span> Editar</button>
                <button type="button" class="btn btn-sm btn-danger" id="CancelarEdicion" style="float:right;display: none;" onclick="cancelarEditar()"><span class="glyphicon glyphicon-repeat"></span> Cancelar</button>
                <button type="submit" class="btn btn-sm btn-success" id="SubmitEdicion" style="float:right;display:none"><span class="glyphicon glyphicon-ok"></span> Editar</button>
            </form>   
        </div>
    </body>
</html>
