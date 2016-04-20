import java.lang.System._

object User {
  def main(args: Array[String]) = {
    val user = getProperty("user.name")
    val password = Console.readLine("password:")

    if (password != "secret")
      Console.err.println("Invalid password!")
    else
      println("Welcome %s!".format(user))
  }
}
