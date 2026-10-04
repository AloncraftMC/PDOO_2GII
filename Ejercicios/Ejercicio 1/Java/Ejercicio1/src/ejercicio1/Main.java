/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

/**
 *
 * @author aloncraftmc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Usuario usuario1 = new Usuario("Fulano", "fulano@mail.com", RolUsuario.BASICO);
        Usuario usuario2 = new Usuario("Dios", "dios@god.com", RolUsuario.ADMIN);
        
        usuario1.setRol(RolUsuario.INVITADO);
        
        System.out.println(usuario1.getEmail());
        System.out.println(usuario2.getEmail());
        
        usuario1.mostrarInfo();
        usuario2.mostrarInfo();
        
    }
    
}
