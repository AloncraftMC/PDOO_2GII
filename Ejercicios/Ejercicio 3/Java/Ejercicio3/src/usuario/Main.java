package usuario;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import mecanica.Coche;
import usuario.Conductor;

/**
 *
 * @author aloncraftmc
 */
public class Main {
    
    public static void main(String[] args){
        
        Coche coche = new Coche("Skoda Fabia");
        Conductor conductor = new Conductor("Fulano");

        conductor.viajar(coche);
        coche.revisarMotor();
        
    }
    
}
