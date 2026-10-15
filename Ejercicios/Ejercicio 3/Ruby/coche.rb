# enconding: UTF-8

require_relative 'motor'

module Mecanica

	class Coche

		def initialize(modelo)

			@modelo = modelo
			@motor = Mecanica::Motor.new

		end

		def encender
			@motor.arrancar
		end

		def acelerar
			puts "Coche acelerado." if @motor.encendido
		end

		def revisar_motor
			@motor.ver_temperatura
		end

	end

end