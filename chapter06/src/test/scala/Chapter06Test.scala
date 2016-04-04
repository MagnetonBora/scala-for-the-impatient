import org.testng.annotations.Test
import org.testng.Assert._

class Chapter06Test {
  @Test
  def PointTest(): Unit = {
    val point1 = new Point(2, 4)
    val point2 = Point.apply(2, 4)
    assertEquals(point1.toString, point2.toString)
  }

}
