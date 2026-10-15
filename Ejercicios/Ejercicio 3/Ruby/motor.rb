# enconding: UTF-8

module Mecanica

	class Motor

		attr_reader :temperatura
		attr_accessor :encendido

		def initialize

			@encendido = false
			@temperatura = 25.0

		end

		def inyectar_combustible
			puts "Combustible inyectado en el motor."
		end

		def arrancar
			@encendido = true
			self.inyectar_combustible
		end

		def ver_temperatura
			puts @temperatura < 50.0 ? "Temperatura: Alta" : "Temperatura: Baja"
		end

	end

end