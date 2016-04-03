
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

// Test
val time = new Time(5, 30)
val otherTime1 = new Time(2, 0)
val otherTime2 = new Time(6, 0)
println(time.before(otherTime1))
println(time.before(otherTime2))