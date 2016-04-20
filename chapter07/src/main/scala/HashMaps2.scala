
object HashMaps2 {
  def main(args: Array[String]) = {
    import java.util.{HashMap => JavaHashMap}
    val javaHashMap = new JavaHashMap[Int, String]()
    javaHashMap.put(1, "A")
    javaHashMap.put(2, "B")

    import scala.collection.mutable.{HashMap => ScalaHashMap}
    val scalaHashMap = new ScalaHashMap[Int, String]()
    val entryIterator = javaHashMap.entrySet().iterator()
    while(entryIterator.hasNext) {
      val entry = entryIterator.next()
      scalaHashMap.put(entry.getKey(), entry.getValue)
    }

    Console.println(scalaHashMap)
  }
}