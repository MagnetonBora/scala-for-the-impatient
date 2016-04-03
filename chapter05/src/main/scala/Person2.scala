
class Person2(private val name: String) {

  def firstName = name.split("\\s+")(0)
  def lastName = name.split("\\s+")(1)
}


// Test
val person = new Person2("Fred Smith")
println(person.firstName)
println(person.lastName)
