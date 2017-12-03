import org.scalatest._

class HangmanGameSpec extends FunSpec with Matchers {
  describe("#validInput") {
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
  }
}
