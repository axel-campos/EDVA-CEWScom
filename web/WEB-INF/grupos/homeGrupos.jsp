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
        <div class="embed-responsive embed-responsive-16by9" style="border: 3px solid #8AC007;">
            <div class="menu1">
                <h1>INFO 1</h1>
            </div>
            <div class="menu2">
                <h1>INFO 2</h1>
            </div>
            <div class="contenido">
                <h1>contenido</h1>
            </div>
        </div>
    </body>
</html>
