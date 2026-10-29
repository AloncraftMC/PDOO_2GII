/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicioclasep2.s2;

/**
 *
 * @author bihut
 */
public class Comentario {
    private String texto;
    protected int likes;

    public Comentario(String texto) {
        this.texto = texto;
        this.likes = 0; 
    }

    public String getTexto() {
        return texto;
    }

    public void agregarLike() {
        likes++;
    }

    public int getLikes() {
        return likes;
    }
}