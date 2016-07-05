<%-- 
    Document   : login
    Created on : 23/01/2016, 10:20:07 PM
    Author     : DanHv
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="utf-8">
    <meta http-equiv=X-UA-Compatible content="IE=edge">
    <meta name=viewport content="width=device-width, initial-scale=1">
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/bootstrapValidator.css" rel="stylesheet">
    <title>Iniciar Sesión</title>
	<script>
		// This is called with the results from from FB.getLoginStatus().
		function statusChangeCallback(response) {      
			console.log(response);
			// The response object is returned with a status field that lets the
			// app know the current login status of the person.
			// Full docs on the response object can be found in the documentation
			// for FB.getLoginStatus().
			if (response.status === 'connected') {
			  // Logged into your app and Facebook.
			  testAPI();
			} else if (response.status === 'not_authorized') {
			  // The person is logged into Facebook, but not your app.
			  document.getElementById('status').innerHTML = 'Please log ' +
				'into this app.';
			} else {
			  // The person is not logged into Facebook, so we're not sure if
			  // they are logged into this app or not.
			  document.getElementById('status').innerHTML = 'Please log ' +
				'into Facebook.';
			}
		}

		// This function is called when someone finishes with the Login
		// Button.  See the onlogin handler attached to it in the sample
		// code below.
		function checkLoginState() {
            FB.login(statusChangeCallback, {scope:'user_birthday, email'});
		}

		// Here we run a very simple test of the Graph API after login is
		// successful.  See statusChangeCallback() for when this call is made.
		function testAPI() {
			FB.api(
                '/me',
                'GET',
                {"fields":"id,first_name,last_name,email,birthday"},
                function(response) {
                    // Insert your code here
                    inicioSesionFacebook(response['email'], response['first_name'], response['last_name'], response['birthday']);
                }
              );
		}
	</script>
    </head>
    <body>
        <h1>EDVA CWEScom</h1>
		<br>
        <div class="container-fluid">
            <div class="panel panel-default">
                <div class="panel-heading">Iniciar Sesión</div>
                <div class="panel-body">
                    <form id="loginfrm" method="POST" action="login" class="form-horizontal">
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="correo">Correo Electrónico</label>
                            <div class="col-md-4">
                                <input type="text" class="form-control" id="correo" name="correo" placeholder="mi_correo@example.com"/>
                                <i class="glyphicon glyphicon-user form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group has-feedback">
                            <label class="col-md-2 control-label" for="password">Contraseña</label>
                            <div class="col-md-4">
                                <input type="password" class="form-control" id="password" name="password"/>
                                <i class="glyphicon glyphicon-inbox form-control-feedback"></i>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-md-6 col-md-offset-2">
                                <!--input type="submit" class="btn btn-primary" value="Entrar"/-->
                                <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-log-in"></span>  Entrar</button>
                                <a href="registrarseform" class="btn btn-link">¿Aún no tienes una cuenta? Regístrate aquí</a>
                            </div>
                            <label for="error" style="margin:100px auto 60px auto;color:Red; line-height:40px;font-size:medium;display:none">Un error ha ocurrido en su solicitud</label>
                        </div>
                    </form>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-2">
                            <div id="fb-root"></div>
                            <script>
                                    (function(d, s, id) {
                                            var js, fjs = d.getElementsByTagName(s)[0];
                                            if (d.getElementById(id)) return;
                                            js = d.createElement(s); js.id = id;
                                            js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.5&appId=224685294534432";
                                            fjs.parentNode.insertBefore(js, fjs);
                                      }(document, 'script', 'facebook-jssdk'));
                            </script>
                            <div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="false" onlogin="checkLoginState();"></div>
                            <!--div class="fb-like" data-share="true" data-width="450" data-show-faces="true"></div-->
                            <div id="status"></div>
                        </div>
                    </div>
                </div>               
                <s:if test="hasActionErrors()">
                        <div class="alert alert-danger">
                                <s:actionerror />
                        </div>
                </s:if>
            </div>
        </div>   
    </body>
    <script src="${pageContext.request.contextPath}/js/jquery/jquery-1.9.1.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap.min.js"></script>    
    <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrapValidator.js"></script>
    <script src="${pageContext.request.contextPath}/js/paginas/login.js"></script>
</html>
