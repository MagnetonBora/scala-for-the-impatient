
class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {

  override def toString = s"Car($manufacturer, $modelName, $modelYear, $licensePlate)"
}

//Test
println(new Car("Honda", "Civic", 2011, "xx123zz"))
println(new Car("Hummer", "H1", 2010))
println(new Car("Opel", "Astra"))
