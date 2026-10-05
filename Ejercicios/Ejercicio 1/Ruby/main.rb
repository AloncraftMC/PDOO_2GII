require_relative "rol_usuario"
require_relative "usuario"

usuario1 = Usuario.new("Fulano", "fulano@mail.com", RolUsuario::BASICO)
usuario2 = Usuario.new("Dios", "dios@god.com", RolUsuario::ADMIN)

usuario1.rol = RolUsuario::INVITADO

puts usuario1.email
puts usuario2.email

usuario1.mostrar_info
usuario2.mostrar_info