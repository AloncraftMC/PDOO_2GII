/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3.sesion2;

/**
 *
 * @author bihut
 */
public class Personaje {
    private int salud;
    private int poderDeAtaque;
    private int energia;

    public Personaje(int salud, int poderDeAtaque, int energia) {
        this.salud = salud;
        this.poderDeAtaque = poderDeAtaque;
        this.energia = energia;
    }

    // Método de combate que devuelve true si el personaje sigue vivo después del combate
    public boolean combatir(int ataques) {
        System.out.println("El personaje entra en combate.");
        
        for (int i = 0; i < ataques; i++) {
            if (energia >= 10) {
                realizarAtaque();
            } else {
                System.out.println("No hay suficiente energía para atacar.");
                recuperarEnergia();
            }
            
            // Verificar si la salud es menor o igual a 0 después de cada ataque
            if (salud <= 0) {
                System.out.println("El personaje ha caído en combate.");
                return false; // Retorna false si el personaje muere en combate
            }
        }

        return true; // Retorna true si el personaje sigue vivo
    }

    private void realizarAtaque() {
        energia -= 10;
        System.out.println("¡Ataque realizado! Energía restante: " + energia);
    }

    public void curarse() {
        int intentos = 0;

        while (salud < 100 && intentos < 3) {
            salud += 10;
            intentos++;

            if (salud > 100) {
                salud = 100;
            }

            System.out.println("Curación realizada. Salud actual: " + salud);
        }

        if (salud == 100) {
            System.out.println("La salud está completamente restaurada.");
        }
    }

    private void recuperarEnergia() {
        energia += 5;
        System.out.println("Energía recuperada: " + energia);
    }
}
