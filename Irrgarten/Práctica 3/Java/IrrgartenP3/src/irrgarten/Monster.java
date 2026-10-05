/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author aloncraftmc
 */
public class Monster {

    private static final int INITIAL_HEALTH = 5;
    
    private String name;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;

    public Monster(String name, float intelligence, float strength){

        this.name = name;
        this.intelligence = intelligence;
        this.strength = strength;

        this.health = Monster.INITIAL_HEALTH;

        this.row = -1;
        this.col = -1;

    }

    public boolean dead(){
        return this.health <= 0;
    }

    public float attack(){
        return Dice.intensity(this.strength);
    }

    public boolean defend(float receivedAttack){
        
        boolean isDead = this.dead();
        
        if(!isDead){
            
            float defensiveEnergy = Dice.intensity(this.intelligence);
            if(defensiveEnergy < receivedAttack) this.gotWounded();
            
			isDead = this.dead();
            
        }
        
        return isDead;
        
    }

    public void setPos(int row, int col){
        
        if(row >= 0 && col >= 0){
            
            this.row = row;
            this.col = col;
            
        }
            
    }

    public void gotWounded(){
		this.health--;
    }

    public String toString(){
        return "[" + this.health + " ♥] " + this.name + " at " + this.row + ", " + this.col + "\n"
                + "Intelligence: " + this.intelligence + "\n"
                + "Strength: " + this.strength + "\n";
    }
    
}
