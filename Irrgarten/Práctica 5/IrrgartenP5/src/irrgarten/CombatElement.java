/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author aloncraftmc
 */
public abstract class CombatElement {
    
    private float effect;
    private int uses;
    
    public CombatElement(float effect, int uses){
        
        this.effect = effect;
        this.uses = uses;
        
    }
    
    protected float produceEffect(){
        
        if(this.uses <= 0)  return 0;
        
        this.uses--;
        return this.effect;
        
    }
    
    public boolean discard(){
        return Dice.discardElement(this.uses);
    }
    
    public String toString(){
        return "[" + this.effect + ", " + this.uses + "]";
    }
    
}
