<%-- 
    Document   : verVotacion
    Created on : 18/10/2016, 07:01:49 PM
    Author     : Víctor
--%>

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
            int idContenido = 0;
            int versionMaxima2 = 1;
            int []versionMaxima = new int[5];
            SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            if(request.getParameter("idContenido") != null){
                idContenido = Integer.parseInt(request.getParameter("idContenido"));
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
        <div class="container-fluid">
            <h2>Votaciones por etapa</h2>
            <br/>
            <br/>
            <form name="votacionForm" id="votacionForm">
            <input type="hidden" id="idContenido" name="idContenido" value="<%=idContenido%>"/>
            <table class="table" border="0">
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
                    for(ContenidoEtapa elemento: lista){
                        tdUsados++;
                        out.println("<td align='center'><input type='radio' name='etapa" + n + "' id='etapa" + n + "' value='" + elemento.getVersion() + "'></td>");
                    }
                    if(versionMaxima2 > tdUsados){
                        out.println("<td colspan='" + (versionMaxima2 - tdUsados) + "'");
                    }
                    out.println("</tr>");
                }
                %>
            <table>
            </form>
        </div>
    </body>
</html>
