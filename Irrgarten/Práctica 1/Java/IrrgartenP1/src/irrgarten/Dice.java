/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import java.util.Random;

/**
 *
 * @author aloncraftmc
 */
public class Dice {
    
    private static final int MAX_USES = 5;
    private static final float MAX_INTELLIGENCE = 10.0f;
    private static final float MAX_STRENGTH = 10.0f;
    private static final float RESURRECT_PROB = 0.3f;
    private static final int WEAPONS_REWARD = 2;
    private static final int SHIELDS_REWARD = 3;
    private static final int HEALTH_REWARD = 5;
    private static final int MAX_ATTACK = 3;
    private static final int MAX_SHIELD = 2;
    
    private static Random generator = new Random();
    
    public static int randomPos(int max){
        return Dice.generator.nextInt(max);
    }
    
    public static int whoStarts(int nplayers){
        return Dice.generator.nextInt(nplayers);
    }
    
    public static float randomIntelligence(){
        return Dice.generator.nextFloat() * Dice.MAX_INTELLIGENCE;
    }
    
    public static float randomStrength(){
        return Dice.generator.nextFloat() * Dice.MAX_STRENGTH;
    }
    
    public static boolean resurrectPlayer(){
        return Dice.generator.nextFloat() < Dice.RESURRECT_PROB;
    }
    
    public static int weaponsReward(){
        return Dice.generator.nextInt(Dice.WEAPONS_REWARD + 1);
    }
    
    public static int shieldsReward(){
        return Dice.generator.nextInt(Dice.SHIELDS_REWARD + 1);
    }
    
    public static int healthReward(){
        return Dice.generator.nextInt(Dice.HEALTH_REWARD + 1);
    }
    
    public static float weaponPower(){
        return Dice.generator.nextFloat() * Dice.MAX_ATTACK;
    }
    
    public static float shieldPower(){
        return Dice.generator.nextFloat() * Dice.MAX_SHIELD;
    }
    
    public static int usesLeft(){
        return Dice.generator.nextInt(Dice.MAX_USES + 1);
    }
    
    public static float intensity(float competence){
        return Dice.generator.nextFloat() * competence;
    }
    
    public static boolean discardElement(int usesLeft){
        return Dice.generator.nextFloat() < (Dice.MAX_USES - usesLeft) / (float) MAX_USES;
    }
    
}
