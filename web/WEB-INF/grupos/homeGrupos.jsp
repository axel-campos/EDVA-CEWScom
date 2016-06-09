<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            div.contenedor{
                position: relative;
                width: 100%;
                height: inherit;
                border: 3px solid #8AC007;
            }
            div.menu1{
                position: absolute;
                width: 25%;
                height: 50%;
                top:0%;
                border: 3px solid #003eff;
            }
            div.menu2{
                position: absolute;
                width: 25%;
                height: 50%;
                top: 50%;
                border: 3px solid #003eff;
            }
            div.contenido{
                position: absolute;
                width: 75%;
                height: 100%;
                border: 3px solid #003eff;
                left: 25%;
                top:0%;
            }
        </style>
    </head>
    <body>
        <div class="container container-fluid" style="width: 100%;border: 3px solid #003399">
            <div class="row-fluid">
                <div class="col-sm-2 well">
                    <div class="well">
                        INFO 1
                    </div>
                    <div class="well">
                        INFO 2
                    </div>
                </div>
                <div class="col-sm-10">
                    <div class="panel panel-default">
                        <div class="panel-body">
                            Contenido
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
