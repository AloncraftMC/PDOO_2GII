/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula;

/**
 *
 * @author aloncraftmc
 */
public class Estudiante {
    
    private String nombre;
    private String email;
    
    private static int contadorEstudiantes = 0;
    
    public static int getContadorEstudiantes(){
        return Estudiante.contadorEstudiantes;
    }
    
    public Estudiante(String nombre, String email){
        
        this.nombre = nombre;
        this.email = email;
        
        Estudiante.contadorEstudiantes++;
    
    }
    
    public Estudiante(String nombre){
        this(nombre, "pendiente@ugr.es");
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public String getDatos(){
        return this.nombre + " " + this.email;
    }
    
}
