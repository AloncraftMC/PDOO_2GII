/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Departamento {
    
    private String nombre;
    private double capital;
    
    public Departamento(String nombre, double capital){
        this.nombre = nombre;
        this.capital = capital;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public double getCapital(){
        return this.capital;
    }
    
    public void setCapital(double capital){
        this.capital = capital;
    }
    
}
