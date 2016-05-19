

object UnifiedTypes extends App {
  val set = new scala.collection.mutable.LinkedHashSet[Any]

  set += "This is a string."
  set += 321
  set += 'c'
  set += true
  set += main _

  val iter: Iterator[Any] = set.iterator
  while (iter.hasNext) {
    println(iter.next())
  }
}
