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
public class Submenu implements EDVADB{
    private int idSubmenu;
    private String nombre;
    private String action;
    private String target;

    public int getIdSubmenu() {
        return idSubmenu;
    }

    public Submenu setIdSubmenu(int idSubmenu) {
        this.idSubmenu = idSubmenu;
        return this;
    }

    public String getNombre() {
        return nombre;
    }

    public Submenu setNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public String getAction() {
        return action;
    }

    public Submenu setAction(String action) {
        this.action = action;
        return this;
    }    

    public String getTarget() {
        return target;
    }

    public Submenu setTarget(String target) {
        this.target = target;
        return this;
    }
}
