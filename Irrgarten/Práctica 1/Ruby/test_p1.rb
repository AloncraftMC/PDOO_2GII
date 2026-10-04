# encoding: UTF-8

require_relative 'directions'
require_relative 'orientation'
require_relative 'game_character'
require_relative 'weapon'
require_relative 'shield'
require_relative 'dice'
require_relative 'game_state'

module Irrgarten

    class TestP1

        def self.main

            puts Directions::UP

            weapon = Weapon.new(4.5, 7)
            shield = Shield.new(7.5, 5)

            puts weapon.to_s
            puts shield.to_s

            gameState = GameState.new("", "", "", 1, false, "Log")

            puts "Jugador Actual: " + gameState.players
            puts "Laberinto: " + gameState.labyrinth

            for i in 0..99

                puts "Posición Aleatoria: " + Dice.random_pos(10).to_s
                puts "Quién empieza: " + Dice.who_starts(10).to_s
                puts "Inteligencia Aleatoria: " + Dice.random_intelligence.to_s
                puts "Fuerza Aleatoria: " + Dice.random_strength.to_s
                puts "¿Se resucita al jugador? " + Dice.resurrect_player.to_s
                puts "Recompensa de Armas: " + Dice.weapons_reward.to_s
                puts "Recompensa de Escudos: " + Dice.shields_reward.to_s
                puts "Recompensa de Salud: " + Dice.health_reward.to_s
                puts "Potencia de Arma: " + Dice.weapon_power.to_s
                puts "Potencia de Escudo: " + Dice.shield_power.to_s
                puts "Usos Restantes: " + Dice.uses_left.to_s
                puts "Intensidad: " + Dice.intensity(10).to_s
                puts "¿Se descarta el elemento? " + Dice.discard_element(10).to_s

            end

        end

    end

end

Irrgarten::TestP1.main