1.The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero. Write a function that computes this value.
``` scala
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
```
输出:
```
1
-1
0
```


2.What is the value of an empty block expression {}? What is its type?
``` scala
scala> val f = {}
f: Unit = ()
```


3.Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
``` scala
cala> var x = {}
x: Unit = ()

scala> var y = 1
y: Int = 1

scala> x = y = 1
x: Unit = ()
```


4.Write a Scala equivalent for the Java loop
``` java
for (int i = 10; i >= 0; i--) 
    System.out.println(i);
```
```scala
(Range(10, -1, -1)).foreach(println)
```


5.Write a procedure countdown(n: Int) that prints the numbers from n to 0.
``` scala
def countdown(n: Int): Unit = {
  (Range(n, -1, -1)).foreach(println)
}
countdown(10)
```


6.Write a for loop for computing the product of the Unicode codes of all letters in a string. For example, the product of the characters in "Hello" is 9415087488L.
``` scala
def productOfString(str: String): Long = {
  var productOfString = 1L
  for(ch <- str) {
    productOfString = productOfString * ch.toLong
  }
  productOfString
}
```


7.Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
``` scala
def productOfString(str: String): Long = {
  str.foldLeft(1L)(_ * _.toLong)
}
```


8.Write a function product(s : String) that computes the product, as described in the preceding exercises.
与7相同


9.Make the function of the preceding exercise a recursive function.
``` scala
def productOfString(str: String): Long = {
  if (str.length() == 1) {
    str.head.toLong
  } else {
    str.head.toLong * productOfString(str.drop(1))
  }
}
```


10.Write a function that computes x^n, where n is an integer. Use the following recursive definition:
    • x^n = y . y if n is even and positive, where y = xn / 2.
    • x^n = x·xn – 1 if n is odd and positive.
    • x^0 = 1.
    • x^n = 1 / x–n if n is negative.
    Don’t use a return statement.
``` scala
def pow(x: Int, n: Int): Double = {
  if (n == 0) {
    1
  } else {
    if (n > 0) {
      if (n % 2 == 0 && n > 2) {
        pow(pow(x, (n / 2)).toInt, 2)
      } else {
        x * pow(x, n - 1).toInt
      }
    } else {
      1 / pow(x, -n)
    }
  }
}
```
测试
``` scala
printf("2^2=%f\n", pow(2, 2));
printf("10^9=%f\n", pow(10, 9));
printf("3^3=%f\n", pow(3, 3));
printf("2^-1=%f\n", pow(2, -1));
printf("5^0=%f\n", pow(5, 0));

2^2=4.000000
10^9=1000000000.000000
3^3=27.000000
2^-1=0.500000
5^0=1.000000
```