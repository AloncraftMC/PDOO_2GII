# encoding: UTF-8

require_relative 'asignatura'
require_relative 'estudiante'

puts "Número de estudiantes del sistema: " + Matricula::Estudiante.contador_estudiantes.to_s

pdoo = Matricula::Asignatura.new("PDOO")

pdoo.matricular_estudiante(Matricula::Estudiante.new("Carmen", "cm@ugr.es"))
pdoo.matricular_estudiante(Matricula::Estudiante.new("Antonio"))

puts "Número de estudiantes del sistema: " + Matricula::Estudiante.contador_estudiantes.to_s

puts pdoo.ejercicio