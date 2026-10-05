/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package irrgarten;

import irrgarten.controller.Controller;
import irrgarten.UI.TextUI;

/**
 *
 * @author aloncraftmc
 */
public class Main {
    
    public static void main(String[] args){
        
        Game game = new Game(1);
    
        TextUI textUI = new TextUI();
        Controller controller = new Controller(game, textUI);

        controller.play();
        
    }
    
}
