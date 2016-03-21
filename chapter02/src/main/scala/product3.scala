def productOfString(str: String): Long = {
  if (str.length() == 1) {
    str.head.toLong
  } else {
    str.head.toLong * productOfString(str.drop(1))
  }
}

println(productOfString("Hello"))