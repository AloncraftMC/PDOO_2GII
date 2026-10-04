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
public class Labyrinth {
    
    private static final char BLOCK_CHAR = 'X';
    private static final char EMPTY_CHAR = '-';
    private static final char MONSTER_CHAR = 'M';
    private static final char COMBAT_CHAR = 'C';
    private static final char EXIT_CHAR = 'E';
    private static final int ROW = 0;
    private static final int COL = 1;
    
    private int nRows;
    private int nCols;
    private int exitRow;
    private int exitCol;
    
    private Monster[][] monsters;
    private Player[][] players;
    private char[][] labyrinth;
    
    public Labyrinth(int nRows, int nCols, int exitRow, int exitCol){
        
        this.nRows = nRows;
        this.nCols = nCols;
        this.exitRow = exitRow;
        this.exitCol = exitCol;
        
        this.monsters = new Monster[nRows][nCols];
        this.players = new Player[nRows][nCols];
        this.labyrinth = new char[nRows][nCols];
        
        for(int i = 0; i < this.nRows; i++)
            for(int j = 0; j < this.nCols; j++)
                this.labyrinth[i][j] = Labyrinth.EMPTY_CHAR;
        
        this.labyrinth[this.exitRow][this.exitCol] = Labyrinth.EXIT_CHAR;
        
    }
    
    public void spreadPlayers(ArrayList<Player> players){
        
    }
    
    public boolean haveAWinner(){
        return this.players[this.exitRow][this.exitCol] != null;
    }
    
    public void addMonster(int row, int col, Monster monster){
        
        if(this.emptyPos(row, col)){
            
            this.labyrinth[row][col] = Labyrinth.MONSTER_CHAR;
            this.monsters[row][col] = monster;
            monster.setPos(row, col);
            
        }
        
    }
    
    public Monster putPlayer(Directions direction, Player player){
        throw new UnsupportedOperationException();
    }
    
    public void addBlock(Orientation orientation, int startRow, int startCol, int length){
        throw new UnsupportedOperationException();
    }
    
    public Directions[] validMoves(int row, int col){
        throw new UnsupportedOperationException();
    }
    
    public String toString(){
        
        String string = "";
        
        for(int i = 0; i < this.nRows; i++){
            
            for(int j = 0; j < this.nCols; j++)
                string += this.labyrinth[i][j];
            
            string += "\n";
            
        }
        
        return string + "\n";
        
    }
    
    private boolean posOK(int row, int col){
        return row >= 0 && row < this.nRows && col >= 0 && col < this.nCols;
    }
    
    private boolean emptyPos(int row, int col){
        return this.posOK(row, col) && this.labyrinth[row][col] == Labyrinth.EMPTY_CHAR;
    }
    
    private boolean monsterPos(int row, int col){
        return this.posOK(row, col) && this.labyrinth[row][col] == Labyrinth.MONSTER_CHAR;
    }
    
    private boolean exitPos(int row, int col){
        return this.posOK(row, col) && this.labyrinth[row][col] == Labyrinth.EXIT_CHAR;
    }
    
    private boolean combatPos(int row, int col){
        return this.posOK(row, col) && this.labyrinth[row][col] == Labyrinth.COMBAT_CHAR;        
    }
    
    private boolean canStepOn(int row, int col){
        return this.emptyPos(row, col) || this.monsterPos(row, col) || this.exitPos(row, col);
    }
    
    private void updateOldPos(int row, int col){
        
        if(this.posOK(row, col)){
            
            if(this.labyrinth[row][col] == Labyrinth.COMBAT_CHAR)
                this.labyrinth[row][col] = Labyrinth.MONSTER_CHAR;
            
            else this.labyrinth[row][col] = Labyrinth.EMPTY_CHAR;
            
        }
        
    }
    
    private int[] dir2Pos(int row, int col, Directions direction){
        
        int[] pos = {row, col};
        
        switch(direction){
            
            case UP:
                pos[0]--;
                break;
                
            case DOWN:
                pos[0]++;
                break;
                
            case LEFT:
                pos[1]--;
                break;
                
            case RIGHT:
                pos[1]++;
                break;
            
        }
        
        return pos;
        
    }
    
    private int[] randomEmptyPos(){
        
        int[] pos = {-1, -1};
        
        do{
            
            pos[0] = Dice.randomPos(this.nRows);
            pos[1] = Dice.randomPos(this.nCols);
            
        }while(!this.emptyPos(pos[0], pos[1]));
        
        return pos;
        
    }
    
    private Monster putPlayer2D(int oldRow, int oldCol, int row, int col, Player player){
        throw new UnsupportedOperationException();
    }
    
}
