
class Person(var age: Int = 0) {
  if (age < 0) {
    age = 0
  }
}

// Test
val person1 = new Person(5)
println(person1.age)

val person2 = new Person(-5)
println(person2.age)