
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Main {
    
    public static void main(String[] args){
        
        // I
        
        Equipo granada = new Equipo("Granada", 10);
        Equipo otro = new Equipo();

        for(int dorsal = 1; dorsal <= 10; dorsal++)
            granada.addJugador(dorsal);
        
        for(int dorsal = 1; dorsal <= 15; dorsal++)
            otro.addJugador(dorsal);
        
        Partido partido = new Partido();
        
        partido.addEquipo(granada);
        partido.addEquipo(otro);
        
        // II
        
        partido.muestraResultado();
        
        // III
        
        Random random = new Random();
        TipoTiro[] tipos = TipoTiro.values();

        for(Equipo equipo : new Equipo[]{granada, otro}){
            
            for(int i = 0; i < 11; i++){
                
                partido.addCanasta(equipo, 1, TipoTiro.LIBRE);
                partido.addRebote(equipo, 1);
                
            }
            
            for(int dorsal = 1; dorsal <= equipo.getNumJugadores(); dorsal++){
                
                partido.addCanasta(equipo, dorsal, tipos[random.nextInt(tipos.length)]);
                
                if(random.nextBoolean()) partido.addRebote(equipo, dorsal);
                if(random.nextBoolean()) partido.addAsistencia(equipo, dorsal);
                if(random.nextBoolean()) partido.addFalta(equipo, dorsal);
                
            }
            
        }
        
        // IV
        
        partido.muestraResultado();
        
        // V
        
        partido.muestraDobleDoble();
        
        // VI
        
        partido.muestraMVPEquipo(granada);
        partido.muestraMVPEquipo(otro);
        
        partido.muestraMVPPartido();
        
    }
    
}
