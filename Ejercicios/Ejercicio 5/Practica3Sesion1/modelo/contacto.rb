module Modelo
  class Contacto
    attr_accessor :direccion, :email, :telefono

    def initialize(direccion, email, telefono)
      @direccion = direccion
      @email = email
      @telefono = telefono
    end
  end
end
