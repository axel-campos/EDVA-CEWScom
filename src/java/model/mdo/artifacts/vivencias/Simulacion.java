package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Simulacion implements MDOArtifact {

    private String titulo;
    private String tematica;
    private String descripcion;
    private String roles;
    private String materialNecesario;
    private String procedimiento;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getMaterialNecesario() {
        return materialNecesario;
    }

    public void setMaterialNecesario(String materialNecesario) {
        this.materialNecesario = materialNecesario;
    }

    public String getProcedimiento() {
        return procedimiento;
    }

    public void setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
    }

    @Override
    public String toHtml() {
        return String.format("");
    }
    
    
    
}
