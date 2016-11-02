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
        FB.login(statusChangeCallback, {scope:'public_profile,user_birthday, email'});
    }

    // Here we run a very simple test of the Graph API after login is
    // successful.  See statusChangeCallback() for when this call is made.
    function testAPI() {
        FB.api(
            '/me',
            'GET',
            {"fields":"id,first_name,last_name,email,birthday,picture"},
            function(response) {
                // Insert your code here
                inicioSesionFacebook(response['email'], response['first_name'], response['last_name'], response['birthday'], response['picture']['data']['url']);
            }
          );
    }
</script>
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h2 style="text-align: center">Inicio de sesión</h2>
            </div>
            <div class="modal-body modal-spa">
                <script>
                    (function(d, s, id) {
                        var js, fjs = d.getElementsByTagName(s)[0];
                        if (d.getElementById(id)) return;
                        js = d.createElement(s); js.id = id;
                        js.src = "//connect.facebook.net/en_GB/sdk.js#xfbml=1&version=v2.5&appId=224685294534432";
                        fjs.parentNode.insertBefore(js, fjs);
                    }(document, 'script', 'facebook-jssdk'));
                </script>
                <form id="loginfrm" method="POST" action="login" class="form-horizontal">
                    <div class="form-group has-feedback">
                        <label class="col-md-4 control-label" for="correo">Correo Electrónico</label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="correo" name="correo" placeholder="mi_correo@example.com"/>
                            <i class="glyphicon glyphicon-user form-control-feedback"></i>
                        </div>
                    </div>
                    <div class="form-group has-feedback">
                        <label class="col-md-4 control-label" for="password">Contraseña</label>
                        <div class="col-md-6">
                            <input type="password" class="form-control" id="password" name="password"/>
                            <i class="glyphicon glyphicon-inbox form-control-feedback"></i>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-6 col-md-offset-4">
                            <!--input type="submit" class="btn btn-primary" value="Entrar"/-->
                            <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-log-in"></span>  Entrar</button>
                            <a href="registrarseform" class="btn btn-link">¿Aún no tienes una cuenta? Regístrate aquí</a>
                        </div>
                        <div class="col-md-6 col-md-offset-4">
                            <div id="fb-root"></div>
                            <div class="fb-login-button" data-max-rows="1" data-size="medium" data-show-faces="false" data-auto-logout-link="false" onlogin="checkLoginState();"></div>
                            <!--div class="fb-like" data-share="true" data-width="450" data-show-faces="true"></div-->
                            <div id="status"></div>
                        </div>
                        <!--label for="error" style="margin:100px auto 60px auto;color:Red; line-height:40px;font-size:medium;display:none">Un error ha ocurrido en su solicitud</label-->
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
