<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.pojo.Etapa"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/contenido/altaEtapasVersion.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <s:set name="etapa" value="etapa"/>
        <div class="container-fluid">
            <form id="frmTiempos" name="frmTiempos" class="form-horizontal">
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
                </div>
                <!--div class="form-group">
                    <label for="fecha">Fecha:</label>
                    <input type="text" id="fecha" name="fecha" class="form-control"/>
                </div-->
                <div class="table-responsive">
                    <table class='table' id="tablaVersiones">
                        <thead>
                            <tr>
                                <th style="width: 30%; text-align: center;">Versión</th>
                                <th style="width: 70%; text-align: center">Tiempo Límite Creación</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <input type="hidden" value="<s:property value="idContenido"/>" id="idContenido" name="idContenido"/> 
                <button type="button" class="btn btn-sm btn-danger" id="btnCancelar" style="float:right;display: none;"><span class="glyphicon glyphicon-repeat"></span> Cancelar</button>
                <button type="submit" class="btn btn-sm btn-success" id="btnSubmit" style="float:right;display:none"><span class="glyphicon glyphicon-ok"></span> Guardar</button>
                
            </form>   
        </div>
    </body>
</html>
