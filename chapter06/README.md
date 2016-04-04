1.Write an object Conversions with methods inchesToCentimeters, gallonsToLiters, and milesToKilometers.
``` scala
object Conversions {

  def inchesToCentimeters(value: Double) = {
    value * 2.54
  }
  
  def gallonsToLiters(value: Double) = {
    value * 3.78541178
  }
  
  def milesToKilometers(value: Double) = {
    value * 1.609344
  }
}
```

2.The preceding problem wasn’t very object-oriented. Provide a general superclass UnitConversion and define objects InchesToCentimeters, GallonsToLiters, and MilesToKilometers that extend it.
``` scala
class UnitConversion(val factor: Double){
  def convert(value: Double) = {
    value * factor
  }
}
```
``` scala
object InchesToCentimeters extends UnitConversion(2.54) {

}
```
``` scala
class GallonsToLiters extends UnitConversion(3.78541178) {

}
```
``` scala
class MilesToKilometers extends UnitConversion(1.609344) {

}
```

3.Define an Origin object that extends java.awt.Point. Why is this not actually a good idea? (Have a close look at the methods of the Point class.)
``` scala
object Origin extends java.awt.Point {
  
}
```

4.Define a Point class with a companion object so that you can construct Point instances as Point(3, 4), without using new.
``` scala
class Point(var x: Double, var y: Double) {

  override def toString = "(" + x + "," + y +")"
}

object Point {
  def apply(x: Double, y: Double) = {
    new Point(x, y)
  }
}
```

5.Write a Scala application, using the App trait, that prints the command-line arguments in reverse order, separated by spaces. For example, scala Reverse Hello World should print World Hello.
``` scala
object Reverse extends App{
  if (args.length > 0) {
    println(args.reverse.mkString(" "))
  }
}
```

6.Write an enumeration describing the four playing card suits so that the toString method returns ♣, ♦, ♥, or ♠.
``` scala
object CardSuits extends Enumeration{
  type CardSuits = Value
  val SPADE = Value("♠")
  val CLUB = Value("♣")
  val HEART = Value("♥")
  val DIAMOND = Value("♦")
}
```

7.Implement a function that checks whether a card suit value from the preceding exercise is red.
``` scala
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
```

8.Write an enumeration describing the eight corners of the RGB color cube. As IDs, use the color values (for example, 0xff0000 for Red).
``` scala
object RGB extends Enumeration {
  val BLACK = Value(0x000000, "Black")
  val RED = Value(0xff0000, "Red")
  val GREEN = Value(0x00ff00, "Green")
  val BLUE = Value(0x0000ff, "Blue")
  val YELLOW = Value(0xffff00, "Yellow")
  val MAGENTA = Value(0xff00ff, "Magenta")
  val CYAN = Value(0x00ffff, "Cyan")
  val WHITE = Value(0xffffff, "White")
}
```