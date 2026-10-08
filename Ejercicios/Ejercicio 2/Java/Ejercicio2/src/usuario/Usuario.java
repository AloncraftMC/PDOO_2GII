/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

/**
 *
 * @author aloncraftmc
 */
public class Usuario {
    
    private String nombre;
    private String email;
    private RolUsuario rol;
    private boolean activo;
    
    private static int totalUsuarios = 0;
    
    public Usuario(String nombre, String email, RolUsuario rol){
        
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        this.activo = true;
        
        Usuario.totalUsuarios++;
        
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
    
    public void mostrarPerfil(){
        System.out.println(this.activo ? "Me llamo " + this.nombre + ", mi email es " + this.email + " y soy " + this.rol + "." : "Usuario Eliminado.");
    }
    
    public void ascender(){
        
        if(this.rol == RolUsuario.INVITADO)     this.rol = RolUsuario.BASICO;
        else if(this.rol == RolUsuario.BASICO)  this.rol = RolUsuario.ADMIN;
        
    }
    
    public void eliminar(){
        
        if(this.activo){
            this.activo = false;
            Usuario.totalUsuarios--;
        }
        
    }
    
    public static int obtenerTotalUsuarios(){
        return Usuario.totalUsuarios;
    }
    
}
