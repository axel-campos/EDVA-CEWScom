<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.ContenidoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grupos</title>
        <script src="${pageContext.request.contextPath}/js/paginas/grupos/contenidoGrupo.js"></script>
    </head>
    <body>
        <div id="contenedor1" class="container-fluid">
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
            <s:if test="esAdministrador">
                <s:if test="esCoordinador">
                    <a class="btn btn-link" onclick="mostrarLista('ListRoles','<s:property value="token"/>');">Roles del grupo</a>
                </s:if>
                <a class="btn btn-link" onclick="mostrarLista('ListSolicitudes','<s:property value="token"/>');">Solicitudes</a>
                <a onclick="crearContenido()" class="btn btn-link">Crear Contenido Didáctico</a>
            </s:if>
            <input type="hidden" id="token" value="<s:property value="token"/>">
            <input type="hidden" id="message" value="<s:property value="message"/>">
            <input type="hidden" id="type" value="<s:property value="type"/>">
        </div>
        <div class="row-fluid">
            <div class="col-md-11" id="paginacion"></div>
            <div class="col-md-1"></div>
        </div>
        <div id="contenedorContenidos">
        <%
            String token2 = "";
            int div = 0;
            Boolean cerrarDiv = false;
            if(request.getParameter("token") != null){
                token2 = (String)request.getParameter("token");
            }
            //Buscaremos los primeros diez contenidos de los grupos de este usuario
            ContenidoDAO contenidoDAO = new ContenidoDAO();
            contenidoDAO.conectar();
            String sqlContenidos = "SELECT con.*, g.nombre AS nombreGrupo, " +
                "(CASE WHEN ce.tiempoModificacion > NOW() THEN e.nombre ELSE NULL END) AS nombre, " +
                "(CASE WHEN ce.tiempoModificacion > NOW() THEN ce.tiempoModificacion ELSE NULL END) AS tiempoModificacion, " +
                "(CASE WHEN ce.tiempoModificacion > NOW() THEN e.idEtapa ELSE NULL END) AS idEtapa, " +
                "(CASE WHEN ce.tiempoModificacion > NOW() THEN ce.version ELSE NULL END) AS version, " +
                "(CASE WHEN ve.tiempoModificacion > NOW() THEN ve.idEtapa ELSE NULL END) AS idEtapa2," +
                "(CASE WHEN ve.tiempoModificacion <= NOW() THEN '1' ELSE '0' END) AS finalizaVotacion," +
                " ve.tiempoModificacion AS tiempoVotacion FROM contenido con " +
                " LEFT JOIN etapa AS e ON e.idEtapa = (SELECT ce2.idEtapa FROM contenidoetapa ce2 WHERE con.idContenido = ce2.idContenido ORDER BY ce2.tiempoModificacion DESC LIMIT 1) " +
                " LEFT JOIN contenidoetapa AS ce ON ce.idContenido = con.idContenido AND ce.idEtapa = e.idEtapa AND ce.idEtapa != 6 " +
                " AND ce.version = (SELECT ce2.version FROM contenidoetapa ce2 WHERE con.idContenido = ce2.idContenido ORDER BY ce2.tiempoModificacion DESC LIMIT 1)" +
                " LEFT JOIN contenidoetapa AS ve ON ve.idContenido = con.idContenido AND ve.idEtapa = 6" +
                " INNER JOIN grupo AS g ON g.token = con.token " +
                " INNER JOIN usuariogrupo AS ug ON g.token = ug.token " +
                " WHERE g.token ='" + token2 + "' AND con.finalizado = 0 GROUP BY idContenido;";
            List<Map<String, Object>> tablaContenidos = contenidoDAO.consultaGenerica(sqlContenidos);
            contenidoDAO.desconectar();
            if(tablaContenidos.isEmpty()){  //No tiene grupos asociados, o sus grupos no han comenzado a crear contenidos
            %>
                <div class="col-sm-12">
                    <div class="panel panel-default">
                        <div class="panel-body" style="overflow: auto">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">
                                        No hay contenidos activos para mostrar</a>
                                    </h4>
                                </div>
                                <div id="collapse1" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        Para empezar a crear contenidos debe pertenecer a un grupo de trabajo, una vez
                                        dentro junto con su grupo podrá comenzar a crear los contenidos que desee.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    }else{
                        int i = 0;
                        DateFormat df = new SimpleDateFormat("EEEE d MMMM yyyy, HH:mm:ss");
                        for(i = 0; i < tablaContenidos.size(); i++){
                            if(i % 8 == 0){
                                div++;
                                out.println("<div id='div_" + div + "' name='div_" + div + "'>");
                                out.println("<div class=\"col-xs-12\">&nbsp;</div>");
                                cerrarDiv = true;
                            }
                            Map<String, Object> columna = tablaContenidos.get(i);
                            int finalizaVotacion = Integer.parseInt(columna.get("finalizaVotacion").toString());
                            String nombreGrupo = (String)columna.get("nombreGrupo");
                            String titulo = (String)columna.get("titulo");
                            String tema = (String)columna.get("tema");
                            String descripcion2 = (String)columna.get("descripcion");
                            String etapa = "El contenido no tiene etapa activa";
                            String fechaModificacion = "";
                            String fechaVotacion = "Aún no se ha llegado a la etapa de votación";
                            String idContenido = columna.get("idContenido").toString();
                            String idEtapa = null, version = null;
                            String nombreBoton = "Agregar versión";
                            if(columna.get("idEtapa") != null){
                                idEtapa = columna.get("idEtapa").toString();
                                nombreBoton = "Editar versión";
                            }   
                            if(columna.get("version") != null){
                                version = columna.get("version").toString();
                            }   
                            if(columna.get("nombre") != null){
                                etapa = (String)columna.get("nombre");
                            }
                            if(columna.get("tiempoModificacion") != null)
                            {
                                fechaModificacion = df.format((Timestamp)columna.get("tiempoModificacion"));
                            }
                            if(columna.get("tiempoVotacion") != null)
                            {
                                fechaVotacion = df.format((Timestamp)columna.get("tiempoVotacion"));
                            }
                            String idRoomTogetherJS = token2 + idContenido;
                %>
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-body" style="overflow: auto">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i%>">
                                            Contenido: <%=titulo%>
                                    </h4>
                                </div>
                                <div id="collapse<%=i%>" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        Título: <%=titulo%> <br/>
                                        Grupo: <%=nombreGrupo%> <br/>
                                        Tema: <%=tema%> <br/>
                                        Descripción: <%=descripcion2%> <br/>
                                        Etapa: <%=etapa%> <br/>
                                        Fecha límite modificación de etapa: <%=fechaModificacion%> <br/>
                                        Fecha votación: <%=fechaVotacion%> <br/>
                                        <br/>
                                        <s:if test="esAdministrador">
                                            <% if(finalizaVotacion == 1 ){ %>
                                                <a onclick="finalizarVotacion('<%=idContenido%>','<%=token2%>')" class="btn btn-success">Finalizar contenido</a>
                                            <% } %>
                                            <% if(columna.get("tiempoVotacion") == null){ %>
                                                <button type="button" class="btn btn-primary" onclick="cargarFormulario(<%= idContenido %>,'<%= idEtapa%>','<%= version%>')"><span class="glyphicon glyphicon-time"></span> <%= nombreBoton%></button>
                                            <% }%>
                                            <button type="button" class="btn btn-info" onclick="modificarContenido(<%= idContenido %>)"><span class="glyphicon glyphicon-edit"></span> Modificar información</button>
                                            <button type="button" class="btn btn-danger" onclick="eliminaContenido(<%= idContenido %>)"><span class="glyphicon glyphicon-remove"></span> Eliminar contenido</button>
                                            <% if(idEtapa != null){%>
                                                <button type="button" class="btn btn-warning" onclick="terminaVersion(<%= idContenido %>, <%= idEtapa %>, <%= version %>)"><span class="glyphicon glyphicon-filter"></span> Terminar versión</button>
                                            <% }else if(columna.get("tiempoVotacion") != null && finalizaVotacion == 0){ %>
                                                <button type="button" class="btn btn-warning" onclick="terminaVersion(<%= idContenido %>, 6, 1)"><span class="glyphicon glyphicon-filter"></span> Terminar votación</button>
                                            <% } %>
                                            <br><br>
                                        </s:if>                
                                        <% if(fechaModificacion != ""){%>
                                            <a onclick="cambiarContenidos('workspaceColaboracion?idRoom=<%=idRoomTogetherJS%>&etapa=<%=etapa%>&token=<%=token2%>&titulo=<%=titulo%>&idContenido=<%=idContenido%>&idEtapa=<%=idEtapa%>&version=<%=version%>', '#contenido')" class="btn btn-success">Empezar a Colaborar</a>
                                        <% }else if(columna.get("idEtapa2") != null){%>
                                            <a onclick="mostrarVotacion('<%=idContenido%>','<%=token2%>')" class="btn btn-success">Ir a votación</a>
                                        <% } %>
                                        <a onclick="mostrarDisqus('<%=idContenido%>')" class="btn btn-info">Ver foro del contenido</a>
                                        <a onclick="crearReporte('1','<%=idContenido%>','<%=token2%>');" class="btn btn-primary">
                                            <span style="font-size:16px;" class="glyphicon glyphicon-warning-sign"></span> Reportar contenido
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%         
                            if(i % 8 == 7){
                                out.println("</div>");
                                cerrarDiv = false;
                            }
                        }
                        if(cerrarDiv){
                            out.println("</div>");
                        }   
                    }
                %>
        </div>
        
        <input type="hidden" id="numDivs" name="numDivs" value="<%=div%>"/>
        
    </body>
</html>
