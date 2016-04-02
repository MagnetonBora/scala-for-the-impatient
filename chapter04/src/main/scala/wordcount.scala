import scala.collection.mutable.Map
import scala.collection.mutable.HashMap

def wordcount(filepath: String): Map[String, Int] = {
  val in = new java.util.Scanner(new java.io.File(filepath))
  val wordMap = new HashMap[String, Int]()
  while (in.hasNext()) {
    val line = in.next()
    val tokens = line.split("\\W+")
    tokens.foreach(token => wordMap(token) = wordMap.getOrElse(token, 0) + 1)
  }
  wordMap
}