1.Set up a map of prices for a number of gizmos that you covet. Then produce a second map with the same keys and the prices at a 10 percent discount.
``` scala
scala> val gizmos = Map("iPhone 6s" -> 5288, "iPhone 6s Plus" -> 6288, "iPad" -> 3288)
gizmos: scala.collection.immutable.Map[String,Int] = Map(iPhone 6s -> 5288, iPhone 6s Plus -> 6288, iPad -> 3288)

scala> val gizmosWithDiscount = for((k,v) <- gizmos) yield (k, v * 0.9)
gizmosWithDiscount: scala.collection.immutable.Map[String,Double] = Map(iPhone 6s -> 4759.2, iPhone 6s Plus -> 5659.2, iPad -> 2959.2000000000003)
```

2.Write a program that reads words from a file. Use a mutable map to count how often each word appears. To read the words, simply use a java.util.Scanner:
``` scala
val in = new java.util.Scanner(new java.io.File("myfile.txt"))
while (in.hasNext()) process in.next()
```
Or look at Chapter 9 for a Scalaesque way.
At the end, print out all words and their counts.
``` scala
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
```

3.Repeat the preceding exercise with an immutable map.
``` scala
import scala.collection.immutable.HashMap

def wordcount(filepath: String): Map[String, Int] = {
  val in = new java.util.Scanner(new java.io.File(filepath))
  var wordMap = new HashMap[String, Int]()
  while (in.hasNext()) {
    val line = in.next()
    val tokens = line.split("\\W+")
    tokens.foreach(token => wordMap += token -> (wordMap.getOrElse(token, 0) + 1))
  }
  wordMap
}
```

4.Repeat the preceding exercise with a sorted map, so that the words are printed in sorted order.
``` scala
import scala.collection.immutable.TreeMap

def wordcount(filepath: String): Map[String, Int] = {
  val in = new java.util.Scanner(new java.io.File(filepath))
  var wordMap = new TreeMap[String, Int]()
  while (in.hasNext()) {
    val line = in.next()
    val tokens = line.split("\\W+")
    tokens.foreach(token => wordMap += token -> (wordMap.getOrElse(token, 0) + 1))
  }
  wordMap
}
```

5.Repeat the preceding exercise with a java.util.TreeMap that you adapt to the Scala API.
``` scala
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
```
6.Define a linked hash map that maps "Monday" to java.util.Calendar.MONDAY, and similarly for the other weekdays. Demonstrate that the elements are visited in insertion order.
``` scala
import scala.collection.mutable.LinkedHashMap

val weekdays = new LinkedHashMap[String, Int]()
weekdays += ("Monday" -> java.util.Calendar.MONDAY)
weekdays += ("Tuesday" -> java.util.Calendar.TUESDAY)
weekdays += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
weekdays += ("Thursday" -> java.util.Calendar.THURSDAY)
weekdays += ("Friday" -> java.util.Calendar.FRIDAY)
weekdays += ("Saturday" -> java.util.Calendar.SATURDAY)
weekdays += ("Sunday" -> java.util.Calendar.SUNDAY)
```

7.Print a table of all Java properties, like this:
``` scala
java.runtime.name             | Java(TM) SE Runtime Environment
sun.boot.library.path         | /home/apps/jdk1.6.0_21/jre/lib/i386
java.vm.version               | 17.0-b16
java.vm.vendor                | Sun Microsystems Inc.
java.vendor.url               | http://java.sun.com/
path.separator                | :
java.vm.name                  | Java HotSpot(TM) Server VM
```
You need to find the length of the longest key before you can print the table.
``` scala
import scala.collection.JavaConversions.propertiesAsScalaMap

def javaProperties = propertiesAsScalaMap(System.getProperties())
var lengthOfLongestKey = javaProperties.keySet.map(_.length).max
for((k, v) <- javaProperties) {
  printf("%-" + lengthOfLongestKey + "s | %s\n", k, v)
}
```

8.Write a function minmax(values: Array[Int]) that returns a pair containing the smallest and largest values in the array.
``` scala
def minmax(values: Array[Int]) = {
  (values.min, values.max)
}
```

9.Write a function lteqgt(values: Array[Int], v: Int) that returns a triple containing the counts of values less than v, equal to v, and greater than v.
``` scala
def lteqgt(values: Array[Int], v: Int): Tuple2[Int, Int] = {
  (values.count(_ < v), values.count(_ > v))
}
```

10.What happens when you zip together two strings, such as "Hello".zip("World")? Come up with a plausible use case.
``` scala
scala> "Hello".zip("World")
res1: scala.collection.immutable.IndexedSeq[(Char, Char)] = Vector((H,W), (e,o), (l,r), (l,l), (o,d))
```