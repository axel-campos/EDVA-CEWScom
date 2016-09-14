<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@page import="modelo.pojo.Etapa"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container container-fluid">
            <div class="container-fluid">
                <form id="frmTiempos" name="frmTiempo" class="form-inline">
                    <div class="form-group col-md-4">
                        <label for="etapa">Etapa:</label>
                        <select id="etapa" name="etapa" class='form-control'>
                            <option value='0'>Seleccione una etapa</option>
                            <s:iterator value="etapas" var="etapa">
                                <option value='<s:property value="%{#etapa.getIdEtapa()}"/>'><s:property value="%{#etapa.getNombre()}"/></option>                                
                            </s:iterator>
                        </select>
                    </div>
                    <br>
                    <div class='table-responsive'>
                        <table>
                            <thead>
                                <tr>
                                    <th>Versión</th>
                                </tr>
                            </thead>
                        </table>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
