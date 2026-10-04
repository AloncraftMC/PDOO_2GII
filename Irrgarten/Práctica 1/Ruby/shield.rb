# encoding: UTF-8

module Irrgarten

    class Shield

        def initialize(protection, uses)

            @protection = protection
            @uses = uses

        end

        def protect

            return 0 if @uses <= 0

            @uses -= 1
            return @protection

        end

        def discard
            return Dice.discard_element(@uses)
        end

        def to_s
            return "S[" + @protection.to_s + ", " + @uses.to_s + "]"
        end

    end

end