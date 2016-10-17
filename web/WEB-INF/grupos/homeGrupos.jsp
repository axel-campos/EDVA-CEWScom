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
        <nav class="navbar navbar-default sidebar" role="navigation">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-sidebar-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>      
                </div>
                <div class="collapse navbar-collapse" id="bs-sidebar-navbar-collapse-1">
                    <ul class="nav navbar-nav" style="width: 100%">
                        <li class="active"><a href="#" onclick="mostrarLista('ListarContenidosGrupoAction','<%=token%>');">Contenidos<span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-home"></span></a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Datos del grupo <span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-user"></span></a>
                            <ul class="dropdown-menu forAnimate" role="menu">
                                <li style="padding-left: 5%">
                                    <b>Nombre del grupo:</b> <%= nombre%>
                                </li>
                                <li style="padding-left: 5%">
                                    <b>Descripcion:</b> <%= descripcion%>
                                </li>
                            </ul>
                        </li>
                        <li class="dropdown" style="width: 100%">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Miembros del grupo <span class="badge"><%= noProfesores%></span><span class="caret"></span><span style="font-size:16px;" class="pull-right hidden-xs showopacity glyphicon glyphicon-th-list"></span>
                            </a>
                            <ul class="dropdown-menu forAnimate" role="menu">
                                <s:iterator value="results" var="nombre">
                                    <li style="padding-left: 5%">
                                        <div class="row">
                                            <div class="col-md-9">
                                                <s:property value='%{#nombre[0]}'/>
                                            </div>
                                            <div class="col-md-3">
                                                <a onclick="crearReporte('3','<s:property value="%{#nombre[1]}"/>','<%=token%>');" class="btn btn-link">
                                                    <span style="font-size:16px;" class="glyphicon glyphicon-warning-sign"></span>
                                                </a>
                                            </div>
                                        </div>
                                    </li>
                                </s:iterator>
                                
                                <s:if test="esAdministrador">
                                    <li style="text-align: center">
                                        <%if(noProfesores > 1){ %>
                                        <s:if test="esCoordinador">
                                            <button class="btn btn-primary btn-sm" onclick="mostrarLista('ListRoles','<%=token%>');">Roles del grupo</button>
                                        </s:if>
                                        <% }%>
                                            <button class="btn btn-info btn-sm" onclick="mostrarLista('ListSolicitudes','<%=token%>');">Solicitudes</button>
                                    </li>
                                </s:if>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="main" id="contenidoGrupo">
            <%@include file="contenidoGrupo.jsp"%>
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
