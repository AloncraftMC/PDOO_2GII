/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author aloncraftmc
 */
public class Usuario {
    
    private String nombre;
    private String email;
    private RolUsuario rol;
    
    public Usuario(String nombre, String email, RolUsuario rol){
        
        this.nombre = nombre;
        this.email = email;
        this.rol = rol;
        
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
    
    public void mostrarInfo(){
        System.out.println("Me llamo " + this.nombre + ", mi email es " + this.email + " y soy " + this.rol + ".");
    }
    
}
