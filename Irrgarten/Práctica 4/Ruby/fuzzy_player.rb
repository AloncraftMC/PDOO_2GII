# encoding: UTF-8

module Irrgarten

	class FuzzyPlayer < Player

		def initialize(other)
			copy(other)
		end

		def move(direction, valid_moves)

			preferred_direction = super(direction, valid_moves)
			return Dice.next_step(preferred_direction, valid_moves, @intelligence)

		end

		def attack
			return sum_weapons + Dice.intensity(@strength)
		end

		def defensive_energy
			return sum_shields + Dice.intensity(@intelligence)
		end

		def to_s
			return "Fuzzy " + super
		end
		
	end

end