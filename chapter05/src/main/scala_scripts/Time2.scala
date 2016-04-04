
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

// Test
val time = new Time2(5, 30)
val otherTime1 = new Time2(2, 0)
val otherTime2 = new Time2(6, 0)
println(time.before(otherTime1))
println(time.before(otherTime2))