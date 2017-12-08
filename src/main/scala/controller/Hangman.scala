package controller

import model._
import view._

object Hangman {
  def main(args: Array[String]): Unit = {
    val game = new HangmanGame

    HangmanView.printGreeting

    while(game.running) {
      val input = HangmanView.askForInput

      if(game.validInput(input)) {
        System.exit(0)
      } else {
        HangmanView.printInvalidInputWarning(input)
      }
    }
  }
}
