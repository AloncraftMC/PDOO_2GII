# encoding: UTF-8

module Irrgarten

	class CombatElement

		def initialize(effect, uses)
			
			@effect = effect
			@uses = uses

		end

		def produce_effect

			return 0 if @uses <= 0

			@uses -= 1
			return @effect

		end

		def discard
			return Dice.discard_element(@uses)
		end

		def to_s
			return "[" + @effect.to_s + ", " + @uses.to_s + "]"
		end

	end

end