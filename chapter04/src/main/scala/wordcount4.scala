import java.util.Map
import java.util.TreeMap

def wordcount(filepath: String): Map[String, Int] = {
  val in = new java.util.Scanner(new java.io.File(filepath))
  var wordMap = new TreeMap[String, Int]()
  while (in.hasNext()) {
    val line = in.next()
    val tokens = line.split("\\W+")
    tokens.foreach(token =>
      if (wordMap.containsKey(token)) {
        wordMap.put(token, wordMap.get(token) + 1)
      } else {
        wordMap.put(token, 1)
      })
  }
  wordMap
}