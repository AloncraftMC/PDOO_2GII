# encoding: UTF-8

module Irrgarten

    class Weapon < CombatElement

        def initialize(power, uses)
			super(power, uses)
        end

        def attack
			return produce_effect
        end

        def to_s
			return "W" + super
        end

    end

end