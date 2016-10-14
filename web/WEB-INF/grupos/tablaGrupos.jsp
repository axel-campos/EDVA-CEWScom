<%@page import="modelo.dao.TipoUsuarioGrupoDAO"%>
<%@page import="java.util.Map"%>
<%@page import="modelo.pojo.Grupo"%>
<%@page import="modelo.dao.GrupoDAO"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="modelo.pojo.Usuario"%>
<%@page import="modelo.pojo.UsuarioGrupo"%>
<%@page import="modelo.pojo.TipoUsuarioGrupo"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.UsuarioGrupoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String cabeceras[] = {"Nombre","Descripcion","Rol","Editar","Salir","Eliminar","Reportar"}; 
    String cabeceraMExito = "<div class='alert alert-success'><span class='glyphicon glyphicon-ok'></span>  ";
    String cabeceraMError = "<div class='alert alert-danger'><span class='glyphicon glyphicon-alert'></span>  ";
    String cierreM = "</div>";
    TipoUsuarioGrupoDAO rolDAO = new TipoUsuarioGrupoDAO();
    Usuario usuarioS = null;
    rolDAO.conectar();
    List<TipoUsuarioGrupo>roles = rolDAO.buscarTodos();
    String nombre = "", token = "";
    int idRol = 0;
    boolean busco = false;
    if(session.getAttribute("nombre") != null){
        nombre = session.getAttribute("nombre").toString();
        session.removeAttribute("nombre");
    }
    if(session.getAttribute("rol") != null){
        idRol = Integer.parseInt(session.getAttribute("rol").toString());
        session.removeAttribute("rol");
    }
    if(session.getAttribute("token") != null){
        token = session.getAttribute("token").toString();
        session.removeAttribute("token");
    }
    if(session.getAttribute("busco") != null){
        busco = (Boolean)session.getAttribute("busco");
        session.removeAttribute("busco");
    }
    if(session.getAttribute("usuario") != null){
        usuarioS = (Usuario)session.getAttribute("usuario");
    }
%>

 <!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <script src="${pageContext.request.contextPath}/js/paginas/grupos/tablaGrupos.js"></script>
        <title>Grupos</title> 
    </head>
    <body>
    <div id="contenedor1" class="container-fluid">
        <s:if test="hasActionMessages()">
            <div class="alert alert-success" id="msjExito" style="display: none;">
                <s:actionmessage />
            </div>
        </s:if>
        <s:if test="hasActionErrors()">
            <div class="alert alert-danger" id="msjError" style="display: none">
                <s:actionerror />
            </div>
        </s:if>
        <a onclick="crearGrupo()" class="btn btn-link">Crear Nuevo Grupo </a>
        <a onclick="solicitarIngreso()" class="btn btn-link">Solicitar entrada a grupo</a>
    </div>
    <div id="filtros" class="container-fluid">
        <form id="frmFiltros" name="frmFiltros" class="form-inline">
            <div class="form-group col-md-3">
                <label for="token">Token:</label>
                    <input type="text" id="token" name="token" class="form-control" value="<%= token%>">
            </div>
            <div class="form-group col-md-4">
                <label for="nombre">Nombre del Grupo:</label>
                    <input type="text" id="nombre" name="nombre" class="form-control" value="<%= nombre%>">
            </div>
            <div class="form-group col-md-4">
                <label for="rol">Rol:</label>
                    <select class="form-control" id="rol" name="rol" style="width:50%">
                        <option value="0">Todos los roles</option>
                        <%
                        for(TipoUsuarioGrupo rol : roles){
                            String s = "";
                            if(idRol == rol.getIdTipoUsuarioGrupo()){
                                s = "selected";
                            }
                        %>
                        <option value="<%= rol.getIdTipoUsuarioGrupo()%>" <%= s%>><%= rol.getNombre()%></option>
                        <%
                        }    
                        %>
                    </select>
            </div>
            <div class="form-group col-md-1">
                <button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>  Buscar</button>
            </div>
        </form>
    </div>
    <div class="table-responsive" id='div1'>
        <% if(busco){%>
            <table id="tabla">
                <thead>
                    <tr>
                    <%
                        for(int x = 0; x < cabeceras.length; x++){
                            out.println("<th data-sortable='true' data-field='"+cabeceras[x]+"' data-align='center'>"+cabeceras[x]+"</th>");

                        }
                    %>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="resultados" var="resultado">
                        <tr>
                            <td><a onclick="cambiarContenidos('ListarMiembrosAction?token=<s:property value="%{#resultado[3]}"/>','#contenido');" class="btn btn-link"><s:property value="%{#resultado[0]}" /></a></td>
                            <td><s:property value="%{#resultado[1]}" /></td>
                            <td><s:property value="%{#resultado[2]}" /></td>
                            <td><a onclick="modificarGrupo('<s:property value="%{#resultado[3]}" />')" style="cursor:pointer;">
                                    <span class="glyphicon glyphicon-pencil" style="min-width: 20px; min-height: 20px"></span></a>
                            </td>
                            <td><s:if test="%{#resultado[4] != 1}" >
                                <a onclick="estasSeguro('SalirGroup?token=<s:property value="%{#resultado[3]}" />','#contenido')" style="cursor:pointer;">
                                <span class="glyphicon glyphicon-log-out" style="min-width: 20px; min-height: 20px"></span></a>    
                            </s:if></td>
                            <td><s:if test="%{#resultado[4] == 1}" >
                                <a href="#" onclick="verificarGrupoVacio('<s:property value="%{#resultado[3]}" />')">
                                <span class="glyphicon glyphicon-trash" style="min-width: 20px; min-height: 20px"></span></a>    
                            </s:if></td>
                            <td>
                                <a onclick<s:property value="%{#resultado[3]}"/>="crearReporte('2','');" class="btn btn-link">
                                    <span class="glyphicon glyphicon-warning-sign" style="min-width: 20px; min-height: 20px"></span>
                                </a>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>        
        <% }%>
    </div>
    </body>
</html>

