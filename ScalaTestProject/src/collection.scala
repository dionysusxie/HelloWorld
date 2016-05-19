
object collection extends App {

  val isEven: PartialFunction[Int, String] = {
    case x if x % 2 == 0 => x + " is even"
  }

  val isOdd: PartialFunction[Int, String] = {
    case x if x % 2 == 1 => x + " is odd"
  }

  val x = 0 to 10
  print("x: ")
  for (item: Int <- x) print(item + " ")
  println()

  val xEven = x.collect(isEven)
  println("\nx even: ")
  for (item: String <- xEven) println(item + " ")
  println()
  
  val xAll = x.collect(isEven orElse isOdd)
  println("\nx all: ")
  for (item: String <- xAll) println(item + " ")
  println()

  var s1 = Seq(1,2,3,4)
  println(s1.takeWhile((x) => (x <= 2)))
  println(s1.takeWhile(x => (x > 1)))
}
