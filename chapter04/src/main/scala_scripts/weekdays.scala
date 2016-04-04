import scala.collection.mutable.LinkedHashMap

val weekdays = new LinkedHashMap[String, Int]()
weekdays += ("Monday" -> java.util.Calendar.MONDAY)
weekdays += ("Tuesday" -> java.util.Calendar.TUESDAY)
weekdays += ("Wednesday" -> java.util.Calendar.WEDNESDAY)
weekdays += ("Thursday" -> java.util.Calendar.THURSDAY)
weekdays += ("Friday" -> java.util.Calendar.FRIDAY)
weekdays += ("Saturday" -> java.util.Calendar.SATURDAY)
weekdays += ("Sunday" -> java.util.Calendar.SUNDAY)

println(weekdays)