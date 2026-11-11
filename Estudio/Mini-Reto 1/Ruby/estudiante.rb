# encoding: UTF-8

module Matricula

	class Estudiante

		@@contador_estudiantes = 0
		
		def initialize(nombre, email = "pendiente@ugr.es")

			@nombre = nombre
			@email = email

			@@contador_estudiantes += 1

		end

		def self.contador_estudiantes
			return @@contador_estudiantes
		end

		def datos
			return @nombre + " " + @email
		end

	end

end