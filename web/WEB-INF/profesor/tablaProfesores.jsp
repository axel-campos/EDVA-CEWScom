<%-- 
    Document   : listaReportes
    Created on : 20/08/2016, 08:27:05 PM
    Author     : Víctor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="sj" uri="/struts-jquery-tags"%>

<%@taglib uri="/struts-tags" prefix="s"%>
<%
    String cabeceras[] = {"Correo","Nombre","Cedula","Eliminar"}; 
    String nombre = "", cedula = "", correo = "";
    boolean busco = false;
    if(session.getAttribute("nombre") != null){
        nombre = session.getAttribute("nombre").toString();
        session.removeAttribute("nombre");
    }
    if(session.getAttribute("cedula") != null){
        cedula = session.getAttribute("cedula").toString();
        session.removeAttribute("cedula");
    }
    if(session.getAttribute("correo") != null){
        correo = session.getAttribute("correo").toString();
        session.removeAttribute("correo");
    }
    if(session.getAttribute("busco") != null){
        busco = (Boolean)session.getAttribute("busco");
        session.removeAttribute("busco");
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${pageContext.request.contextPath}/js/paginas/profesor/tablaProfesores.js"></script>
        <title>Profesores</title>
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
        </div>
        <div id="filtros" class="container-fluid">
            <form id="frmFiltros" name="frmFiltros" class="form-inline">
                <div class="form-group col-md-3">
                    <label for="correo">Correo:</label>
                        <input type="text" id="correo" name="correo" class="form-control" value="<%= correo%>">
                </div>
                <div class="form-group col-md-4">
                    <label for="cedula">Cedula:</label>
                        <input type="text" id="cedula" name="cedula" class="form-control" value="<%= cedula%>">
                </div>
                <div class="form-group col-md-4">
                    <label for="rol">Nombre: </label>
                        <input type="text" id="nombre" name="nombre" class="form-control" value="<%= nombre%>">
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
                                <td><a onclick="mostrarInformacion('<s:property value="%{#resultado[0]}"/>');" class="btn btn-link"><s:property value="%{#resultado[0]}" /></a></td>
                                <td><s:property value="%{#resultado[1]}" /></td>
                                <td><s:property value="%{#resultado[2]}" /></td>
                                <td>
                                    <a href="#" onclick="eliminarProfesor('<s:property value="%{#resultado[0]}" />')">
                                    <span class="glyphicon glyphicon-trash" style="min-width: 20px; min-height: 20px"></span></a>    
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>        
            <% }%>
        </div>
    </body>
</html>
