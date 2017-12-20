package controller

import model._
import view._

object Hangman {
  def main(args: Array[String]): Unit = {
    HangmanView.printGreeting

    val gameState = new HangmanGame(
      startingLives = 10,
      word = "Hangman"
    )

    repl(gameState)
  }

  def repl(gameState: HangmanGame): Unit = {
    val input = read
    val state = if(HangmanGame.validInput(input)) {
      evaluate(gameState, input)
    } else {
      gameState
    }

    print(state)
    if(state.running) repl(state)
  }

  def read: String = {
    HangmanView.askForInput
  }

  def evaluate(state: HangmanGame, input: String): HangmanGame = {
    HangmanGame.takeTurn(state, input)
  }

  def print(state: HangmanGame): Unit = {
    HangmanView.printTurnResult(state)
  }
}
