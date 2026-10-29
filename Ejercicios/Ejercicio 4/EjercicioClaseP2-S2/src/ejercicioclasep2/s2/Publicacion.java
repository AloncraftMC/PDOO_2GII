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
public class Publicacion {
    private String contenido;
    protected long fecha;
    private List<Comentario> comentarios; // Título de la asociación: tiene

    public Publicacion(String contenido, long fecha) {
        this.contenido = contenido;
        this.fecha = fecha;
        this.comentarios = new ArrayList<>();
    }

    public void agregarComentario(String txt) {
        Comentario cm = new Comentario(txt);
        comentarios.add(cm);
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public String getContenido() {
        return contenido;
    }

    public static int contarComentarios(Publicacion publicacion) {
        return publicacion.comentarios.size();
    }

    @Override
    public String toString() {
        return "Esta publicación fue creada el "+Utils.convertMillisToString(fecha);
    }
    
}
