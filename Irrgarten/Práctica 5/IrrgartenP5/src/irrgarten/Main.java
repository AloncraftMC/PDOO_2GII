/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import irrgarten.UI.GameFrame;
import irrgarten.controller.Controller;
import irrgarten.UI.TextUI;

/**
 *
 * @author aloncraftmc
 */
public class Main {
    
    public static void main(String[] args){
        
        Game game = new Game(1);
        GameFrame frame = new GameFrame();
    
        Controller controller = new Controller(game, frame);
        controller.play();
        
    }
    
}
