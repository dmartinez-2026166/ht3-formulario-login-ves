package com.diegomartinez.controller;

import java.util.ArrayList;
import com.diegomartinez.model.Usuario;

public class AuthSystem {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public AuthSystem() {
        // Pre-cargar al menos 3 usuarios diferentes como pide la guía
        usuarios.add(new Usuario("admin", "1234", "Diego Martinez", "Admin"));
        usuarios.add(new Usuario("user1", "abcd", "Juan Pérez", "User"));
        usuarios.add(new Usuario("profe", "kinal2026", "Instructor Taller", "Admin"));
    }

    public Usuario login(String user, String pass) {
        for (Usuario u : usuarios) {
            if (u.getUserName().equals(user) && u.getPassword().equals(pass)) {
                return u;
            }
        }
        return null;
    }
}
