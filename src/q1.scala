class Rational1(x: Int, y: Int) {
  require(y != 0, "denominator must be non-zero")

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  val numer = x / gcd(x, y)
  val denom = y / gcd(x, y)

  def neg: Rational1 = new Rational1(-numer, denom)

  override def toString: String = s"$numer/$denom"
}
object q1 {
  def main(args: Array[String]): Unit = {
    val x = new Rational1(1, 2)
    val y = new Rational1(3, 4)

    val z = x.neg

    println(z)
  }

}
