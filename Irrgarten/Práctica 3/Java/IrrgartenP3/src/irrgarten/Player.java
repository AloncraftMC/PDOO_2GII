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
        
        int size = validMoves.length;
        
        boolean contained = false;
        
        for(Directions dir : validMoves)
            if(dir == direction)    contained = true;
        
        if(size > 0 && !contained)
            return validMoves[0];
        
        return direction;
        
    }
    
    public float attack(){
        return this.strength + this.sumWeapons();
    }
    
    public boolean defend(float receivedAttack){
        return this.manageHit(receivedAttack);
    }
    
    public void receiveReward(){
        
        int weaponsReward = Dice.weaponsReward();
        int shieldsReward = Dice.shieldsReward();
        
        for(int i = 0; i < weaponsReward; i++){
            
            Weapon weapon = this.newWeapon();
            this.receiveWeapon(weapon);
            
        }
        
        for(int i = 0; i < shieldsReward; i++){
            
            Shield shield = this.newShield();
            this.receiveShield(shield);
            
        }
        
        this.health += Dice.healthReward();
        
    }
    
    public String toString(){
        return "[" + this.health + " ♥] " + this.name + " at " + this.row + ", " + this.col + "\n"
                + "Intelligence: " + this.intelligence + "\n"
                + "Strength: " + this.strength + "\n";
    }
    
    private void receiveWeapon(Weapon w){
        
        this.weapons.removeIf(wi -> wi.discard());
        
        int size = this.weapons.size();
        if (size < Player.MAX_WEAPONS)  weapons.add(w);
        
    }
    
    private void receiveShield(Shield s){
        
        this.shields.removeIf(wi -> wi.discard());
        
        int size = this.shields.size();
        if (size < Player.MAX_SHIELDS)  shields.add(s);
        
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
        
        float defense = this.defensiveEnergy();
        
        if(defense < receivedAttack){
            
            this.gotWounded();
            this.incConsecutiveHits();
            
        }else this.resetHits();
        
        boolean lose = this.consecutiveHits == Player.HITS2LOSE || this.dead();
        
        if(lose) this.resetHits();
        
        return lose;
        
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
