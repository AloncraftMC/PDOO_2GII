/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matricula;

import java.util.ArrayList;

/**
 *
 * @author aloncraftmc
 */
public class Asignatura {
    
    private String nombre;
    private ArrayList<Estudiante> estudiantes;
    
    public Asignatura(String nombre){
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }
    
    public void matricularEstudiante(Estudiante estudiante){
        
        if(!this.estudiantes.contains(estudiante)) this.estudiantes.add(estudiante);
        
    }
    
    public String ejercicio(){
        
        String res = "";
        
        for(Estudiante estudiante : this.estudiantes){
            
            String resEst = estudiante.getDatos();
            res += resEst + ", ";
            
        }
        
        return res;
        
    }
    
}
