
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
