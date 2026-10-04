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

		def spread_players
			raise NotImplementedError.new
		end
			
		def put_player
			raise NotImplementedError.new
		end

		def add_block
			raise NotImplementedError.new
		end

		def valid_moves
			raise NotImplementedError.new
		end

		def put_player_2d
			raise NotImplementedError.new
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

	end

end