import scala.util.Random

def randomArray(n : Int): Array[Int] = {
  val randomIntegers = new Array[Int](n)
  for(i <- 0 until n) {
    randomIntegers(i) = Random.nextInt(n)
  }

  randomIntegers
}

println(randomArray(10).mkString(","))