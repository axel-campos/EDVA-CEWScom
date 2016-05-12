/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.pojo;

/**
 *
 * @author DanHv
 */
public class Menu implements EDVADB{
    private int idMenu;
    private String nombre;
    private String action;
    private String target;

    public int getIdMenu() {
        return idMenu;
    }

    public Menu setIdMenu(int idMenu) {
        this.idMenu = idMenu;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Menu setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getAction() {
        return action;
    }

    public Menu setAction(String action) {
        this.action = action;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public Menu setTarget(String target) {
        this.target = target;
        return this;
    }
}
