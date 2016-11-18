<%@page import="modelo.pojo.Grupo"%>
<%@page import="modelo.dao.GrupoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/grupos/homeGrupos.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container-fluid">
            <a class="btn btn-link" onclick="cambiarContenidos('ListarContenidosGrupoAction?token=<s:property value="token"/>','#contenido');"><span class="glyphicon glyphicon-home"></span> Contenidos del grupo</a>
        </div>
        <div class="container-fluid">
            <table id="tabla" style="width: 100%">
                <thead>
                    <tr>
                        <th width="95%" data-align="center" data-sortable='true' data-field='Nombre'>Nombre</th>
                        <th width="5%" data-align="center">Reportar</th>
                    </tr>
                </thead>
                <tbody>
                    <% int x = 0;%>
                    <s:iterator value="results" var="nombre">
                    <tr>
                        <td><s:property value='%{#nombre[0]}'/></td>
                        <td>
                            <a onclick="crearReporte('3','<s:property value="%{#nombre[1]}"/>','<s:property value="token"/>');" class="btn btn-link">
                                    <img src="${pageContext.request.contextPath}/images/reporte.png" title="Reportar" style="cursor:pointer;width: 25px">
                            </a>
                        </td>
                    </tr>
                    <% x += 1;%>
                    </s:iterator>
                </tbody>
            </table>
        </div>            
    </body>
</html>
