# encoding: UTF-8

require_relative 'directions'
require_relative 'orientation'
require_relative 'dice'
require_relative 'game_character'
require_relative 'weapon'
require_relative 'shield'
require_relative 'player'
require_relative 'monster'
require_relative 'labyrinth'
require_relative 'game_state'
require_relative 'game'
require_relative 'textUI'
require_relative 'controller'

module Irrgarten

	game = Game.new(1)

	text_ui = UI::TextUI.new
	controller = Control::Controller.new(game, text_ui)

	controller.play

end