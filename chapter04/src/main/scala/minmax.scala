def minmax(values: Array[Int]) = Tuple2[Int, Int] {
  (values.min, values.max)
}

println(minmax(Array(4, 2, 7, 1, 0, 9)))