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
public class Player extends LabyrinthCharacter {
    
    private static final int MAX_WEAPONS = 2;
    private static final int MAX_SHIELDS = 3;
    private static final int INITIAL_HEALTH = 10;
    private static final int HITS2LOSE = 3;
    
    private char number;
    private int consecutiveHits = 0;
    
    private ArrayList<Weapon> weapons;
    private ArrayList<Shield> shields;
    
    private WeaponCardDeck weaponCardDeck;
    private ShieldCardDeck shieldCardDeck;
    
    public Player(char number, float intelligence, float strength){
        
        super("Player #" + number, intelligence, strength, Player.INITIAL_HEALTH);
        
        this.number = number;
        this.consecutiveHits = 0;
        
        this.weapons = new ArrayList<>();
        this.shields = new ArrayList<>();
        
        this.weaponCardDeck = new WeaponCardDeck();
        this.shieldCardDeck = new ShieldCardDeck();
        
    }
    
    public Player(Player other){
        
        super(other);
        
        this.number = other.number;
        this.consecutiveHits = other.consecutiveHits;
        
        this.weapons = new ArrayList<>(other.weapons);
        this.shields = new ArrayList<>(other.shields);
        
        this.weaponCardDeck = other.weaponCardDeck;
        this.shieldCardDeck = other.shieldCardDeck;
        
    }
    
    public void resurrect(){
        
        this.setHealth(Player.INITIAL_HEALTH);
        
        this.consecutiveHits = 0;
        
        this.weapons.clear();
        this.shields.clear();
        
    }
    
    public char getNumber(){
        return this.number;
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
    
    @Override
    public float attack(){
        return this.getStrength() + this.sumWeapons();
    }
    
    @Override
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
        
        this.setHealth(this.getHealth() + Dice.healthReward());
        
    }
    
    @Override
    public String toString(){
        return super.toString() +
                "Weapons: " + this.weapons.toString() + "\n" +
                "Shields: " + this.shields.toString() + "\n" +
                "Consecutive Hits: " + this.consecutiveHits;
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
        return this.weaponCardDeck.nextCard();
    }
    
    private Shield newShield(){
        return this.shieldCardDeck.nextCard();
    }
    
    protected float sumWeapons(){
        
        float sum = 0.0f;
        
        for(Weapon weapon : this.weapons)    sum += weapon.attack();
        
        return sum;
        
    }
    
    protected float sumShields(){
        
        float sum = 0.0f;
        
        for(Shield shield : this.shields)   sum += shield.protect();
        
        return sum;
        
    }
    
    protected float defensiveEnergy(){
        return this.getIntelligence() + this.sumShields();
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
    
    private void incConsecutiveHits(){
        this.consecutiveHits++;
    }
    
}
