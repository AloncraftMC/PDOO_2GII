/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

/**
 *
 * @author aloncraftmc
 */
public class TestP1 {
    
    public static void main(String[] args){
        
        System.out.println(Directions.UP);
        
        Weapon weapon = new Weapon(4.5f, 7);
        Shield shield = new Shield(7.5f, 5);
        
        System.out.println(weapon);
        System.out.println(shield);
        
        GameState gameState = new GameState("", "", "", 1, false, "Log");
        
        System.out.println("Jugador Actual: " + gameState.getPlayers());
        System.out.println("Laberinto: " + gameState.getLabyrinth());
        
        for(int i = 0; i < 100; i++){
            
            System.out.println("Posición Aleatoria: " + Dice.randomPos(10));
            System.out.println("Quién Empieza: " + Dice.whoStarts(10));
            System.out.println("Inteligencia Aleatoria: " + Dice.randomIntelligence());
            System.out.println("Fuerza Aleatoria: " + Dice.randomStrength());
            System.out.println("¿Se resucita al jugador? " + Dice.resurrectPlayer());
            System.out.println("Recompensa de Armas: " + Dice.weaponsReward());
            System.out.println("Recompensa de Escudos: " + Dice.shieldsReward());
            System.out.println("Recompensa de Salud: " + Dice.healthReward());
            System.out.println("Potencia de Arma: " + Dice.weaponPower());
            System.out.println("Potencia de Escudo: " + Dice.shieldPower());
            System.out.println("Usos Restantes: " + Dice.usesLeft());
            System.out.println("Intensidad: " + Dice.intensity(10));
            System.out.println("¿Se descarta el elemento? " + Dice.discardElement(10));
            
        }
        
    }
    
}
