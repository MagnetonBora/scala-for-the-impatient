
package object random {
  val a = 1664525
  val b = 1013904223
  val n = 32

  var seed = 1

  def nextInt(): Int = {
    ((seed * a + b) % Math.pow(2, n)).toInt
  }

  def nextDouble():Double = {
    (seed * a + b) % Math.pow(2, n)
  }

  def setSeed(seed: Int): Unit = {
    this.seed = seed
  }
}
