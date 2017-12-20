package view

import model._

object HangmanView {
  def printGreeting: Unit = {
    println("Welcome to Hangman!")
    printDivider
  }

  def printTurnResult(state: HangmanGame): Unit = {
    val word = state.word
    if(state.isWon) {
      printWinMessage(word)
    } else if(state.isLost) {
      printLossMessage(word)
    } else {
      printResult(state)
    }

    printDivider
  }

  private def printWinMessage(word: String): Unit = {
    println(s"You win! The word was $word")
  }

  private def printLossMessage(word: String): Unit = {
    println(s"You've lost! The word was $word")
  }

  private def printResult(state: HangmanGame): Unit = {
    val lastGuess = state.lastGuess
    val livesLeft = state.lives
    val incorrectGuesses = state.incorrectGuesses.toString

    if(state.lastTurnSuccessful) {
      printCorrectTurnResult(lastGuess)
    } else {
      printIncorrectTurnResult(lastGuess)
    }
    println(s"You have $livesLeft lives left")
    println(s"Incorrect guesses: $incorrectGuesses")
  }

  private def printCorrectTurnResult(lastGuess: String): Unit = {
    println(s"You guessed $lastGuess, which was in the word!")
  }

  private def printIncorrectTurnResult(lastGuess: String): Unit = {
    println(s"You guessed $lastGuess, which was not in the word!")
  }

  def printInvalidInputWarning(input: String): Unit = {
    println(s"$input is not a valid guess.")
    printDivider
  }

  def askForInput: String = {
    readLine("Please enter a leter: ")
  }

  private def printDivider: Unit = {
    println("~" * 20)
  }
}
