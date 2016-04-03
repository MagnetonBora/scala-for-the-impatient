1.Improve the Counter class in Section 5.1, “Simple Classes and Parameterless Methods,” on page 49 so that it doesn’t turn negative at Int.MaxValue.
``` scala
class Counter {
  private var value = 0
  def increment() {
    if (value < Int.MaxValue) {
      value += 1
    }
  }

  def current() = value
}
```

2.Write a class BankAccount with methods deposit and withdraw, and a read-only property balance.
``` scala
class BankAccount {
  private var account: Double = 0.0

  def deposit(value: Double): Unit = {
    account += value
  }

  def withdraw(value: Double): Unit = {
    if (account - value >= 0) {
      account -= value
    } else {
      throw new Exception("Your don't have enough money for withdraw.")
    }
  }

  def balance = account
}
```

3.Write a class Time with read-only properties hours and minutes and a method before(other: Time): Boolean that checks whether this time comes before the other. A Time object should be constructed as new Time(hrs, min), where hrs is in military time format (between 0 and 23).
``` scala
class Time(private[this] val hrs: Int = 0, private[this] val min: Int = 0) {

  if (hrs < 0 || hrs > 23) {
    throw new IllegalArgumentException("hours should between 0 and 23.")
  }

  if (min < 0 || min > 59) {
    throw new IllegalArgumentException("hours should between 0 and 59.")
  }

  def hours = hrs
  def minutes = min

  def before(other: Time): Boolean  = {
    this.hours < other.hours || (this.hours == other.hours && this.minutes < other.minutes)
  }
}
```

4.Reimplement the Time class from the preceding exercise so that the internal representation is the number of minutes since midnight (between 0 and 24 × 60 – 1). Do not change the public interface. That is, client code should be unaffected by your change.
``` scala
class Time2(private[this] val hrs: Int = 0, private[this] val min: Int = 0) {

  if (hrs < 0 || hrs > 23) {
    throw new IllegalArgumentException("hours should between 0 and 23.")
  }

  if (min < 0 || min > 59) {
    throw new IllegalArgumentException("hours should between 0 and 59.")
  }

  private val minutes = hrs * 60 + min

  def before(other: Time2): Boolean  = {
    this.minutes < other.minutes
  }
}
```

5.Make a class Student with read-write JavaBeans properties name (of type String) and id (of type Long). What methods are generated? (Use javap to check.) Can you call the JavaBeans getters and setters in Scala Should you?
``` scala
import scala.beans.BeanProperty

class Student {

  @BeanProperty
  var name: String = ""

  @BeanProperty
  var id: Long = 0
}
```
```
# scalac Student.scala
# javap Student
Compiled from "Student.scala"
public class Student {
  public java.lang.String name();
  public void name_$eq(java.lang.String);
  public void setName(java.lang.String);
  public long id();
  public void id_$eq(long);
  public void setId(long);
  public java.lang.String getName();
  public long getId();
  public Student();
}
```

6.In the Person class of Section 5.1, “Simple Classes and Parameterless Methods,” on page 49, provide a primary constructor that turns negative ages to 0.
``` scala
class Person(var age: Int = 0) {
  if (age < 0) {
    age = 0
  }
}
```

7.Write a class Person with a primary constructor that accepts a string containing a first name, a space, and a last name, such as new Person("Fred Smith"). Supply read-only properties firstName and lastName. Should the primary constructor parameter be a var, a val, or a plain parameter? Why?
``` scala
class Person2(private val name: String) {

  def firstName = name.split("\\s+")(0)
  def lastName = name.split("\\s+")(1)
}
```

8.Make a class Car with read-only properties for manufacturer, model name, and model year, and a read-write property for the license plate. Supply four constructors. All require the manufacturer and model name. Optionally, model year and license plate can also be specified in the constructor. If not, the model year is set to -1 and the license plate to the empty string. Which constructor are you choosing as the primary constructor? Why?
``` scala
class Car(val manufacturer: String, val modelName: String, val modelYear: Int = -1, var licensePlate: String = "") {

}
```
9.Reimplement the class of the preceding exercise in Java, C#, or C++ (your choice). How much shorter is the Scala class?
``` Java
public class Car {

    private String manufacturer;
    private String modelName;
    private int modelYear;
    private String licensePlate;

    public Car(String manufacturer, String modelName, int modelYear, String licensePlate) {
        initialize(manufacturer, modelName, modelYear, licensePlate);
    }

    public Car(String manufacturer, String modelName) {
        initialize(manufacturer, modelName, -1, "");
    }

    public Car(String manufacturer, String modelName, int modelYear) {
        initialize(manufacturer, modelName, modelYear, "");
    }

    public Car(String manufacturer, String modelName, String licensePlate) {
        initialize(manufacturer, modelName, -1, licensePlate);
    }

    private void initialize(String manufacturer, String modelName, int modelYear, String licensePlate) {
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.modelYear = modelYear;
        this.licensePlate = licensePlate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getModelYear() {
        return modelYear;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}

```

10.Consider the class
``` scala
class Employee(val name: String, var salary: Double) {
  def this() { this("John Q. Public", 0.0) }
}
```
Rewrite it to use explicit fields and a default primary constructor. Which form do you prefer? Why?
``` scala
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
```