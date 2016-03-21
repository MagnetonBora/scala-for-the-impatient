def signum(num: Int): Int = {
  if (num > 0) {
    1
  } else if (num < 0) {
    -1
  } else {
    0
  }
}

Console.println(signum(10))
Console.println(signum(-5))
Console.println(signum(0))
