def swap1(array: Array[Int]): Array[Int] = {
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

println(swap1(Array.emptyIntArray).mkString(","))
println(swap1(Array(1)).mkString(","))
println(swap1(Array(1, 2 ,3, 4)).mkString(","))
println(swap1(Array(1, 2 ,3, 4, 5)).mkString(","))

println(swap2(Array.emptyIntArray).mkString(","))
println(swap2(Array(1)).mkString(","))
println(swap2(Array(1, 2 ,3, 4)).mkString(","))
println(swap2(Array(1, 2 ,3, 4, 5)).mkString(","))