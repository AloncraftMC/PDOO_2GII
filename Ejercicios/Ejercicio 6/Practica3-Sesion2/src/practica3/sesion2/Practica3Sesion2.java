/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package practica3.sesion2;

/**
 *
 * @author bihut
 */
public class Practica3Sesion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Personaje p = new Personaje(100,101,102);
        boolean res=p.combatir(4);
        if(res){
            p.curarse();
            System.out.println("Personaje curado");
        }
        else{
            System.out.println("El personaje ha palmao...");
            System.exit(0);
        }
            
    }
    
}
