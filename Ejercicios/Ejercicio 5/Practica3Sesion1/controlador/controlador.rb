module Controlador
  class ControladorPerfilUsuario
    def initialize(usuario, vista)
      @usuario = usuario
      @vista = vista
    end

    def mostrar_perfil
      @vista.mostrar_perfil(@usuario)
    end

    def actualizar_perfil
      nuevo_nombre = @vista.solicitar_nuevo_nombre
      nuevo_apellido = @vista.solicitar_nuevo_apellido
      @usuario.nombre = nuevo_nombre
      @usuario.apellidos = nuevo_apellido

      puts "Nombre actualizado exitosamente."
      mostrar_perfil  # Muestra el perfil actualizado
    end

    def actualizar_informacion_contacto
      direccion, email, telefono = @vista.solicitar_informacion_contacto
      @usuario.contacto.direccion = direccion
      @usuario.contacto.email = email
      @usuario.contacto.telefono = telefono

      puts "Información de contacto actualizada exitosamente."
      mostrar_perfil  # Muestra el perfil actualizado
    end
  end
end
