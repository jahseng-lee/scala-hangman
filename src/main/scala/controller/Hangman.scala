package controller

import model._
import view._

object Hangman {
  def main(args: Array[String]): Unit = {
    val gameState = new HangmanGame(
      startingLives = 10,
      word = "Hangman"
    )

    HangmanView.printGreeting

    while(HangmanGame.running) {
      val input = HangmanView.askForInput

      if(HangmanGame.validInput(input)) {
        HangmanGame.takeTurn(gameState, input)
      } else {
        HangmanView.printInvalidInputWarning(input)
      }
    }
  }
}
