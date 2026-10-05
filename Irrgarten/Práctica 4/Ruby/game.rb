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

		def next_step(preferred_direction)

			dead = @current_player.dead

			if !dead

				direction = self.actual_direction(preferred_direction)

				if direction != preferred_direction
					self.log_player_no_orders
				end

				monster = @labyrinth.put_player(direction, @current_player)

				if monster == nil
					self.log_no_monster
				else

					winner = self.combat(monster)
					self.manage_reward(winner)

				end

				is_dead_after_combat = @current_player.dead

				if is_dead_after_combat
					self.manage_resurrection
				end

			end

			end_game = self.finished

			if !end_game
				self.next_player
			end

			return end_game

		end

		def game_state
			
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

		def actual_direction(preferred_direction)

			current_row = @current_player.row
			current_col = @current_player.col

			valid_moves = @labyrinth.valid_moves(current_row, current_col)

			return @current_player.move(preferred_direction, valid_moves)

		end

		def combat(monster)
			
			rounds = 0
			winner = GameCharacter::PLAYER
			lose = false

			while !lose && rounds < MAX_ROUNDS

				player_attack = @current_player.attack
				lose = monster.defend(player_attack)

				if !lose

					monster_attack = monster.attack
					lose = @current_player.defend(monster_attack)

					if lose
						winner = GameCharacter::MONSTER
					end

				end

				rounds += 1

			end

			self.log_rounds(rounds, MAX_ROUNDS)

			return winner

		end

		def manage_reward(winner)

			if winner == GameCharacter::PLAYER

				@current_player.receive_reward
				self.log_player_won

			else	self.log_monster_won
			end

		end

		def manage_resurrection
			
			resurrect = Dice.resurrect_player

			if resurrect

				@current_player.resurrect

				fuzzy = FuzzyPlayer.new(@current_player)
				@players[@current_player_index] = fuzzy

				@labyrinth.substitute_player(@current_player, fuzzy)
				@current_player = fuzzy

				self.log_resurrected

			else self.log_player_skip_turn
			end

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