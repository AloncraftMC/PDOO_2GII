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
public class Usuario {
    private String nombre;
    protected String correo;
    private List<Usuario> amigos;       // Título de la asociación: tiene
    private List<Publicacion> publicaciones; // Título de la asociación: hace
    private TipoUsuario tipo;
    private long fechaCreacion;
    public Usuario(String nombre, String correo,TipoUsuario tipo) {
        this.nombre = nombre;
        this.correo = correo;
        this.amigos = new ArrayList<>();
        this.publicaciones = new ArrayList<>();
        this.tipo = tipo;
        fechaCreacion = Utils.getMarcaTiempo();
    }

    public TipoUsuario getTipo() {
        return tipo;
    }

    public void actualizarTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        String str = "El usuario "+nombre+" tiene "+amigos.size()+" amigos y se registró el "+Utils.convertMillisToString(fechaCreacion);
        return str;
    }
    
    
   

    // Método de clase que cuenta los usuarios registrados (simplificado)
    public static int contarUsuarios(List<Usuario> usuarios) {
        return usuarios.size();
    }

    public void agregarAmigo(Usuario amigo) {
        amigos.add(amigo);
    }

    public void hacerPublicacion(Publicacion publicacion) {
        publicaciones.add(publicacion);
    }

    public List<Publicacion> getPublicaciones() {
        return publicaciones;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public String getNombre() {
        return nombre;
    }

    // Método protegido para obtener el correo
    protected String getCorreo() {
        return correo;
    }
}