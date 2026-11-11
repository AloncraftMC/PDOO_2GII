/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */

/**
 *
 * @author aloncraftmc
 */
public enum TipoTiro {
    
    LIBRE(1), CAMPO(2), TRIPLE(3);
    
    private final int valor;
    
    private TipoTiro(int valor){
        this.valor = valor;
    }
    
    public int getValor(){
        return this.valor;
    }
    
}
