package modelo.pojo;

/**
 *
 * @author DanHv
 */
public class PermisoMenu implements EDVADB {
    private int idMenu;
    private int idPerfil;

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getIdPerfil() {
        return idPerfil;
    }

    public void setIdPerfil(int idPerfil) {
        this.idPerfil = idPerfil;
    }
}
