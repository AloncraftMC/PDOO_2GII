# encoding: UTF-8

module Usuario

	class Conductor

		def initialize(nombre)
			@nombre = nombre
		end

		def viajar(co)
			co.encender
			co.acelerar
		end

	end
	
end