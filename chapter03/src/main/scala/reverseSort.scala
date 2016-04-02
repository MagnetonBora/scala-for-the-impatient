import scala.collection.mutable.ArrayBuffer

def reverseSort(array: Array[Int]): Array[Int] = {
  array.sortWith(_ > _)
}

def reverseSort(arrayBuffer: ArrayBuffer[Int]): ArrayBuffer[Int] = {
  arrayBuffer.sortWith(_ > _)
}

println(reverseSort(Array(2, 1, 4, 3, 5)).mkString(","))


