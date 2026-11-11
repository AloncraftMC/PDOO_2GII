/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public class Jugador {
    
    private int puntos;
    private int asistencias;
    private int rebotes;
    private int faltas;
    private int dorsal;
    
    public Jugador(int dorsal){
        
        this.puntos = 0;
        this.asistencias = 0;
        this.rebotes = 0;
        this.faltas = 0;
        
        this.dorsal = dorsal;
        
    }
    
    public void addCanasta(TipoTiro tipo){
        this.puntos += tipo.getValor();
    }
    
    public void addRebote(){
        this.rebotes++;
    }
    
    public void addAsistencia(){
        this.asistencias++;
    }
    
    public void addFalta(){
        this.faltas++;
    }
    
    public int getPuntos(){
        return this.puntos;
    }
    
    public int getAsistencias(){
        return this.asistencias;
    }
    
    public int getRebotes(){
        return this.rebotes;
    }
    
    public int getDorsal(){
        return this.dorsal;
    }
    
}
