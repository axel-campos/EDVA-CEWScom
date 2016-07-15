<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expended="false">
                            <span class="glyphicon glyphicon-user"></span> Reload <span class='caret'></span>
                        </a>
                        <div style="color: #449d44">
                            Hoy te vas!!!
                        </div>
                        <!--ul class="dropdown-backdrop">
                            <li><a onclick="cambiarContenidos('modInformacion','#contenido')" style="cursor:pointer">Mi cuenta</a></li>
                            <li><a href="logout.action">Cerrar Sesión</a></li>
                        </ul-->
                    </li>
                    <li>Camino</li>
                </ul>
            </div>
            <!--Page content -->
        </div>
        
        <!--div class="container container-fluid" style="width: 100%;" id="caja">
            <div class="row-fluid">
                <div class="col-sm-3 well" id="sidebar">
                    <div class="well" id="divInfo1" style="overflow: auto; height: 45%">
                        INFO 1
                    </div>
                    <div class="well" id="divInfo2" style="overflow: auto; height: 50%">
                        <div class='container-fluid'>
                            X-MEN
                        </div>
                    </div>
                </div>
                <div class="col-sm-9" id="content">
                    <div class="panel panel-default">
                        <div class="panel-body" style="overflow: auto">
                            Contenido
                        </div>
                    </div>
                </div>
            </div>
        </div-->
    </body>
    <script>
            
            /*$("#divInfo1").height((height * 0.335));
            $("#divInfo2").height((height * 0.335));*/
            /*$("#sidebar").height(height * 0.825);
            $("#content").height(height * 0.83);*/
        //});
    </script>
</html>
