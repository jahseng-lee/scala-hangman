package model

import org.scalatest._

class HangmanGameSpec extends FunSpec with Matchers {
  describe(".validInput") {
    describe("given a string of two or more letters") {
      it("returns false") {
        assert(HangmanGame.validInput("ff") == false)
      }
    }

    describe("given a one character, non-alphabetical string") {
      it("returns false") {
        assert(HangmanGame.validInput("1") == false)
      }
    }

    describe("given a one character, alphabetical string") {
      it("returns true") {
        assert(HangmanGame.validInput("f") == true)
      }
    }

    describe(".taketurn") {
      describe("given a gameState with 10 lives") {
        val gameState = new HangmanGame(
          startingLives = 10,
          word = "Foo"
        )

        describe("given an input contained in gameState#word") {
          val wordArray = gameState.word.toCharArray
          val input = wordArray(0).toString

          it("returns a new HangmanGame with input inside guesses") {
            val newGameState = HangmanGame.takeTurn(gameState, input)

            assert(newGameState.guesses.contains(input))
          }

          it("returns a new HangmanGame with the same amount of lives") {
            val newGameState = HangmanGame.takeTurn(gameState, input)

            assert(newGameState.lives == gameState.lives)
          }
        }

        describe("given an input not contained in gameState#word") {
          val input = "b"

          it("returns a new HangmanGame with input inside guesses") {
            val newGameState = HangmanGame.takeTurn(gameState, input)

            assert(newGameState.guesses.contains(input))
          }

          it("returns a new HangmanGame with gameState.lives - 1") {
            val newGameState = HangmanGame.takeTurn(gameState, input)

            assert(newGameState.lives == gameState.lives - 1)
          }
        }
      }
    }
  }
}
