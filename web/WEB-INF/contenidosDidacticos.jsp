<%-- 
    Document   : contenidosDidacticos
    Created on : 11/07/2016, 05:48:48 PM
    Author     : V�ctor
--%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Expandable Grid for Twitter Bootstrap</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="Very Lightweight Portfolio Filter for Bootstrap">
        <meta name="author" content="geedmo">
        <!-- Le styles -->
        <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/bootstrap-responsive.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/gridex.css" rel="stylesheet">
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
        <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

        <style>
			html, body {
				height: 100%;
				color: #656565;
			}

			a:focus {
				outline: none;
			}

			.wrapper {
				min-height: 100%;
				height: auto !important;
				height: 100%;
				margin: 0 auto -120px;
			}
			.footer, .push {
				height: 120px;
			}


        </style>
    </head>

    <body>

        <div class="container wrapper">

            <br />
            <h2>Grid Expander for Bootstrap</h2>
            <p class="lead">An expandable grid for Twitter Bootstrap</p>
            <hr>
            <div class="clearfix"></div>

            <br />

            <ul class="thumbnails gridex">
                <li class="span3 clearfix">
                    <a href="#" class="thumbnail"> <img alt="270x170" src="http://placehold.it/270x170" /> </a>
                    <!-- gd-expander required -->
                    <div class="gd-expander">
                    	<!-- gd-inner optional -->
                        <div class="gd-inner">
                            <div class="row-fluid">
                                <div class="span6 text-center">
                                    <img alt="270x170" class="img-polaroid" src="http://placehold.it/370x270" />
                                </div>
                                <div class="span6">
                                    <h2>Heading text 1</h2>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                    </p>
                                    <a href="#" class="btn btn-success">Visit Website</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <a class="thumbnail" > <img alt="270x170" src="http://placehold.it/270x170" /> </a>
                    <div class="gd-expander">
                        <div class="gd-inner">
                        	<div class="row-fluid">
                                <div class="span6 text-center">
                                    <img alt="270x170" class="img-polaroid" src="http://placehold.it/370x270" />
                                </div>
                                <div class="span6">
                                    <h2>Heading text 2</h2>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                    </p>
                                    <a href="#" class="btn btn-success">Visit Website</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <a href="#" class="thumbnail">
                        <img alt="270x170" src="http://placehold.it/270x170" />
                    </a>
                    <div class="gd-expander">
                        <div class="gd-inner">
                        	<div class="row-fluid">
                                <div class="span6 text-center">
                                    <img alt="270x170" class="img-polaroid" src="http://placehold.it/370x270" />
                                </div>
                                <div class="span6">
                                    <h2>Heading text 2</h2>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                    </p>
                                    <a href="#" class="btn btn-success">Visit Website</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="span3">
                    <a hreF="#" class="thumbnail">
                        <img alt="270x170" src="http://placehold.it/270x170" />
                    </a>
                    <div class="gd-expander">
                        <div class="gd-inner">
                        	<div class="row-fluid">
                                <div class="span6 text-center">
                                    <img alt="270x170" class="img-polaroid" src="http://placehold.it/370x270" />
                                </div>
                                <div class="span6">
                                    <h2>Heading text 3</h2>
                                    <p>
                                        Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                                    </p>
                                    <a href="#" class="btn btn-success">Visit Website</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
            
            <div class="push"></div>
        </div>

        <!-- /container -->

        <!-- Footer
        ================================================== -->
        <footer class="footer">
            <div class="container">
                <hr>
                <p>
                    by Geedmo.
                </p>
                <p>
                    2013 &copy; All rights shared.
                </p>
            </div>
        </footer>
        <!-- Le javascript
        ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        <script src="${pageContext.request.contextPath}/js/bootstrap/bootstrap-gridex.js"></script>

        <script>
			$(function() {
				$('.gridex').gridex();
			})
        </script>
    </body>
</html>