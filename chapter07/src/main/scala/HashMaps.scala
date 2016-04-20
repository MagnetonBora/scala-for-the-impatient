import java.util.{HashMap=> JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}

object HashMaps {
  def main(args: Array[String]) = {
    val javaHashMap = new JavaHashMap[Int, String]()
    javaHashMap.put(1, "A")
    javaHashMap.put(2, "B")

    val scalaHashMap = new ScalaHashMap[Int, String]()
    val entryIterator = javaHashMap.entrySet().iterator()
    while(entryIterator.hasNext) {
      val entry = entryIterator.next()
      scalaHashMap.put(entry.getKey(), entry.getValue)
    }

    Console.println(scalaHashMap)
  }
}