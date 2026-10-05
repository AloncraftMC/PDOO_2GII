# encoding: UTF-8

module Irrgarten

	class LabyrinthCharacter

		attr_reader :name, :row, :col, :intelligence, :strength
		attr_accessor :health

		def initialize(name, intelligence, strength, health)

			@name = name
			@intelligence = intelligence
			@strength = strength
			@health = health

			@row = -1
			@col = -1

		end

		def copy(other)

			@name = other.name
			@intelligence = other.intelligence
			@strength = other.strength
			@health = other.health
			@row = other.row
			@col = other.col

		end

		def dead
			return @health <= 0
		end

		def set_pos(row, col)

			if row >= 0 && col >= 0
				@row = row
				@col = col
			end
			
		end

		def got_wounded
			@health -= 1
		end

		def to_s
			return "[#{@health} ♥] #{@name} at #{@row}, #{@col}\n
				Intelligence: #{@intelligence}\n
				Strength: #{@strength}\n"
		end

		def attack
			raise NotImplementedError.new
		end

		def defend(received_attack)
			raise NotImplementedError.new
		end

	end

end