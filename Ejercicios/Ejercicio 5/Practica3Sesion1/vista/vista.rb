module Vista
  class VistaPerfilUsuario
    def mostrar_perfil(usuario)
      puts "Perfil de usuario: #{usuario.nombre_completo}"
      puts "Dirección: #{usuario.contacto.direccion}"
      puts "Email: #{usuario.contacto.email}"
      puts "Teléfono: #{usuario.contacto.telefono}"
    end

    def solicitar_nuevo_nombre
      print "Ingresa el nuevo nombre para el perfil: "
      gets.chomp
    end

    def solicitar_nuevo_apellido
      print "Ingresa los nuevos apellidos para el perfil: "
      gets.chomp
    end

    def solicitar_informacion_contacto
      print "Ingresa la dirección: "
      direccion = gets.chomp
      print "Ingresa el email: "
      email = gets.chomp
      print "Ingresa el teléfono: "
      telefono = gets.chomp
      [direccion, email, telefono]
    end
  end
end
