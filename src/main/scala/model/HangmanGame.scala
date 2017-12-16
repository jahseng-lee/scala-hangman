package model

object HangmanGame {
  def validInput(input: String): Boolean = {
    input.length() == 1 && input.charAt(0).isLetter
  }

  def running: Boolean = {
    true
  }

  def takeTurn(gameState: HangmanGame, input: String): HangmanGame = {
    gameState.copy(
      guesses = gameState.guesses :+ input
    )
  }
}

case class HangmanGame(startingLives: Int, word: String, guesses: List[String] = List()) {
  def lives: Int = {
    startingLives - incorrectGuesses.size
  }

  private def incorrectGuesses: List[String] = {
    guesses.filter(
      guess => !word.contains(guess)
    )
  }
}
