object Hangman {
  def main(args: Array[String]): Unit = {
    val game = new HangmanGame

    println("Welcome to Hangman!")
    println("~" * 20)

    while(game.running) {
      val input = readLine("Please enter a leter: ")

      if(game.validInput(input)) {
        System.exit(0)
      }
    }
  }
}
