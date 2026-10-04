# encoding: UTF-8

module Irrgarten

	class Player

		MAX_WEAPONS = 2
		MAX_SHIELDS = 3
		INITIAL_HEALTH = 10
		HITS2LOSE = 3

		def initialize(number, intelligence, strength)

			@name = "Player ##{number}"
			
			@number = number
			@intelligence = intelligence
			@strength = strength

			@consecutive_hits = 0

			@health = INITIAL_HEALTH

			@weapons = []
			@shields = []

		end

		def move
			raise NotImplementedError.new
		end

		def receive_reward
			raise NotImplementedError.new
		end

		def receive_weapon
			raise NotImplementedError.new
		end

		def receive_shield
			raise NotImplementedError.new
		end

		def manage_hit
			raise NotImplementedError.new
		end

		def set_pos(row, col)
			
			if row >= 0 && col >= 0
				@row = row
				@col = col
			end

		end

		def dead
			return @health <= 0
		end

		def reset_hits
			@consecutive_hits = 0
		end

		def inc_consecutive_hits
			@consecutive_hits += 1
		end

		def got_wounded
			@health -= 1
		end

		def attack
			return @strength + sum_weapons
		end

		def defend(received_attack)
			raise NotImplementedError.new
		end

		def sum_weapons

			sum = 0
			@weapons.each{|weapon| sum += weapon.attack}
			return sum

		end

		def sum_shields

			sum = 0
			@shields.each{|shield| sum += shield.protect}
			return sum

		end

		def defensive_energy
			return @intelligence + sum_shields
		end

		def new_weapon
			return Weapon.new(Dice.weapon_power, Dice.uses_left)
		end

		def new_shield
			return Shield.new(Dice.shield_power, Dice.uses_left)
		end

		def resurrect

		end

		def to_s

		end

	end

end