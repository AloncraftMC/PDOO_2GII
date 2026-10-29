require_relative 'modelo/contacto'
require_relative 'modelo/usuario'
require_relative 'vista/vista'
require_relative 'controlador/controlador'

def flujoApp(controlador)
  controlador.mostrar_perfil
  controlador.actualizar_perfil
  controlador.actualizar_informacion_contacto
end


# Inicialización de MVC

contacto = Modelo::Contacto.new("Calle Parra", "fulano@mail.com", 661225446)
usuario = Modelo::Usuario.new("Fulano", "Pérez", contacto)

vista = Vista::VistaPerfilUsuario.new

controlador = Controlador::ControladorPerfilUsuario.new(usuario, vista)

# llamada a la función flujoApp
flujoApp(controlador)


