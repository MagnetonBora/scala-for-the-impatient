def countdown(n: Int): Unit = {
  (Range(n, -1, -1)).foreach(println)
}

countdown(10)