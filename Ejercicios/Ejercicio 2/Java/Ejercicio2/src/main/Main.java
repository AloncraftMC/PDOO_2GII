/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import usuario.RolUsuario;
import usuario.Usuario;

/**
 *
 * @author aloncraftmc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario usuario1 = new Usuario("Invitado", "guest@guest.com", RolUsuario.INVITADO);
        Usuario usuario2 = new Usuario("Fulano", "fulano@mail.com", RolUsuario.BASICO);
        Usuario usuario3 = new Usuario("Dios", "dios@god.com", RolUsuario.ADMIN);
        System.out.println("Total Usuarios: " + Usuario.obtenerTotalUsuarios());
        
        usuario1.eliminar();
        System.out.println("Total Usuarios: " + Usuario.obtenerTotalUsuarios());
        
        usuario2.eliminar();
        System.out.println("Total Usuarios: " + Usuario.obtenerTotalUsuarios());
        
        usuario2    .mostrarPerfil();
        System.out.println("Total Usuarios: " + Usuario.obtenerTotalUsuarios());
        
    }
    
}
