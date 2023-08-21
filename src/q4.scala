class Accounts(var balance: Double) {
  def deposit(amount: Double): Unit = {
    require(amount > 0, "Deposit amount must be positive")
    balance += amount
  }

  def withdraw(amount: Double): Unit = {
    require(amount > 0, "Withdrawal amount must be positive")
    require(balance >= amount, "Insufficient balance")
    balance -= amount
  }

  def applyInterest(): Unit = {
    if (balance > 0) {
      balance += balance * 0.05
    } else {
      balance += balance * 0.1
    }
  }

  override def toString: String = s"Balance: $balance"
}

object Bank {
  def negativeBalances(accounts: List[Accounts]): List[Accounts] = {
    accounts.filter(_.balance < 0)
  }

  def totalBalance(accounts: List[Accounts]): Double = {
    accounts.map(_.balance).sum
  }

  def applyInterestToAll(accounts: List[Accounts]): Unit = {
    accounts.foreach(_.applyInterest())
  }
}

object q4 {
  def main(args: Array[String]): Unit = {
    val account1 = new Accounts(100.0)
    val account2 = new Accounts(-50.0)
    val account3 = new Accounts(200.0)

    val bankAccounts = List(account1, account2, account3)

    println("Accounts with negative balances:")
    Bank.negativeBalances(bankAccounts).foreach(println)

    println(s"Total balance of all accounts: ${Bank.totalBalance(bankAccounts)}")

    println("Balances after applying interest:")
    Bank.applyInterestToAll(bankAccounts)
    bankAccounts.foreach(println)
  }
}

