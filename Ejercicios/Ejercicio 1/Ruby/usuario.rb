class Usuario

	attr_reader :nombre, :email
	attr_accessor :rol

	def initialize(nombre, email, rol)

		@nombre = nombre
		@email = email
		@rol = rol

	end

	def mostrar_info
		puts "Me llamo " + @nombre + ", mi email es " + @email + " y soy " + @rol.to_s + "."
	end

end