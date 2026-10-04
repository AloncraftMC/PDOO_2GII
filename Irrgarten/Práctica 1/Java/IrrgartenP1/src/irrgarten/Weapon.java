/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author aloncraftmc
 */
public class Weapon {
    
    private float power;
    private int uses;
    
    public Weapon(float power, int uses){
        
        this.power = power;
        this.uses = uses;
        
    }
    
    public float attack(){
        
        if(this.uses <= 0)  return 0;
        
        this.uses --;
        return this.power;
        
    }
    
    public boolean discard(){
        return Dice.discardElement(this.uses);
    }
    
    public String toString(){
        return "W[" + this.power + ", " + this.uses + "]";
    }
    
}
