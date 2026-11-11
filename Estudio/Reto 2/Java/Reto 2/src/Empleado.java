/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Empleado {

    private String nombre;
    private int antiguedad;
    
    public Empleado(String nombre, int antiguedad){
        this.nombre = nombre;
        this.antiguedad = antiguedad;
    }
    
    public Empleado(int antiguedad){
        this("", antiguedad);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getAntiguedad(){
        return this.antiguedad;
    }
    
    public void setAntiguedad(int antiguedad){
        this.antiguedad = antiguedad;
    }
    
}
