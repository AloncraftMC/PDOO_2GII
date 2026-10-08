# encoding: UTF-8

require_relative 'usuario'
require_relative 'rol_usuario'

module Main

	usuario1 = Usuario::Usuario.new("Invitado", "guest@guest.com", Usuario::RolUsuario::INVITADO)
	usuario2 = Usuario::Usuario.new("Fulano", "fulano@mail.com", Usuario::RolUsuario::BASICO)
	usuario3 = Usuario::Usuario.new("Dios", "dios@god.com", Usuario::RolUsuario::ADMIN)
	puts "Total Usuarios: " + Usuario::Usuario.obtener_total_usuarios.to_s

	usuario1.eliminar
	puts "Total Usuarios: " + Usuario::Usuario.obtener_total_usuarios.to_s

	usuario2.eliminar
	puts "Total Usuarios: " + Usuario::Usuario.obtener_total_usuarios.to_s

	usuario2.mostrar_perfil
	puts "Total Usuarios: " + Usuario::Usuario.obtener_total_usuarios.to_s

end