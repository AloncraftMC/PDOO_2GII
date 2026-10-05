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
public class Game {
    
    private static final int MAX_ROUNDS = 10;
    
    private int currentPlayerIndex;
    private String log;
    private Player currentPlayer;
    private Labyrinth labyrinth;
    
    private ArrayList<Player> players;
    private ArrayList<Monster> monsters;
    
    public Game(int nPlayers){
        
        this.log = "";
        this.labyrinth = new Labyrinth(10, 10, 9, 9);
        
        this.players = new ArrayList<Player>();
        this.monsters = new ArrayList<Monster>();
        
        for(int i = 0; i < nPlayers; i++)
            this.players.add(new Player((char) ('0' + i), Dice.randomIntelligence(), Dice.randomStrength()));
        
        this.currentPlayerIndex = Dice.whoStarts(nPlayers);
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
        
        this.configureLabyrinth();
        this.labyrinth.spreadPlayers(players);
        
    }
    
    public boolean finished(){
        return this.labyrinth.haveAWinner();
    }
    
    public boolean nextStep(Directions preferredDirection){
        
        boolean dead = this.currentPlayer.dead();
        
        if(!dead){
            
            Directions direction = this.actualDirection(preferredDirection);
            
            if(direction != preferredDirection) this.logPlayerNoOrders();
            
            Monster monster = this.labyrinth.putPlayer(direction, this.currentPlayer);
            
            if(monster == null) this.logNoMonster();
            else{
                
                GameCharacter winner = this.combat(monster);
                this.manageReward(winner);
                
            }
            
            boolean isDeadAfterCombat = this.currentPlayer.dead();
            if(isDeadAfterCombat)   this.manageResurrection();
            
        }
        
        boolean endGame = this.finished();
        
        if(!endGame)    this.nextPlayer();
        
        return endGame;
        
    }
    
    public GameState getGameState(){
        
        String players = "";
        
        for(Player player : this.players)
            players += player.toString() + "\n";
        
        String monsters = "";
        
        for(Monster monster : this.monsters)
            monsters += monster.toString() + "\n";
        
        return new GameState(this.labyrinth.toString(), players, monsters, this.currentPlayerIndex, this.finished(), this.log);
        
    }
    
    private void configureLabyrinth(){
        
    }
    
    private void nextPlayer(){
        
        this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
        this.currentPlayer = this.players.get(this.currentPlayerIndex);
        
    }
    
    private Directions actualDirection(Directions preferredDirection){
        
        int currentRow = this.currentPlayer.getRow();
        int currentCol = this.currentPlayer.getCol();
        
        Directions[] validMoves = this.labyrinth.validMoves(currentRow, currentCol);
        
        return this.currentPlayer.move(preferredDirection, validMoves);
        
    }
    
    private GameCharacter combat(Monster monster){
        
        int rounds = 0;
        GameCharacter winner = GameCharacter.PLAYER;
        boolean lose = false;
        
        while(!lose && rounds < MAX_ROUNDS){
            
            float playerAttack = this.currentPlayer.attack();
            lose = monster.defend(playerAttack);
            
            if(!lose){
                
                float monsterAttack = monster.attack();
                lose = this.currentPlayer.defend(monsterAttack);
                
                if(lose) winner = GameCharacter.MONSTER;
                
            }
            
            rounds++;
            
        }
        
        this.logRounds(rounds, Game.MAX_ROUNDS);
        
        return winner;
        
    }
    
    private void manageReward(GameCharacter winner){
        
        if(winner == GameCharacter.PLAYER){
            
            this.currentPlayer.receiveReward();
            this.logPlayerWon();
            
        }else this.logMonsterWon();
        
    }
    
    private void manageResurrection(){
        
        boolean resurrect = Dice.resurrectPlayer();
        
        if(resurrect){
            
            this.currentPlayer.resurrect();
            this.logResurrected();
            
        }else this.logPlayerSkipTurn();
        
    }
    
    private void logPlayerWon(){
        this.log += "Player won.\n";
    }
    
    private void logMonsterWon(){
        this.log += "Monster won.\n";
    }
    
    private void logResurrected(){
        this.log += "Player resurrected.\n";
    }
    
    private void logPlayerSkipTurn(){
        this.log += "Player lost its turn because it was dead.\n";
    }
    
    private void logPlayerNoOrders(){
        this.log += "Player did not follow the instructions.\n";
    }
    
    private void logNoMonster(){
        this.log += "Player moved to an empty cell or couldn't move.\n";
    }
    
    private void logRounds(int rounds, int max){
        this.log += rounds + " of " + max + " rounds done.\n";
    }
    
}
