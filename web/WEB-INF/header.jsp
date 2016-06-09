<%@page import="modelo.dao.*"%>
<%@page import="modelo.pojo.*"%>
<%@page import="java.util.List"%>
<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toogle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">EDVA CWEScom </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <%
                    MenuDAO menuDAO = new MenuDAO();
                    menuDAO.conectar();
                    Usuario user = (Usuario)session.getAttribute("usuario");
                    List<Menu> menu = menuDAO.buscarTodos(user.getTipo());
                    for(Menu m : menu){
                        SubmenuDAO submenuDAO = new SubmenuDAO();
                        submenuDAO.conectar();
                        List<Submenu> submenu = submenuDAO.buscarSubMenu(m.getIdMenu());
                        if(!submenu.isEmpty()){
                            out.println("\t\t\t\t<li class='dropdown'>");
                            out.println("\t\t\t\t\t<a href='"+m.getAction()+"' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expended='false'>"+
                                    m.getNombre()+" <span class='caret'></span></a>");
                            out.println("\t\t\t\t\t<ul class='dropdown-menu'>");
                            for(Submenu sm : submenu){
                                out.println("\t\t\t\t\t\t<li><a href='"+sm.getAction()+"' target='"+sm.getTarget()+"'>"+sm.getNombre()+"</a></li>");
                            }
                            out.println("\t\t\t\t\t</ul>");
                            out.println("\t\t\t\t</li>");
                        }else{
                            //out.println("\t\t\t\t<li><a href='"+m.getAction()+"' target='"+m.getTarget()+"'>"+m.getNombre()+"</a></li>");
                            out.println("\t\t\t\t<li><a onclick='cambiarContenidos(\""+m.getAction()+"\",\""+m.getTarget()+"\")' style='cursor:pointer;'>"+m.getNombre()+"</a></li>");
                            
                            //<!--li><a href="#" onclick="cambiarContenidos()"></a></li-->
                            
                        }
                        submenuDAO.desconectar();
                    }
                    String nombre = user.getNombre() + " " + user.getAPaterno() + " " + user.getAMaterno();
                    menuDAO.desconectar();
                %>
                <li><a href="logout.action">Cerrar Sesión</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%= nombre%></a></li>
            </ul>
        </div>
    </div>
</nav>