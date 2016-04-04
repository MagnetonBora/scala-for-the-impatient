
def positiveNegative(array: Array[Int]): Array[Int] = {
  array.filter(_ > 0) ++ array.filter(_ <= 0)
}

println(positiveNegative(Array(1, -2, 3, 0, -4, 5)).mkString(","))