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
        <div class="table-responsive">
            <form id="frmRoles" name="frmRoles">
                <table class="table table-hover">
                    <thead>
                    <th style="width:20%;">Nombre del miembro</th>
                    <th style="width:5%; display: none;text-align: center" id="colCoordinador">Coordinador</th>
                    <th style="width:5%; text-align: center">Administrador</th>
                    <th style="width:5%; text-align: center">Colaborador</th>
                    <th style="width:10%; display: none; text-align: center" id="colEliminar">Eliminar</th>
                    </thead>
                    <tbody>
                    <s:iterator value="results" var="result">
                        <tr>
                            <td><s:property value="%{#result[0]}"/><input type="hidden" name="txt_correo_<%=x %>" value="<s:property value='%{#result[1]}'/>" /></td>
                            <td style="text-align:center;display: none;" id="rowCoordinador_<%= x%>"><input type="radio" id="txt_result_<%= x%>" name="txt_result_<%= x%>" value="1" disabled/></td>
                            <td style="text-align: center;"><input type="radio" id="txt_result_<%= x%>" name="txt_result_<%= x%>" value="2" <s:property value='%{#result[2]}'/> disabled/></td>              
                            <td style="text-align: center;"><input type="radio" id="txt_result_<%= x%>" name="txt_result_<%= x%>" value="3" <s:property value='%{#result[3]}'/> disabled/></td>
                            <td style="display:none; text-align: center;" id="rowEliminar_<%= x%>"><a onclick="eliminarMiembro(this)" class="btn btn-link">Eliminar</a></td>
                        </tr>    
                        <% x += 1;%>
                    </s:iterator>
                    </tbody>
                </table>
                <input type="hidden" name="numMiembros" id="numMiembros" value="<%= x%>"/>
                <input type="hidden" name="token" id="token" value="<s:property value='token'/>"/>
                <div class="form-group">
                    <div class="col-md-5" id="button-group">
                        <% if(x > 0){%>
                        <input type="button" value="Modificar Roles" class="btn btn-success" onclick="ModificarRoles()" id="modify_button"/>
                        <input type="button" value="Nuevo Coordinador" class="btn btn-primary" onclick="NuevoCoordinador()" id="new_coordinator_button"/>
                        <% }%>
                    </div>
                </div>
            </form>
        </div>
        <br>
        <s:if test="hasActionMessages()">
            <div class="alert alert-success">
                <s:actionmessage />
            </div>
        </s:if>
        <s:if test="hasActionErrors()">
            <div class="alert alert-danger">
                <s:actionerror />
            </div>
        </s:if>
    </body>
    <script src="${pageContext.request.contextPath}/js/paginas/grupos/tablaRoles.js"></script>
</html>
