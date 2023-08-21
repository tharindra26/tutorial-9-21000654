class Rational(n: Int, d: Int) {
  require(d != 0, "Denominator cannot be zero")

  private val gcdValue: Int = gcd(n.abs, d.abs)
  val numer: Int = n / gcdValue
  val denom: Int = d / gcdValue

  private def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }

  def +(that: Rational): Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }

  def -(that: Rational): Rational = {
    new Rational(
      numer * that.denom - that.numer * denom,
      denom * that.denom
    )
  }

  override def toString: String = s"$numer/$denom"
}

object Rational {
  def apply(n: Int, d: Int): Rational = new Rational(n, d)
}

object Main {
  def main(args: Array[String]): Unit = {
    val x = Rational(3, 4)
    val y = Rational(5, 8)
    val z = Rational(2, 7)

    val result = x - y - z
    println(s"x - y - z = $result")
  }
}
