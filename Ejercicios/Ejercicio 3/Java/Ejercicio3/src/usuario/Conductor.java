/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package usuario;

import mecanica.Coche;

/**
 *
 * @author aloncraftmc
 */
public class Conductor {
    
    private String nombre;
    
    public Conductor(String nombre){
        
        this.nombre = nombre;
        
    }
    
    public void viajar(Coche co){
        co.encender();
        co.acelerar();
    }
    
}
