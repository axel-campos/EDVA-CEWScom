<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/grupos/tablaSolicitudes.js"></script>
        <title>Solicitudes</title>
    </head>
    <body>
        <div class="container-fluid">
            <a class="btn btn-link" onclick="mostrarLista('ListarContenidosGrupoAction','<s:property value="token"/>');"><span class="glyphicon glyphicon-home"></span> Contenidos del grupo</a>
        </div>
        <table id="tabla" style="width: 100%">
            <thead>
                <th width="90%" data-align="center" data-sortable='true' data-field='Nombre'>Nombre</th>
                <th width="5%" data-align="center"></th>
                <th width="5%" data-align="center"></th>
            </thead>
            <tbody>
                <% int x = 0;%>
                <s:iterator value="solicitantes" var="solicitante">
                <tr>
                    <td id="nombre_<%= x%>"><s:property value="%{#solicitante[1]}"/></td>
                    <td>
                        <a onclick="procesarSolicitud('<s:property value="%{#solicitante[0]}"/>','0','<%= x%>')">
                            <img src="${pageContext.request.contextPath}/images/aceptado.png" title="Aceptar" style="cursor:pointer;width: 25px">
                        </a>
                    </td>
                    <td>
                        <a onclick="procesarSolicitud('<s:property value="%{#solicitante[0]}"/>','1','<%= x%>')">
                            <img src="${pageContext.request.contextPath}/images/rechazado.png" title="Rechazar" style="cursor:pointer;width: 25px">
                        </a>
                    </td>
                </tr>
                <% x += 1; %>
                </s:iterator>
            </tbody>
        </table>
        <input value="<s:property value="token"/>" style="display:none" id="token">
        
    </body>
</html>
