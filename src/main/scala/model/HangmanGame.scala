package model

class HangmanGame {
  def validInput(input: String): Boolean = {
    input.length() == 1 && input.charAt(0).isLetter
  }

  def running: Boolean = {
    true
  }
}
