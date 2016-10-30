package model.mdo.artifacts.vivencias;

import model.mdo.artifacts.MDOArtifact;

public class Simulacion implements MDOArtifact {

    private String titulo;
    private String tematica;
    private String descripcion;
    private String roles;
    private String materialNecesario;
    private String procedimiento;

    public Simulacion setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public Simulacion setTematica(String tematica) {
        this.tematica = tematica;
        return this;
    }

    public Simulacion setDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Simulacion setRoles(String roles) {
        this.roles = roles;
        return this;
    }

    public Simulacion setMaterialNecesario(String materialNecesario) {
        this.materialNecesario = materialNecesario;
        return this;
    }

    public Simulacion setProcedimiento(String procedimiento) {
        this.procedimiento = procedimiento;
        return this;
    }

    @Override
    public String toHtml() {
        return String.format("");
    }
    
    
    
}
