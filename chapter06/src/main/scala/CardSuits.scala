
object CardSuits extends Enumeration{
  type CardSuits = Value
  val SPADE = Value("♠")
  val CLUB = Value("♣")
  val HEART = Value("♥")
  val DIAMOND = Value("♦")

  def isRed(card: CardSuits) = {
    card == HEART || card == DIAMOND
  }
}
