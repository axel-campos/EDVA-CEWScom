<%-- 
    Document   : finalizarVotacion
    Created on : 1/11/2016, 06:23:33 PM
    Author     : Víctor
--%>

<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.pojo.ContenidoEtapa"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="modelo.dao.ContenidoEtapaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/contenido/finalizarVotacion.js"></script>
        <title>Votación</title>
    </head>
    <body>
        <%
            int idContenido = 0, totalProfesores = 0, totalVotantes = 0;
            int versionEtapa [] = new int[5];
            String token = "";
            if(request.getParameter("token") != null){
                token = request.getParameter("token").toString();
            }
            if(request.getParameter("idContenido") != null){
                idContenido = Integer.parseInt(request.getParameter("idContenido"));
            }
            ContenidoEtapaDAO contenidoEtapaDAO = new ContenidoEtapaDAO();
            contenidoEtapaDAO.conectar();
            String numeroVotantesQuery = "SELECT COUNT(*) AS numeroVotantes, 'numeroVotantes' AS fila FROM usuariovotacion WHERE idVotacion = " +
                "(SELECT idVotacion FROM votacion WHERE idContenido = " + idContenido + " AND idEtapa = 1) " +
                "UNION " +
                "SELECT g.totalProfesores AS numeroVotantes, 'totalVotantes' AS fila FROM grupo AS g " +
                "INNER JOIN contenido c ON c.idContenido = " + idContenido + " AND g.token = c.token";
            List<Map<String,Object>> resultNumeroVotantes = contenidoEtapaDAO.consultaGenerica(numeroVotantesQuery);
            for(Map<String, Object> tupla : resultNumeroVotantes){
                if(tupla.get("fila").toString().equals("numeroVotantes")){
                    totalVotantes = Integer.parseInt(tupla.get("numeroVotantes").toString());
                }else{
                    totalProfesores = Integer.parseInt(tupla.get("numeroVotantes").toString());
                }
            }
            %>
        <div class="container-fluid">
            <center>
                <h2>Resumen votación</h2>
                <div style="width: 50%">
                    <table class="table table-condensed">
                        <thead>
                            <tr>
                                <th>Profesores del grupo</th>
                                <th>Número de votos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="active">
                                <td><%= totalProfesores %></td>
                                <td><%= totalVotantes %></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </center>
            <br/>
            <form name="finalizarVotacionForm" id="finalizarVotacionForm" class="form-horizontal">
            <input type="hidden" id="idContenido" name="idContenido" value="<%=idContenido%>"/>
            <input type="hidden" id="token" name="token" value="<%=token%>"/>
            <%
                int []versionMaxima = new int[5];
                int versionMaxima2 = 1;
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
                %>
                <table class="table table-condensed" border="0">
                <thead>
                    <tr>
                        <%
                            out.println("<th>Etapa</th>");
                            for(int n = 1; n <= versionMaxima2; n++){
                                out.println("<th>versión " + n + "</th>");
                            }
                            %>
                    </tr>
                </thead>
                <%
                int [] versionGanador = new int[5];
                Map<Integer,List<Integer>> versionesConflicto = new HashMap<Integer,List<Integer>>();
                for(int n = 1; n <= 5; n++){
                    out.println("<tr>");
                    out.println("<td>Etapa " + n);
                    int tdUsados = 0, numeroMaximoVotos = 0;
                    List<ContenidoEtapa> lista = versionesPorIdEtapa.get(n);
                    for(ContenidoEtapa elemento: lista){
                        String query = "SELECT COUNT(*) AS votos FROM usuariovotacion WHERE idVotacion = "
                                + "(SELECT idVotacion FROM votacion WHERE idContenido = " + idContenido 
                                + " AND idEtapa = " + elemento.getIdEtapa() + ") AND version = " + elemento.getVersion();
                        List<Map<String,Object>> votos = contenidoEtapaDAO.consultaGenerica(query);
                        for(Map<String, Object> voto: votos){
                            out.println("<td align='center'>" + voto.get("votos") + "</td>");
                            int numVotos = Integer.parseInt(voto.get("votos").toString());
                            if(numVotos > numeroMaximoVotos){
                                numeroMaximoVotos = numVotos;
                                if(versionesConflicto.get(n) != null){
                                    List<Integer> aux = versionesConflicto.get(n);
                                    aux.clear();
                                    aux.add(elemento.getVersion());
                                }else{
                                    List<Integer> aux = new ArrayList<>();
                                    aux.add(elemento.getVersion());
                                    versionesConflicto.remove(n);
                                    versionesConflicto.put(n, aux);
                                }
                            }else if(numVotos == numeroMaximoVotos && numVotos != 0){
                               List<Integer> aux = versionesConflicto.get(n);
                               aux.add(elemento.getVersion());
                            }
                        }
                    }
                    if(versionMaxima2 > tdUsados){
                        out.println("<td colspan='" + (versionMaxima2 - tdUsados) + "' ></td>");
                    }
                    out.println("</tr>");
                }
                %>
            <table>
            <table class="table table-condensed" border="0">
                <tr>
                <%
                    for(int n = 1; n <= 5; n++){
                        if(versionesConflicto.get(n).size() == 1){
                            out.println("<input type='hidden' id='etapa" + n + "' name='etapa" + n + "' value='" + versionesConflicto.get(n).get(0) + "' >");
                        }else{
                            List<Integer> rama = versionesConflicto.get(n);
                            out.println("<td>Etapa: " + n + "<td/>");
                            out.println("<td><select class='form-control' id='etapa" + n + "' name='etapa" + n + "'>");
                            for(Integer ramita : rama){
                                out.println("<option value='" + ramita + "'> Version " + ramita + "</option>");
                            }
                            out.println("</select>"
                                    + "</td>");
                        }
                    }
                %>
                </tr>
            </table>
            </form>
        </div>
    </body>
</html>
