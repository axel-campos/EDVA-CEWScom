<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<% int x = 0;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenedor1" class="container-fluid">
            <s:if test="hasActionMessages()">
                <div class="alert alert-success" id="msjExito" style="display: none;">
                    <s:actionmessage />
                </div>
            </s:if>
            <s:if test="hasActionErrors()">
                <div class="alert alert-danger" id="msjError" style="display: none;">
                    <s:actionerror />
                </div>
            </s:if>
        </div>
        <div class="table-responsive">
            <form id="frmRoles" name="frmRoles">
                <table class="table table-hover" id="tabla">
                    <thead>
                    <th style="width:20%;" data-sortable='true' data-field='Nombre del miembro' data-align='center'>Nombre del miembro</th>
                    <th style="width:5%;" id="colCoordinador" data-align='center' data-visible="false" data-field='Coordinador'>Coordinador</th>
                    <th style="width:5%;" data-align='center'>Administrador</th>
                    <th style="width:5%;" data-align='center'>Colaborador</th>
                    <th style="width:10%;" id="colEliminar" data-align='center' data-visible="false" data-field='Eliminar'>Eliminar</th>
                    </thead>
                    <tbody>
                    <s:iterator value="results" var="result">
                        <tr>
                            <td><s:property value="%{#result[0]}"/><input type="hidden" name="txt_correo_<%=x %>" id="txt_correo_<%=x %>" value="<s:property value='%{#result[1]}'/>" /></td>
                            <td style="text-align:center;display: none;" id="rowCoordinador_<%= x%>"><input type="radio" id="txt_result_<%= x%>" name="txt_result_<%= x%>" value="1" disabled/></td>
                            <td style="text-align: center;"><input type="radio" id="txt_result_<%= x%>" name="txt_result_<%= x%>" value="2" <s:property value='%{#result[2]}'/> disabled/></td>              
                            <td style="text-align: center;"><input type="radio" id="txt_result_<%= x%>" name="txt_result_<%= x%>" value="3" <s:property value='%{#result[3]}'/> disabled/></td>
                            <td style="display:none; text-align: center;" id="rowEliminar_<%= x%>"><a onclick="eliminarMiembro('<%= x %>')" class="btn btn-link"><span class="glyphicon glyphicon-trash" style="min-width: 20px; min-height: 20px"></span></a></td>
                        </tr>    
                        <% x += 1;%>
                    </s:iterator>
                    </tbody>
                </table>
                <input type="hidden" name="numMiembros" id="numMiembros" value="<%= x%>"/>
                <input type="hidden" name="token" id="token" value="<s:property value='token'/>"/>
                <div class="form-group" >
                    <% if(x > 0){%>
                    <div class="col-md-4" id="button-group">
                        <!--input type="button" value="Modificar Roles" class="btn btn-success" onclick="ModificarRoles()" id="modify_button"/>
                        <input type="button" value="Nuevo Coordinador" class="btn btn-primary" onclick="NuevoCoordinador()" id="new_coordinator_button"/>
                        <input type="button" id="submit_button" value="Guardar" class="btn btn-success" onclick="guardarCambiosRoles()" style="display:none"/>
                        <input type="button" id="coordinador_submit_button" value="Guardar" class="btn btn-success" onclick="asignarNuevoCoordinador()" style="display:none"/>
                        <input type="button" id="cancelar_button" value="Cancelar" class="btn btn-danger" onclick="cancel_operation()" style="display:none"/-->
                        <button type="button" id="modify_button" class="btn btn-success" onclick="ModificarRoles()">
                            <span class="glyphicon glyphicon-retweet"></span>   Modificar Roles
                        </button>
                        <button type="button" id="new_coordinator_button" class="btn btn-primary" onclick="NuevoCoordinador()">
                            <span class="glyphicon glyphicon-pencil"></span>   Nuevo coordinador
                        </button>
                        <button type="button" id="submit_button" class="btn btn-success" onclick="guardarCambiosRoles()" style="display: none">
                            <span class="glyphicon glyphicon-saved"></span>   Guardar
                        </button>
                        <button type="button" id="coordinador_submit_button" class="btn btn-success" onclick="asignarNuevoCoordinador()" style="display: none">
                            <span class="glyphicon glyphicon-saved"></span>   Guardar
                        </button>
                        <button type="button" id="cancelar_button" class="btn btn-danger" onclick="cancel_operation()" style="display: none">
                            <span class="glyphicon glyphicon-remove"></span>   Cancelar
                        </button>
                    </div>
                    <% }%>
                </div>
            </form>
        </div>
    </body>
    <script src="${pageContext.request.contextPath}/js/paginas/grupos/tablaRoles.js"></script>
</html>
