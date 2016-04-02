def lteqgt(values: Array[Int], v: Int): Tuple2[Int, Int] = {
  (values.count(_ < v), values.count(_ > v))
}

println(lteqgt(Array(1, 2, 3, 4, 5, 6, 7, 8, 9), 6))