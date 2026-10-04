/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.ArrayList;

/**
 *
 * @author aloncraftmc
 */
public class Player {
    
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 3;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS2LOSE = 3;
    
    private String name;
    private char number;
    private float intelligence;
    private float strength;
    private float health;
    private int row;
    private int col;
    private int consecutiveHits = 0; 
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    public Player(char number, float intelligence, float strength){
        
        this.name = "Player #" + number;
        
        this.number = number;
        this.intelligence = intelligence;
        this.strength = strength;
        
        this.health = Player.INITIAL_HEALTH;
        
        this.consecutiveHits = 0;
        
        this.weapons = new ArrayList<Weapon>();
        this.shields = new ArrayList<Shield>();
        
    }
    
    public void resurrect(){
        
        this.health = Player.INITIAL_HEALTH;
        
        this.consecutiveHits = 0;
        
        this.weapons.clear();
        this.shields.clear();
        
    }
    
    public int getRow(){
        return this.row;
    }
    
    public int getCol(){
        return this.col;
    }
    
    public char getNumber(){
        return this.number;
    }
    
    public void setPos(int row, int col){
        
        if(row >= 0 && col >= 0){
            
            this.row = row;
            this.col = col;
            
        }
        
    }
    
    public boolean dead(){
        return this.health <= 0;
    }
    
    public Directions move(Directions direction, Directions[] validMoves){
        throw new UnsupportedOperationException();
    }
    
    public float attack(){
        return this.strength + this.sumWeapons();
    }
    
    public boolean defend(float receivedAttack){
        return false; // X
    }
    
    public void receiveReward(){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        return "[" + this.health + " ♥] " + this.name + "at " + this.row + ", " + this.col + "\n"
                + "Intelligence: " + this.intelligence + "\n"
                + "Strength: " + this.strength + "\n";
    }
    
    private void receiveWeapon(Weapon w){
        throw new UnsupportedOperationException();
    }
    
    private void receiveShield(Shield s){
        throw new UnsupportedOperationException();
    }
    
    private Weapon newWeapon(){
        return new Weapon(Dice.weaponPower(), Dice.usesLeft());
    }
    
    private Shield newShield(){
        return new Shield(Dice.shieldPower(), Dice.usesLeft());
    }
    
    private float sumWeapons(){
        
        float sum = 0.0f;
        
        for(Weapon weapon : this.weapons)    sum += weapon.attack();
        
        return sum;
        
    }
    
    private float sumShields(){
        
        float sum = 0.0f;
        
        for(Shield shield : this.shields)   sum += shield.protect();
        
        return sum;
        
    }
    
    private float defensiveEnergy(){
        return this.intelligence + this.sumShields();
    }
    
    private boolean manageHit(float receivedAttack){
        throw new UnsupportedOperationException();
    }
    
    private void resetHits(){
        this.consecutiveHits = 0;
    }
    
    private void gotWounded(){
        this.health--;
    }
    
    private void incConsecutiveHits(){
        this.consecutiveHits++;
    }
    
}
