package com.diegomartinez.model;

public class Usuario {

    private String userName;
    private String password;
    private String nombreCompleto;
    private String rol;

    public Usuario(String userName, String password, String nombreCompleto, String rol) {
        this.userName = userName;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

}
