<%-- 
    Document   : verVotacion
    Created on : 18/10/2016, 07:01:49 PM
    Author     : Víctor
--%>

<%@page import="modelo.pojo.Usuario"%>
<%@page import="modelo.dao.UsuarioVotacionDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="modelo.pojo.ContenidoEtapa"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="modelo.dao.ContenidoEtapaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/contenido/verVotacion.js"></script>
        <title>Votación</title>
    </head>
    <body>
        <%
            UsuarioVotacionDAO usuarioVotacionDAO = new UsuarioVotacionDAO();
            int idContenido = 0;
            int versionMaxima2 = 1;
            int []versionMaxima = new int[5];
            String correo = "", hiddenModificar = "", ocultarDiv = "";
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if(request.getParameter("idContenido") != null){
                idContenido = Integer.parseInt(request.getParameter("idContenido"));
            }
            usuarioVotacionDAO.conectar();
            if(session.getAttribute("usuario") != null){
                Usuario usuario = (Usuario)session.getAttribute("usuario");
                correo = usuario.getCorreo();
            }
            String votoUsuarioSql = "SELECT * FROM usuarioVotacion WHERE correo = '" + correo + "' "
                    + "AND idVotacion = (SELECT idVotacion FROM votacion WHERE idContenido = " + idContenido + " AND idEtapa = 1)";
            List<Map<String,Object>> flagUsuarioVoto = usuarioVotacionDAO.consultaGenerica(votoUsuarioSql);
            if(flagUsuarioVoto.size() > 0){
                ocultarDiv = "style=\"display: none\"";
                hiddenModificar = "<input type='hidden' id='modificar' name='modificar' value='1'/>";
        %>
            <script>
                $("#btn-info").hide();
            </script>
            <div class="container-fluid" id="modificarVoto">
                <h2>Votaciones por etapa</h2>
                Su usuario con correo <%=correo%> ya ha participado en la votación de este contenido<br/>
                <button type="button" onclick="modificarVotacion()" class="btn btn-info">Modificar votación</button>
            </div>
        <%
            }
            ContenidoEtapaDAO contenidoEtapaDAO = new ContenidoEtapaDAO();
            contenidoEtapaDAO.conectar();
            String sql = "SELECT * FROM contenidoetapa WHERE idContenido = " + idContenido + " AND idEtapa != 6 ORDER BY idEtapa ASC, version ASC";    
            List<Map<String, Object>> versiones = contenidoEtapaDAO.consultaGenerica(sql);
            Map<Integer,List<ContenidoEtapa>> versionesPorIdEtapa = new HashMap<Integer,List<ContenidoEtapa>>();
            for(Map<String,Object> version: versiones){
                versionMaxima[(int)version.get("idEtapa") - 1]++;
                List<ContenidoEtapa> aux = versionesPorIdEtapa.get((int)version.get("idEtapa"));
                if(aux == null){
                    aux = new ArrayList<>();
                }
                aux.add(new ContenidoEtapa().setIdContenido((int)version.get("idContenido"))
                                            .setIdEtapa(Short.parseShort((int)version.get("idEtapa") + ""))
                                            .setVersion(Short.parseShort((int)version.get("version") + ""))
                                            .setRutaRecursos((String)version.get("rutaRecursos"))
                                            .setTiempoModificacion((Timestamp)version.get("tiempoModificacion"))
                                            .setLiberado(false));
                versionesPorIdEtapa.put((int)version.get("idEtapa"), aux);
            }
            for(int i = 0; i < 5; i++){
                versionMaxima2 = versionMaxima[i] > versionMaxima2?versionMaxima[i]:versionMaxima2;
            }
            contenidoEtapaDAO.desconectar();
            %>
        <div class="container-fluid" id="principalVotacion" <%=ocultarDiv%>>
            <h2>Votaciones por etapa</h2>
            <br/>
            <br/>
            <form name="votacionForm" id="votacionForm" class="form-horizontal">
            <input type="hidden" id="idContenido" name="idContenido" value="<%=idContenido%>"/>
            <%=hiddenModificar%>
            <table class="table table-condensed" border="0">
                <thead>
                    <tr>
                        <%
                            out.println("<th>Etapa</th>");
                            for(int n = 1; n <= versionMaxima2; n++){
                                out.println("<th>Versión " + n + "</th>");
                            }
                            %>
                    </tr>
                </thead>
            <%
                for(int n = 1; n <= 5; n++){
                    out.println("<tr>");
                    out.println("<td>Etapa " + n);
                    int tdUsados = 0;
                    List<ContenidoEtapa> lista = versionesPorIdEtapa.get(n);
                    out.println("<div class=\"btn-group\">");
                    for(ContenidoEtapa elemento: lista){
                        tdUsados++;
                        out.println("<td align='center'>"
                                + "<input type='radio' name='etapa" + n + "' id='etapa" + n + "' value='" + elemento.getVersion() + "'checked>"
                                + ""
                                + "</td>");
                    }
                    out.println("</div>");
                    if(versionMaxima2 > tdUsados){
                        out.println("<td colspan='" + (versionMaxima2 - tdUsados) + "' ></td>");
                    }
                    out.println("</tr>");
                }
                %>
            <table>
            </form>
        </div>
    </body>
</html>
