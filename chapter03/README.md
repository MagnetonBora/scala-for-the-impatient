1.Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
``` scala
import scala.util.Random

def randomArray(n : Int) = {
  val randomIntegers = new Array[Int](n)
  for(i <- 0 until n) {
    randomIntegers(i) = Random.nextInt(n)
  }

  randomIntegers
}
```

2.Write a loop that swaps adjacent elements of an array of integers. For example, Array(1, 2, 3, 4, 5) becomes Array(2, 1, 4, 3, 5).
```scala
def swap1(array: Array[Int]) = {
  val clonedArray = array.clone()
  for (i <- Range(1, clonedArray.length, 2)) {
    if (i < clonedArray.length) {
      val tmp = clonedArray(i)
      clonedArray(i) = clonedArray(i-1)
      clonedArray(i-1) = tmp
    }
  }
  clonedArray
}
```

3.Repeat the preceding assignment, but produce a new array with the swapped values. Use for/yield.
``` scala
def swap2(array: Array[Int]) = {
  for(i <- 0 until array.length)
    yield
      if (i % 2 == 0)
        if (i < array.length - 1)
          array(i+1)
        else
          array(i)
      else
        array(i - 1)
}
```

4.Given an array of integers, produce a new array that contains all positive values of the original array, in their original order, followed by all values that are zero or negative, in their original order.
``` scala
def positiveNegative(array: Array[Int]) = {
  array.filter(_ > 0) ++ array.filter(_ <= 0)
}
```

5.How do you compute the average of an Array[Double]?
``` scala
def average(array: Array[Double]): Double = {
  array.sum / array.length
}
```

6.How do you rearrange the elements of an Array[Int] so that they appear in reverse sorted order? How do you do the same with an ArrayBuffer[Int]?
``` scala
def reverseSort(array: Array[Int]): Array[Int] = {
  array.sortWith(_ > _)
}

def reverseSort(arrayBuffer: ArrayBuffer[Int]): ArrayBuffer[Int] = {
  arrayBuffer.sortWith(_ > _)
}
```

7.Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc.)
``` scala
scala> Array(1 ,2 ,2 ,3 ,4 ,3).distinct
res13: Array[Int] = Array(1, 2, 3, 4)
```

8.Rewrite the example at the end of Section 3.4, “Transforming Arrays,” on page 32. Collect indexes of the negative elements, reverse the sequence, drop the last index, and call a.remove(i) for each index. Compare the efficiency of this approach with the two approaches in Section 3.4.
``` scala
scala> val array = Array(1, -3, 4, -5, 6, -8).toBuffer
array: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, -3, 4, -5, 6, -8)

scala> (for(i <- 0 until array.length if array(i) < 0) yield i).reverse.dropRight(1).foreach(array.remove(_))

scala> array
res34: scala.collection.mutable.Buffer[Int] = ArrayBuffer(1, -3, 4, 6)
```

9.Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs that are in America. Strip off the "America/" prefix and sort the result.
```
scala> java.util.TimeZone.getAvailableIDs().filter(_.startsWith("America/")).map(s => s.stripPrefix("America/"))
res41: Array[String] = Array(Adak, Atka, Anchorage, Juneau, Nome, Sitka, Yakutat, Dawson, Ensenada, Los_Angeles, Metlakatla, Santa_Isabel, Tijuana, Vancouver, Whitehorse, Boise, Cambridge_Bay, Chihuahua, Creston, Dawson_Creek, Denver, Edmonton, Hermosillo, Inuvik, Mazatlan, Ojinaga, Phoenix, Shiprock, Yellowknife, Bahia_Banderas, Belize, Chicago, Costa_Rica, El_Salvador, Guatemala, Indiana/Knox, Indiana/Tell_City, Knox_IN, Managua, Matamoros, Menominee, Merida, Mexico_City, Monterrey, North_Dakota/Beulah, North_Dakota/Center, North_Dakota/New_Salem, Rainy_River, Rankin_Inlet, Regina, Resolute, Swift_Current, Tegucigalpa, Winnipeg, Atikokan, Bogota, Cancun, Cayman, Coral_Harbour, Detroit, Eirunepe, Fort_Wayne, Guayaquil, Havana, Indiana/Indianapolis, Indiana/Marengo, Indiana/Petersburg, ...
```

10.Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with the call
``` scala
val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
```
Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor and get the return value as a Scala buffer. (Why this obscure class? It’s hard to find uses of java.util.List in the standard Java library.)
```scala
import java.awt.datatransfer._
import collection.JavaConversions.asScalaBuffer
import collection.mutable.Buffer

val flavors = SystemFlavorMap.getDefaultFlavorMap.asInstanceOf[SystemFlavorMap]

val nativesForFlavors: Buffer[String]= flavors.getNativesForFlavor(DataFlavor.imageFlavor)
```
