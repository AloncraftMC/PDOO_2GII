/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import matricula.Estudiante;
import matricula.Asignatura;

/**
 *
 * @author aloncraftmc
 */
public class Main {
    
    public static void main(String[] args){
        
        System.out.println("Número de estudiantes del sistema: " + Estudiante.getContadorEstudiantes());
        
        Asignatura pdoo = new Asignatura("PDOO");
        Estudiante carmen = new Estudiante("Carmen", "cm@ugr.es");
        Estudiante antonio = new Estudiante("Antonio");
        
        pdoo.matricularEstudiante(carmen);
        pdoo.matricularEstudiante(antonio);
        
        System.out.println("Número de estudiantes del sistema: " + Estudiante.getContadorEstudiantes());
        
        System.out.println(pdoo.ejercicio());
        
    }
    
}
