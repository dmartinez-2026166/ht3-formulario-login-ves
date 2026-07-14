package com.diegomartinez.model;

public class Maestro extends Persona {
    private boolean activo;
    private String curso;
    private String grado;
    
    public Maestro() {
        super();
    }
    
    public Maestro (boolean activo, String curso, String grado, String nombres, String apellidos) {
        super(nombres, apellidos);
        this.activo = activo;
        this.curso = curso;
        this.grado = grado;
    }
    
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    @Override
    public String presentacionPersona() {
        
     return "Mi nombre es "  + this.nombres
                +"\nMi apellido es " + this.apellidos
                +"\nMi grado es " + this.grado
                +"\nMi curso es " + this.curso
                +"\nMi estado activo es " +this.activo;
    }

    @Override
    public String toString() {
        return "Maestro";
    }
}
