
class Employee {
  var _name: String = ""
  var salary: Double = 0.0

  def this(n: String, s: Double) {
    this()
    _name = n
    salary = s
  }

  def name = _name
}
