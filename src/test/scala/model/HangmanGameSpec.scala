package model

import org.scalatest._

class HangmanGameSpec extends FunSpec with Matchers {
  describe("#validInput") {
    describe("given a string of two or more letters") {
      it("returns false") {
        val game = new HangmanGame

        assert(game.validInput("ff") == false)
      }
    }

    describe("given a one character, non-alphabetical string") {
      it("returns false") {
        val game = new HangmanGame

        assert(game.validInput("1") == false)
      }
    }

    describe("given a one character, alphabetical string") {
      it("returns true") {
        val game = new HangmanGame

        assert(game.validInput("f") == false)
      }
    }
  }
}
