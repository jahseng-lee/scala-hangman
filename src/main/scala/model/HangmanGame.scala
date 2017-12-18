package model

object HangmanGame {
  def validInput(input: String): Boolean = {
    input.length() == 1 && input.charAt(0).isLetter
  }

  def takeTurn(gameState: HangmanGame, input: String): HangmanGame = {
    gameState.copy(
      guesses = gameState.guesses + input
    )
  }
}

case class HangmanGame(startingLives: Int, word: String, guesses: Set[String] = Set()) {
  def lives: Int = {
    startingLives - incorrectGuesses.size
  }

  def running: Boolean = {
    isWon || isLost
  }

  def isWon: Boolean = {
    word.filter(c => guesses.contains(c.toString)).size == word.length
  }

  def isLost: Boolean = {
    lives == 0
  }

  private def incorrectGuesses: Set[String] = {
    guesses.filter(
      guess => !word.contains(guess)
    )
  }
}
