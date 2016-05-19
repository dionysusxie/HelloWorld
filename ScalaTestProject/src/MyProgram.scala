import java.util.{ Date, Locale }
import java.text.DateFormat
import java.text.DateFormat._


object Timer {
  def oncePerSecond(callback: ()=>Unit, time: Int) {
    for(i <- 1 to time) {
      print(i + ": ")
      callback()
      Thread sleep 1000
    }
  }
}


class Complex(real: Double, imaginary: Double) {
  def re() = real
  def im() = imaginary
  override def toString() = "" + re() + (if (im() >= 0) "+" else "") + im() + "i"
}


class Complex2(real: Double, imaginary: Double) {
  def re = real
  def im = imaginary
}


abstract class Tree
case class Sum(l: Tree, r: Tree) extends Tree
case class Var(n: String) extends Tree
case class Const(v: Int) extends Tree


object MyProgram {
  type Environment = String => Int

  def timeFlies() {
    println("time flies as an arrow...")
  }

  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }

  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if (v == n) => Const(1)
    case _ => Const(0)
  }

  def main(args: Array[String]) {
    println("Scala rocks!")

    // case class
    println("case class:")
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = { case "x" => 5 case "y" => 7 }
    println("expression: " + exp)
    println("evaluation with x = 5, y = 7: " + eval(exp, env))
    val derive_x = derive(exp, "x")
    val derive_y = derive(exp, "y")
    println("derivative relative to x:\n  " + derive_x + "\n  value: " +
        eval(derive_x, (x: String) => 0))
    println("derivative relative to y:\n  " + derive_y + "\n  value: " +
        eval(derive_y, (x: String) => 0))

    val date = new Date
    val df = getDateInstance(LONG, Locale.CHINA)
    println(df format date)

    val s1 = "1 + 2 * 3 = "
    println(s1 + (1 + 2 * 3))
    println(s1 +  (1).+((2).*(3)))

    //Timer.oncePerSecond(timeFlies, 5)
    Timer.oncePerSecond({ () => println("Time flies as an arrow...") }, 5)

    println()
    val complex = new Complex(1, 2)
    println("complex value = " + complex)
    println("complex value = " + new Complex(1, -2))

    val complex2 = new Complex2(1, 2)
    //complex2.re = 3
    println("complex2 value = (" + complex2.re + ", " + complex2.im + ")")
  }
}
