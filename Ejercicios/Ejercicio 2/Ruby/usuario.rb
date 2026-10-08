# encoding: UTF-8

module Usuario

	class Usuario

		attr_reader :nombre, :email
		attr_accessor :rol

		@@total_usuarios = 0

		def initialize(nombre, email, rol)

			@nombre = nombre
			@email = email
			@rol = rol
			@activo = true

			@@total_usuarios += 1

		end

		def mostrar_perfil
			puts @activo ? "Me llamo " + @nombre + ", mi email es " + @email + " y soy " + @rol.to_s + "." : "Usuario Eliminado."
		end

		def ascender

			if @rol == RolUsuario::INVITADO
				@rol = RolUsuario::BASICO
			
			elsif @rol == RolUsuario::BASICO
				@rol = RolUsuario::ADMIN

			end
				
		end

		def eliminar

			if @activo
				@activo = false
				@@total_usuarios -= 1
			end

		end

		def self.obtener_total_usuarios
			return @@total_usuarios
		end

	end

end