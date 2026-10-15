/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mecanica;

/**
 *
 * @author aloncraftmc
 */
public class Coche {
    
    private String modelo;
    private Motor motor;
    
    public Coche(String modelo){
        
        this.modelo = modelo;
        this.motor = new Motor();
        
    }
    
    public void encender(){
        this.motor.arrancar();
    }
    
    public void acelerar(){
        if(this.motor.isEncendido()) System.out.println("Coche acelerado.");
    }
    
    public void revisarMotor(){
        this.motor.verTemperatura();
    }
    
}
