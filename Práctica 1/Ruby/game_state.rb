# encoding: UTF-8

module Irrgarten

    class GameState

		attr_reader :labyrinth, :players, :monsters, :current_player, :winner, :log

        def initialize(labyrinth, players, monsters, current_player, winner, log)

            @labyrinth = labyrinth
            @players = players
            @monsters = monsters
            @current_player = current_player
            @winner = winner
            @log = log

        end

    end

end