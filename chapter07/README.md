1. Write an example program to demonstrate that
``` scala
package com.horstmann.impatient
```
is not the same as
``` scala
package com
package horstmann
package impatient
```
Solution:
``` scala
package com.horstmann.impatient

class Hello1 {

}
```
```
package com {
  package horstmann {
    class Hello2 {
    }
  }
  package impatient {}
}

```
2. Write a puzzler that baffles your Scala friends, using a package com that isn’t at the top level.
Solution:

3. Write a package random with functions nextInt(): Int, nextDouble(): Double, and setSeed(seed: Int): Unit. To generate random numbers, use the linear congruential generator
next = (previous × a + b) mod 2n,
where a = 1664525, b = 1013904223, n = 32, and the inital value of previous is seed.
``` scala
package object random {
  val a = 1664525
  val b = 1013904223
  val n = 32

  var seed = 1

  def nextInt(): Int = {
    ((seed * a + b) % Math.pow(2, n)).toInt
  }

  def nextDouble():Double = {
    (seed * a + b) % Math.pow(2, n)
  }

  def setSeed(seed: Int): Unit = {
    this.seed = seed
  }
}
```

4. Why do you think the Scala language designers provided the package object syntax instead of simply letting you add functions and variables to a package?
在Scala里，一切皆为object

5. What is the meaning of private[com] def giveRaise(rate: Double)? Is it useful?
基本没用。giveRaise对package com可见，但com是一个非常常见的包

6. Write a program that copies all elements from a Java hash map into a Scala hash map. Use imports to rename both classes.
``` scala
import java.util.{HashMap=> JavaHashMap}
import scala.collection.mutable.{HashMap => ScalaHashMap}

object HashMaps {
  def main(args: Array[String]) = {
    val javaHashMap = new JavaHashMap[Int, String]()
    javaHashMap.put(1, "A")
    javaHashMap.put(2, "B")

    val scalaHashMap = new ScalaHashMap[Int, String]()
    val entryIterator = javaHashMap.entrySet().iterator()
    while(entryIterator.hasNext) {
      val entry = entryIterator.next()
      scalaHashMap.put(entry.getKey(), entry.getValue)
    }

    Console.println(scalaHashMap)
  }
}
```

7. In the preceding exercise, move all imports into the innermost scope possible.
``` scala
object HashMaps2 {
  def main(args: Array[String]) = {
    import java.util.{HashMap => JavaHashMap}
    val javaHashMap = new JavaHashMap[Int, String]()
    javaHashMap.put(1, "A")
    javaHashMap.put(2, "B")

    import scala.collection.mutable.{HashMap => ScalaHashMap}
    val scalaHashMap = new ScalaHashMap[Int, String]()
    val entryIterator = javaHashMap.entrySet().iterator()
    while(entryIterator.hasNext) {
      val entry = entryIterator.next()
      scalaHashMap.put(entry.getKey(), entry.getValue)
    }

    Console.println(scalaHashMap)
  }
}
```

8. What is the effect of
```scala
import java._
import javax._
```
Is this a good idea?
java._和javax._下面jar包太多

9. Write a program that imports the java.lang.System class, reads the user name from the user.name system property, reads a password from the Console object, and prints a message to the standard error stream if the password is not "secret". Otherwise, print a greeting to the standard output stream. Do not use any other imports, and do not use any qualified names (with dots).
``` scala
import java.lang.System._

object User {
  def main(args: Array[String]) = {
    val user = getProperty("user.name")
    val password = Console.readLine("password:")

    if (password != "secret")
      Console.err.println("Invalid password!")
    else
      println("Welcome %s!".format(user))
  }
}
```

10. Apart from StringBuilder, what other members of java.lang does the scala package override?