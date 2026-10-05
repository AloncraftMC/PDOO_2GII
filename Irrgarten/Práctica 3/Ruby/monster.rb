# encoding: UTF-8

module Irrgarten

	class Monster

		INITIAL_HEALTH = 5

		def initialize(name, intelligence, strength)

			@name = name
			@intelligence = intelligence
			@strength = strength

			@health = INITIAL_HEALTH

			@row = -1
			@col = -1

		end

		def dead
			return @health <= 0
		end

		def attack
			return Dice.intensity(@strength)
		end

		def set_pos(row, col)

			if row >= 0 && col >= 0
				@row = row
				@col = col
			end
			
		end

		def to_s
			return "[#{@health} ♥] #{@name} at #{@row}, #{@col}\n
				Intelligence: #{@intelligence}\n
				Strength: #{@strength}\n";
		end

		def got_wounded
			@health -= 1;
		end

		def defend(received_attack)
			
			is_dead = self.dead

			if !is_dead

				defensive_energy = Dice.intensity(@intelligence)
				
				if defensive_energy < received_attack
					self.got_wounded
				end
				
				is_dead = self.dead

			end

			return is_dead

		end

	end
	
end