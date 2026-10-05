# encoding: UTF-8

module Irrgarten

	class Labyrinth

		BLOCK_CHAR = 'X'
		EMPTY_CHAR = '-'
		MONSTER_CHAR = 'M'
		COMBAT_CHAR = 'C'
		EXIT_CHAR = 'E'
		ROW = 0
		COL = 1

		def initialize(n_rows, n_cols, exit_row, exit_col)

			@n_rows = n_rows
			@n_cols = n_cols
			@exit_row = exit_row
			@exit_col = exit_col

			@monsters = Array.new(n_rows){Array.new(n_cols)}
			@players = Array.new(n_rows){Array.new(n_cols)}

			@labyrinth = Array.new(n_rows){Array.new(n_cols, EMPTY_CHAR)}

			@labyrinth[@exit_row][@exit_col] = EXIT_CHAR

		end

		def spread_players(players)
			
			players.each do |player|

				pos = self.random_empty_pos
				self.put_player_2d(-1, -1, pos[ROW], pos[COL], player)

			end

		end
			
		def put_player(direction, player)
			
			old_row = player.row
			old_col = player.col

			new_pos = self.dir_2_pos(old_row, old_col, direction)

			monster = self.put_player_2d(old_row, old_col, new_pos[ROW], new_pos[COL], player)

			return monster

		end

		def add_block(orientation, start_row, start_col, length)
			
			inc_row = 0
			inc_col = 0

			if orientation == Orientation::VERTICAL

				inc_row = 1
				inc_col = 0

			else
				
				inc_row = 0
				inc_col = 1

			end

			row = start_row
			col = start_col

			while pos_ok(row, col) && empty_pos(row, col) && length > 0

				@labyrinth[row][col] = BLOCK_CHAR

				length -= 1
				row += inc_row
				col += inc_col

			end

		end

		def valid_moves(row, col)

			output = []

			if can_step_on(row + 1, col)
				output.push(Directions::DOWN)
			end
			
			if can_step_on(row - 1, col)
				output.push(Directions::UP)
			end

			if can_step_on(row, col + 1)
				output.push(Directions::RIGHT)
			end

			if can_step_on(row, col - 1)
				output.push(Directions::LEFT)
			end
			
			return output

		end

		def put_player_2d(old_row, old_col, row, col, player)
			
			output = nil

			if self.can_step_on(row, col)

				if self.pos_ok(old_row, old_col)

					p = @players[old_row][old_col]

					if p == player

						self.update_old_pos(old_row, old_col)
						@players[old_row][old_col] = nil

					end

				end

				monster_pos = self.monster_pos(row, col)

				if monster_pos

					@labyrinth[row][col] = COMBAT_CHAR
					output = @monsters[row][col]

				else

					number = player.number
					@labyrinth[row][col] = number

				end

				@players[row][col] = player
				player.set_pos(row, col)

			end

			return output

		end

		def have_a_winner
			return @players[@exit_row][@exit_col] != nil
		end

		def to_s

			string = ""
			
			@n_rows.times do |i|

				@n_cols.times do |j|
					string += @labyrinth[i][j]
				end

				string += "\n"
				
			end
			
			return string

		end

		private

		def pos_ok(row, col)
			return row >= 0 && row < @n_rows && col >=0 && col < @n_cols
		end

		def empty_pos(row, col)
			return pos_ok(row, col) && @labyrinth[row][col] == EMPTY_CHAR
		end

		def monster_pos(row, col)
			return pos_ok(row, col) && @labyrinth[row][col] == MONSTER_CHAR
		end

		def exit_pos(row, col)
			return pos_ok(row, col) && @labyrinth[row][col] == EXIT_CHAR
		end

		def combat_pos(row, col)
			return pos_ok(row, col) && @labyrinth[row][col] == COMBAT_CHAR
		end

		def can_step_on(row, col)
			return empty_pos(row, col) || monster_pos(row, col) || exit_pos(row, col)
		end

		def add_monster(row, col, monster)

			if empty_pos(row, col)

				@labyrinth[row][col] = MONSTER_CHAR
				@monsters[row][col] = monster
				monster.set_pos(row, col)

			end

		end

		def update_old_pos(row, col)

			if pos_ok(row, col)

				if @labyrinth[row][col] == COMBAT_CHAR
					@labyrinth[row][col] = MONSTER_CHAR
				else
					@labyrinth[row][col] = EMPTY_CHAR
				end

			end

		end

		def dir_2_pos(row, col, direction)

			case direction

			when Directions::UP
				row -= 1

			when Directions::DOWN
				row += 1

			when Directions::LEFT
				col -= 1

			when Directions::RIGHT
				col += 1

			end

			return [row, col]

		end

		def random_empty_pos

			row = -1
			col = -1

			loop do

				row = Dice.random_pos(@n_rows)
				col = Dice.random_pos(@n_cols)
				break if empty_pos(row, col)

			end

			return [row, col]

		end

		def substitute_player(old_player, new_player)
			@players[old_player.row][old_player.col] = new_player
		end

	end

end