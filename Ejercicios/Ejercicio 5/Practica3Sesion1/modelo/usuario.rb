module Modelo
  class Usuario
    attr_accessor :nombre, :apellidos, :contacto

    def initialize(nombre, apellidos, contacto)
      @nombre = nombre
      @apellidos = apellidos
      @contacto = contacto
    end

    def nombre_completo
      "#{@nombre} #{@apellidos}"
    end
  end
end
