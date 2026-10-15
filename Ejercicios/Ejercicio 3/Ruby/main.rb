# enconding: UTF-8

require_relative 'coche'
require_relative 'conductor'

module Main

	coche = Mecanica::Coche.new("Skoda Fabia")
	conductor = Usuario::Conductor.new("Fulano")

	conductor.viajar(coche)
	coche.revisar_motor

end