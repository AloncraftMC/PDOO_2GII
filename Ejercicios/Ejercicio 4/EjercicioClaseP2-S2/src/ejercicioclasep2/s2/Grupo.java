/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasep2.s2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bihut
 */
public class Grupo {
    private String nombre;
    private static final int MAX_MIEMBROS=10;
    private List<Usuario> miembros; // Título de la asociación: tiene

    public Grupo(String nombre) {
        this.nombre = nombre;
        this.miembros = new ArrayList<>();
    }

    public void agregarMiembro(Usuario usuario) {
        if (miembros.size() < Grupo.MAX_MIEMBROS) {
            miembros.add(usuario);
        } else {
            System.out.println("El grupo está lleno.");
        }
    }

    public List<Usuario> getMiembros() {
        return miembros;
    }

    public String getNombre() {
        return nombre;
    }


}