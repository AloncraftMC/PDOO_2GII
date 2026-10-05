# encoding: UTF-8

module Irrgarten

	class Monster < LabyrinthCharacter

		INITIAL_HEALTH = 5

		def initialize(name, intelligence, strength)
			super(name, intelligence, strength, INITIAL_HEALTH)
		end

		def attack
			return Dice.intensity(@strength)
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