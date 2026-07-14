package org.diegomartinez.model;

public class Estudiante extends Persona {
    private String grado;
    private int numeroCarne;
    private boolean esAprobado;
    
    public Estudiante () {
        super();
    }
    
    public Estudiante(String grado, int numeroCarne, boolean esAprobado, String nombres, String apellidos) {
        super(nombres, apellidos);
        this.grado = grado;
        this.numeroCarne = numeroCarne;
        this.esAprobado = esAprobado;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public int getNumeroCarne() {
        return numeroCarne;
    }

    public void setNumeroCarne(int numeroCarne) {
        this.numeroCarne = numeroCarne;
    }

    public boolean isEsAprobado() {
        return esAprobado;
    }

    public void setEsAprobado(boolean esAprobado) {
        this.esAprobado = esAprobado;
    }

    @Override
    public String presentacionPersona() {
        return "Mi nombre es " + this.nombres
                +"\nMi apellido es " + this. apellidos
                +"\nMi grado es " + this.grado
                +"\nMi carne es " + this.numeroCarne
                +"\nMi estado aprobado es " +this.esAprobado;
    }
    
    @Override
    public String toString() {
        return  "Estudiante";
    }
}
