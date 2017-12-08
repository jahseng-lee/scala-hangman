package controller

import model._
import view._

object Hangman {
  def main(args: Array[String]): Unit = {
    val game = new HangmanGame
    val view = new HangmanView

    view.printGreeting

    while(game.running) {
      val input = view.askForInput

      if(game.validInput(input)) {
        System.exit(0)
      } else {
        view.printInvalidInputWarning(input)
      }
    }
  }
}
