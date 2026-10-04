# encoding: UTF-8

module Irrgarten

    class Weapon

        def initialize(power, uses)

            @power = power
            @uses = uses

        end

        def attack

            return 0 if @uses <= 0

            @uses -= 1
            return @power

        end

        def discard
            return Dice.discard_element(@uses)
        end

        def to_s
            return "W[" + @power.to_s + ", " + @uses.to_s + "]"
        end

    end

end