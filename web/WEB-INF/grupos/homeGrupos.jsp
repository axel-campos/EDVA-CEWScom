<%@page import="modelo.pojo.Grupo"%>
<%@page import="modelo.dao.GrupoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String token = "", nombre = "", descripcion = "";
    int noProfesores = 0;
    if(session.getAttribute("token") != null){
        token = session.getAttribute("token").toString();
        GrupoDAO grupoDAO = new GrupoDAO();
        grupoDAO.conectar();
        Grupo grupo = grupoDAO.buscar(new Grupo().setToken(token));
        nombre = grupo.getNombre();
        descripcion = grupo.getDescripcion();
        noProfesores = grupo.getTotalProfesores();
        session.removeAttribute("token");
    }    
    
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/grupos/homeGrupos.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <div id="wrapper">
            <!--sidebar -->
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li class="dropdown" id="informacion">
                        <a href="#" onclick="abrirVentana1()" class="dropdown-toggle" data-toggle="collapse" data-target="#GroupInfo">
                            <span class="glyphicon glyphicon-info-sign">   </span>   Información del grupo
                            <div style="float: right; margin-right: 5%"><span class='caret'></span></div>
                        </a>
                        <div style="color: whitesmoke" id="GroupInfo" class="collapse">
                            <!--fieldset class="form-group"-->
                            <div class="container-fluid">
                                <label class="col-md-4" style="text-align: right;">Nombre:</label>
                                <div class="col-md-8" style="text-align: left;">
                                    <%= nombre%>
                                </div>
                            </div>
                            <div class="container-fluid">
                                <label class="col-md-4" style="text-align: right;">Descripción:</label>
                                <div class="col-md-8" style="text-align: left;">
                                    <%= descripcion%>
                                </div>
                            </div>
                            
                        </div>
                    </li>
                    <li class="dropdown" id="miembros">
                        <a href="#" onclick="abrirVentana2()" class="dropdown-toggle" data-toggle="collapse" data-target="#GroupMembers">
                            <span class="glyphicon glyphicon-th-list"></span>   Miembros del grupo 
                            <span class="badge"><%= noProfesores%></span>
                            <div style="float: right; margin-right: 5%"><span class='caret'></span></div>
                        </a>
                        <div style="color: whitesmoke" id="GroupMembers" class="collapse">
                            <div class="container-fluid" style="overflow: auto;">
                                <s:iterator value="results" var="nombre">
                                    <div class="col-md-12"><s:property value='%{#nombre}'/></div>
                                </s:iterator>
                                
                                <s:if test="esAdministrador">
                                    <div class="col-md-12">
                                        <%if(noProfesores > 1){ %>
                                        <s:if test="esCoordinador">
                                            <button class="btn btn-primary btn-sm" onclick="mostrarLista('ListRoles?token=<%=token%>');">Roles del grupo</button>
                                        </s:if>
                                        <% }%>
                                            <button class="btn btn-info btn-sm" onclick="mostrarLista('ListSolicitudes?token=<%=token%>');">Solicitudes</button>
                                    </div>
                                </s:if>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
            <!--Page content -->
            <div id="page-content-wrapper" class="container-fluid">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-12">
                            <!--button type="button" class="btn btn-default" data-toggle="collapse"-->
                            <a href="#menu-toggle" class="btn btn-default" id="menu-toggle"><span class="glyphicon glyphicon-align-justify"></span></a>
                            <div style="overflow: auto" id="contenidoGrupo" class="container-fluid">
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script>
            
            /*$("#divInfo1").height((height * 0.335));
            $("#divInfo2").height((height * 0.335));*/
            /*$("#sidebar").height(height * 0.825);
            $("#content").height(height * 0.83);*/
        //});
    </script>
</html>
