def productOfString(str: String): Long = {
  str.foldLeft(1L)(_ * _.toLong)
}

println(productOfString("Hello"))