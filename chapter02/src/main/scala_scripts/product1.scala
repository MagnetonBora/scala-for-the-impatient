def productOfString(str: String): Long = {
  var productOfString = 1L
  for(ch <- str) {
    productOfString = productOfString * ch.toLong
  }
  productOfString
}

println(productOfString("Hello"))