
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Partido {
    
    private ArrayList<Equipo> equipos;
    
    public Partido(){
        this.equipos = new ArrayList<>();
    }
    
    public void addEquipo(Equipo equipo){
        if(this.equipos.size() < 2) this.equipos.add(equipo);
    }
    
    public void addCanasta(Equipo equipo, int dorsal, TipoTiro tipo){
        equipo.getJugador(dorsal).addCanasta(tipo);
    }
    
    public void addRebote(Equipo equipo, int dorsal){
        equipo.getJugador(dorsal).addRebote();
    }
    
    public void addAsistencia(Equipo equipo, int dorsal){
        equipo.getJugador(dorsal).addAsistencia();
    }
    
    public void addFalta(Equipo equipo, int dorsal){
        equipo.getJugador(dorsal).addFalta();
    }
    
    public void muestraResultado(){
        System.out.println("Equipo 1: " + this.equipos.get(0).puntos() + " puntos");
        System.out.println("Equipo 2: " + this.equipos.get(1).puntos() + " puntos");
    }
    
    public void muestraMVPEquipo(Equipo equipo){
        System.out.println("MVP Equipo " + equipo.getNombre() + ": " + equipo.dorsalMVP());
    }
    
    public void muestraMVPPartido(){
        
        Equipo equipo1 = this.equipos.get(0);
        Equipo equipo2 = this.equipos.get(1);
        
        Jugador mvp1 = equipo1.getJugador(equipo1.dorsalMVP());
        Jugador mvp2 = equipo2.getJugador(equipo2.dorsalMVP());
        
        int valoracion1 = mvp1.getAsistencias() + mvp1.getPuntos() + mvp1.getRebotes();
        int valoracion2 = mvp2.getAsistencias() + mvp2.getPuntos() + mvp2.getRebotes();
        
        Jugador mvp = (valoracion1 > valoracion2) ? mvp1 : mvp2;
        
        System.out.println("MVP Partido: " + mvp.getDorsal());
        
        
    }
    
    public void muestraDobleDoble(){
        
        for(Equipo equipo : this.equipos){
            
            System.out.println("Doble-Doble(s) Equipo " + equipo.getNombre() + ":");
            
            for(int dorsal : equipo.dobledoble()){
                
                Jugador jugador = equipo.getJugador(dorsal);
                System.out.println("  Dorsal " + dorsal +
                        " -> Puntos: " + jugador.getPuntos() +
                        ", Rebotes: " + jugador.getRebotes() +
                        ", Asistencias: " + jugador.getAsistencias());
                
            }
            
        }
        
    }
    
}
