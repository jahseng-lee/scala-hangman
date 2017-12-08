package view

object HangmanView {
  def printGreeting: Unit = {
    println("Welcome to Hangman!")
    printDivider
  }

  def printInvalidInputWarning(input: String): Unit = {
    println(s"$input is not a valid guess.")
    printDivider
  }

  private def printDivider: Unit = {
    println("~" * 20)
  }

  def askForInput: String = {
    readLine("Please enter a leter: ")
  }
}
