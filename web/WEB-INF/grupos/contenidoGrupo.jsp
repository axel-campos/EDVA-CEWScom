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
            <a onclick="crearContenido()" class="btn btn-link">Crear Contenido Didáctico</a>
            <input type="hidden" id="token" value="<s:property value="token"/>">
            <%
                //Buscaremos los primeros diez contenidos de los grupos de este usuario
                ContenidoDAO contenidoDAO = new ContenidoDAO();
                contenidoDAO.conectar();
                Usuario usuarioS = null;
                String sqlContenidos = "SELECT con.*,ce.tiempoModificacion, ce.tiempoVotacion, e.nombre, g.nombre AS nombreGrupo FROM contenido con " +
                    " LEFT JOIN contenidoetapa AS ce ON ce.idContenido = con.idContenido " +
                    " INNER JOIN etapa AS e ON e.idEtapa = ce.idEtapa " +
                    " INNER JOIN grupo AS g ON g.token = con.token " +
                    " INNER JOIN usuariogrupo AS ug ON g.token = ug.token ";
                if(session.getAttribute("usuario") != null){
                    usuarioS = (Usuario)session.getAttribute("usuario");
                    if(usuarioS.getTipo() == 1){    //Significa que es admin DIOS
                        sqlContenidos += " WHERE ce.liberado = 0 AND (ce.tiempoModificacion >= NOW() OR ce.tiempoVotacion >= NOW()) GROUP BY idContenido;";
                    }else{
                        sqlContenidos += " WHERE ug.correo = '" + usuario.getCorreo() + "' AND ug.aceptado = 1 AND ce.liberado = 0 AND (ce.tiempoModificacion >= NOW() OR ce.tiempoVotacion >= NOW()) GROUP BY idContenido;";
                    }
                }
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
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        for(i = 0; i < tablaContenidos.size(); i++){
                            Map<String, Object> columna = tablaContenidos.get(i);
                            String nombreGrupo = (String)columna.get("nombreGrupo");
                            String titulo = (String)columna.get("titulo");
                            String tema = (String)columna.get("tema");
                            String descripcion = (String)columna.get("descripcion");
                            String etapa = (String)columna.get("nombre");
                            String fechaModificacion = df.format((Timestamp)columna.get("tiempoModificacion"));
                            String fechaVotacion = df.format((Timestamp)columna.get("tiempoVotacion"));
                %>
                <div class="col-sm-6">
                    <div class="panel panel-default">
                        <div class="panel-body" style="overflow: auto">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#accordion" href="#collapse<%=i%>">
                                            Contenido: <%=titulo%> <br/> Grupo: <%=nombreGrupo%></a>
                                    </h4>
                                </div>
                                <div id="collapse<%=i%>" class="panel-collapse collapse">
                                    <div class="panel-body">
                                        Título: <%=titulo%> <br/>
                                        Grupo: <%=nombreGrupo%> <br/>
                                        Tema: <%=tema%> <br/>
                                        Descripción: <%=descripcion%> <br/>
                                        Etapa: <%=etapa%> <br/>
                                        Fecha límite modificación de etapa: <%=fechaModificacion%> <br/>
                                        Fecha límite votación de etapa: <%=fechaVotacion%> <br/>
                                        <br/>
                                        <button id="pwd_modify_button" type="button" class="btn btn-primary" onclick="modificarContrasenia()"><span class="glyphicon glyphicon-eye-close"></span>Ir al contenido</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <%            
                        }
                    }
                %>
        </div>
        
    </body>
</html>
