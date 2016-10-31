<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Files"%>
<%@page import="org.apache.struts2.ServletActionContext"%>
<%@page import="modelo.dao.*"%>
<%@page import="modelo.pojo.*"%>
<%@page import="java.util.List"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<div class="page-head">
    <div class="header-nav ">
        <div class="logo wow fadeInUp animated" data-wow-delay=".5s">
            <h1>
                <a class="link link--kumya" style="cursor:pointer;" onclick="cambiarContenidos('principal','#contenido');"><i></i><span data-letters="CWEScom">CWEScom</span></a>
            </h1>
        </div>
        <div class="top-nav wow fadeInUp animated" data-wow-delay=".5s">										 
            <label class="mobile_menu" for="mobile_menu"><span>Menú</span></label>
                <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <%
                    MenuDAO menuDAO = new MenuDAO();
                    menuDAO.conectar();
                    Usuario user = (Usuario)session.getAttribute("usuario");
                    List<Menu> menu = menuDAO.buscarTodos(user.getTipo());
                    for(Menu m : menu){
                        SubmenuDAO submenuDAO = new SubmenuDAO();
                        submenuDAO.conectar();
                        List<Submenu> submenu = submenuDAO.buscarSubMenu(m.getIdMenu());
                        if(!submenu.isEmpty()){//Queda pendiente para ver como funciona normal :v!!!
                            out.println("\t\t\t\t<li>");
                            out.println("\t\t\t\t\t<a href='#' class='dropdown-toggle' data-toggle='dropdown' role='button' aria-haspopup='true' aria-expended='false'>"+
                                    m.getNombre()+" <span class='caret'></span></a>");
                            out.println("\t\t\t\t\t<ul class='dropdown-menu'>");
                            for(Submenu sm : submenu){
                                out.println("\t\t\t\t\t\t<li><a onclick='cambiarContenidos(\""+m.getAction()+"\",\""+m.getTarget()+"\")' style='cursor:pointer'>"+sm.getNombre()+"</a></li>");
                            }
                            out.println("\t\t\t\t\t</ul>");
                            out.println("\t\t\t\t</li>");
                        }else{                            
                            out.println("\t\t\t\t<li><a onclick='cambiarContenidos(\""+m.getAction()+"\",\""+m.getTarget()+"\")' style='cursor:pointer;'>"+m.getNombre()+"</a></li>");
                        }
                        submenuDAO.desconectar();
                    }
                    
                    String nombre = user.getNombre();
                    /*String nombreCompleto = user.getNombre() + " " + user.getAPaterno();
                    if(user.getAMaterno() != null){
                        nombreCompleto += " " + user.getAMaterno();
                    }*/
                    menuDAO.desconectar();
                %>
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expended="false">
                            <s:if test="%{#session.usuario.facebook == 1}">
                                <img src="${session.usuario.avatar}" width="25" class="img-circle"/> <%= nombre%> <span class='caret'></span>
                            </s:if>
                            <s:else>
                                <img src="${pageContext.request.contextPath}/images/${session.usuario.avatar}" width="25" class="img-circle"/> <%= nombre%> <span class='caret'></span>
                            </s:else>
                            
                        </a>
                        <ul class="dropdown-menu">
                            <li><a onclick="cambiarContenidos('modInformacion','#contenido')" style="cursor:pointer">Mi cuenta</a></li>
                            <li><a href="logout.action">Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul>
                <!--ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expended="false">
                            <img src="{pageContext.request.contextPath}/images/{session.usuario.avatar}" width="18" class="img-circle"/> <!%= nombre%> <span class='caret'></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a onclick="cambiarContenidos('modInformacion','#contenido')" style="cursor:pointer">Mi cuenta</a></li>
                            <li><a href="logout.action">Cerrar Sesión</a></li>
                        </ul>
                    </li>
                </ul-->
        </div>
        <div class="clearfix"></div>
    </div>
</div>