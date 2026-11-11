# encoding: UTF-8

module Matricula

	class Asignatura

		def initialize(nombre)
			@nombre = nombre
			@estudiantes = Array.new
		end

		def matricular_estudiante(estudiante)
			@estudiantes.push(estudiante)
		end

		def ejercicio

			res = ""

			@estudiantes.each do |estudiante|

				res_est = estudiante.datos

				res += res_est + ", "

			end

			return res

		end

	end

end