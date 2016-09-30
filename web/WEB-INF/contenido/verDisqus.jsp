<%-- 
    Document   : verDisqus
    Created on : 29/09/2016, 05:59:26 PM
    Author     : Víctor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String identificadorDisqus = "", paginaDisqus = "";
    if(request.getParameter("idContenido") != null){
       identificadorDisqus = "id" + request.getParameter("idContenido");
       paginaDisqus = "pagina" + request.getParameter("idContenido");
    }
    %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foro</title>
        <script>            
            var disqus_config = function () {
                this.page.url = "http://localhost:8084/EDVA/#!<%= paginaDisqus %>";  // Replace PAGE_URL with your page's canonical URL variable
                this.page.identifier = '<%= identificadorDisqus %>'; // Replace PAGE_IDENTIFIER with your page's unique identifier variable
            };

            (function() { // DON'T EDIT BELOW THIS LINE
                var d = document, s = d.createElement('script');
                s.src = '//http-localhost-8084-edva.disqus.com/embed.js';
                s.setAttribute('data-timestamp', +new Date());
                (d.head || d.body).appendChild(s);
            })();
        </script>
        <noscript>Please enable JavaScript to view the <a href="https://disqus.com/?ref_noscript">comments powered by Disqus.</a></noscript>
    </head>
    <body>
        <div class="panel">
            <div class="panel-body">
                <div id="disqus_thread"></div>
            </div>
        </div>
    </body>
</html>
