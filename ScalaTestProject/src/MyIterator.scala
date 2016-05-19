
abstract class AbsIterator {
  type T
  def hasNext: Boolean
  def next: T
}


trait RichIterator extends AbsIterator {
  def foreach(f: T=>Unit) {
    while (hasNext) {
      f(next)
    }
  }
}


class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  def hasNext = {
    i < s.length()
  }

  def next = {
    val current = s(i)
    i = i + 1
    current
  }
}


object MyIterator {
  def main(args: Array[String]) {
    for (arg: String <- args) {
      println(arg)
    }
    
    class Iter extends StringIterator(args(0)) with RichIterator
    val iter = new Iter
    iter.foreach(println)
  }
}
