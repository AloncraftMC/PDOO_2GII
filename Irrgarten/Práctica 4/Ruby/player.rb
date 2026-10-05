# encoding: UTF-8

module Irrgarten

	class Player < LabyrinthCharacter

		attr_reader :number, :row, :col, :weapons, :consecutive_hits

		MAX_WEAPONS = 2
		MAX_SHIELDS = 3
		INITIAL_HEALTH = 10
		HITS2LOSE = 3

		def initialize(number, intelligence, strength)

			super("Player ##{number}", intelligence, strength, INITIAL_HEALTH)

			@consecutive_hits = 0

			@weapons = []
			@shields = []

		end

		def copy(other)

			super(other)

			@number = other.number
			@consecutive_hits = other.consecutive_hits

			@weapons = other.weapons.dup
			@shields = other.shields.dup

		end

		def move(direction, valid_moves)

			size = valid_moves.length

			contained = valid_moves.include?(direction)

			return valid_moves[0] if size > 0 && !contained
			return direction

		end

		def receive_reward
			
			weapons_reward = Dice.weapons_reward
			shields_reward = Dice.shields_reward

			weapons_reward.times do
				weapon = new_weapon
				receive_weapon(weapon)
			end

			shields_reward.times do
				shield = new_shield
				receive_shield(shield)
			end

			@health += Dice.health_reward

		end

		def receive_weapon(w)
			
			@weapons.reject! { |wi| wi.discard }
			size = @weapons.size
			
			if size < MAX_WEAPONS
				@weapons.push(w)
			end

		end

		def receive_shield(s)
			
			@shields.reject! { |wi| wi.discard }
			size = @shields.size
			
			if size < MAX_SHIELDS
				@shields.push(s)
			end

		end

		def manage_hit(received_attack)

			defense = defensive_energy

			if defense < received_attack

				self.got_wounded
				self.inc_consecutive_hits

			else	self.reset_hits
			end

			lose = @consecutive_hits == HITS2LOSE || self.dead

			if lose	self.reset_hits
			end

			return lose

		end

		def reset_hits
			@consecutive_hits = 0
		end

		def inc_consecutive_hits
			@consecutive_hits += 1
		end

		def attack
			return @strength + sum_weapons
		end

		def defend(received_attack)
			return self.manage_hit(received_attack)
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

			@health = INITIAL_HEALTH

			@consecutive_hits = 0

			@weapons.clear
			@shields.clear

		end

		def to_s
			return super + "\nWeapons: #{@weapons}\nShields: #{@shields}\nConsecutive Hits: #{@consecutive_hits}"
		end

	end

end