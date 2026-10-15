/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;

/**
 *
 * @author aloncraftmc
 */
public class Motor {
    
    private boolean encendido;
    private float temperatura;
    
    public Motor(){
        
        this.encendido = false;      
        this.temperatura = 25.0f;
        
    }
    
    public float getTemperatura(){
        return this.temperatura;
    }
    
    public boolean isEncendido(){
        return this.encendido;
    }
    
    public void setTemperatura(float temperatura){
        this.temperatura = temperatura;
    }
    
    public void inyectarCombustible(){
        System.out.println("Combustible inyectado en el motor.");
    }
    
    public void arrancar(){
        this.encendido = true;
        this.inyectarCombustible();
    }
    
    protected void verTemperatura(){
        System.out.println("Temperatura: " + (this.temperatura < 50.0f ? "Alta" : "Baja"));
    }
    
}
