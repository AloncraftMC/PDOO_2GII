
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Equipo {
    
    private int NUM_JUGADORES;
    private String nombre;
    private ArrayList<Jugador> jugadores;
    
    public Equipo(String nombre, int numJugadores){
        
        this.nombre = nombre;
        this.NUM_JUGADORES = (numJugadores > 5 && numJugadores <= 15) ? numJugadores : 15;
        this.jugadores = new ArrayList<>();
    
    }
    
    public Equipo(){
        this("Anónimo", 15);
    }
    
    public Jugador addJugador(int dorsal){
        
        if(this.jugadores.size() < this.NUM_JUGADORES && dorsal == this.jugadores.size() + 1){
            
            Jugador jugador = new Jugador(dorsal);
            this.jugadores.add(jugador);
            
            return jugador;
            
        }
        
        return null;
        
    }
    
    public int getNumJugadores(){
        return this.NUM_JUGADORES;
    }
    
    public int puntos(){
        
        int puntos = 0;
        
        for(Jugador jugador : this.jugadores)
            puntos += jugador.getPuntos();
        
        return puntos;
        
    }
    
    public int dorsalMVP(){
        
        int dorsal = 1;
        int valoracionMax = -1;
        
        for(Jugador jugador : this.jugadores){
            
            int valoracion = jugador.getAsistencias() + jugador.getPuntos() + jugador.getRebotes();
            
            if(valoracion > valoracionMax){
                valoracionMax = valoracion;
                dorsal = jugador.getDorsal();
            }
            
        }
        
        return dorsal;
        
    }
    
    public int[] dobledoble(){
        
        ArrayList<Integer> resultado = new ArrayList<>();
        
        for(Jugador jugador : this.jugadores){
            
            if((jugador.getPuntos()      > 10 && jugador.getRebotes()        > 10) ||
               (jugador.getPuntos()      > 10 && jugador.getAsistencias()    > 10) ||
               (jugador.getAsistencias() > 10 && jugador.getRebotes()        > 10))
                resultado.add(jugador.getDorsal());
            
        }
        
        return resultado.stream().mapToInt(Integer::intValue).toArray();
        
    }
    
    public Jugador getJugador(int dorsal){
        return this.jugadores.get(dorsal - 1);
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
