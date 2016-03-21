1.In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?
``` scala
scala> 3.
!=   *   <        ==   >>>            getClass       toChar     toLong     unary_-
##   +   <<       >    ^              hashCode       toDouble   toShort    unary_~
%    -   <=       >=   asInstanceOf   isInstanceOf   toFloat    toString   |
&    /   <init>   >>   equals         toByte         toInt      unary_+
```


2.In the Scala REPL, compute the square root of 3, and then square that value. By how much does the result differ from 3? (Hint: The res variables are your friend.)
``` scala
scala> math.sqrt(3)
res2: Double = 1.7320508075688772

scala> res2 * res2
res3: Double = 2.9999999999999996
```


3.Are the res variables val or var?
val


4.Scala lets you multiply a string with a number—try out "crazy" * 3 in the REPL. What does this operation do? Where can you find it in Scaladoc?
``` scala
scala> "crazy" * 3
res4: String = crazycrazycrazy
```


5.What does 10 max 2 mean? In which class is the max method defined?
选取10和2中较大的那一个
max定义在Int中


6.Using BigInt, compute 2^1024.
``` scala
scala> val two = BigInt.apply(2)
two: scala.math.BigInt = 2

scala> two.pow(1024)
res6: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216
```


7.What do you need to import so that you can get a random prime as probablePrime(100, Random), without any qualifiers before probablePrime and Random?
``` scala
scala> import scala.math.BigInt.probablePrime
import scala.math.BigInt.probablePrime

scala> import scala.util.Random
import scala.util.Random

scala> probablePrime(100, Random)
res2: scala.math.BigInt = 664485341499260982018212482073
```


8.One way to create random file or directory names is to produce a random BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul". Poke around Scaladoc to find a way of doing this in Scala.
``` scala
scala> probablePrime(100, Random).toString(36)
res3: String = 2panf7xfu0n0c1gm07kv
```


9.How do you get the first character of a string in Scala? The last character?
``` scala
scala> "hello".head
res4: Char = h

scala> "hello".last
res5: Char = o
```


10.What do the take, drop, takeRight, and dropRight string functions do? What advantage or disadvantage do they have over using substring?
``` scala
scala> "hello".take(2)
res4: String = he

scala> "hello".drop(2)
res5: String = llo

scala> "hello".takeRight(2)
res6: String = lo

scala> "hello".dropRight(2)
res7: String = hel
```
相比substring，take和drop只能接收一个参数，无法提取中间一段字串。