# encoding: UTF-8

module Irrgarten

	class Game

		MAX_ROUNDS = 10

		def initialize(n_players)

			@players = []
			@monsters = []
			
			@log = ""

			@labyrinth = Labyrinth.new(10, 10, 9, 9)

			n_players.times do |i|
				@players[i] = Player.new(i.to_s, Dice.random_intelligence, Dice.random_strength)
			end

			@current_player_index = Dice.who_starts(n_players)
			@current_player = @players[@current_player_index]

			self.configure_labyrinth
			@labyrinth.spread_players(@players)

		end

		def finished
			return @labyrinth.have_a_winner
		end

		def next_step
			raise NotImplementedError.new
		end

		def get_game_state
			
			players = @players.map{ |player| player.to_s }.join("\n")
			monsters = @monsters.map { |monster| monster.to_s }.join("\n")

			return GameState.new(@labyrinth.to_s, players, monsters, @current_player_index, self.finished, @log)

		end

		private

		def configure_labyrinth

		end

		def next_player

			@current_player_index = (@current_player_index + 1) % @players.size
			@current_player = @players[@current_player_index]

		end

		def actual_direction
			raise NotImplementedError.new
		end

		def combat(monster)
			raise NotImplementedError.new
		end

		def manage_reward
			raise NotImplementedError.new
		end

		def manage_resurrection
			raise NotImplementedError.new
		end

		def log_player_won
			@log += "Player won.\n"
		end

		def log_monster_won
			@log += "Monster won.\n"
		end

		def log_resurrected
			@log += "Player resurrected.\n"
		end

		def log_player_skip_turn
			@log += "Player lost its turn beacuse it was dead.\n"
		end

		def log_player_no_orders
			@log += "Player did not follow the instructions.\n"
		end

		def log_no_monster
			@log += "Player moved to an empty cell of couldn't move.\n"
		end

		def log_rounds(rounds, max)
			@log += "#{rounds} of #{max} rounds done.\n"
		end

	end

end