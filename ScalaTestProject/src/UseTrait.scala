
trait Ord {
  def < (that: Any): Boolean
  def <=(that: Any): Boolean = (this < that) || (this == that)
  def > (that: Any): Boolean = !(this <= that)
  def >=(that: Any): Boolean = !(this < that)
}


class MyDate(y: Int, m: Int, d: Int) extends Ord {
  def year = y
  def month = m
  def day = d

  //override def toString(): String = "" + year + "-" + month + "-" + day
  override def toString(): String = {
    "" + year + "-" + month + "-" + day
  }

  override def equals(that: Any): Boolean = {
    that.isInstanceOf[MyDate] && {
      val o = that.asInstanceOf[MyDate]
      o.year == year && o.month == month & o.day == day
    }
  }

  override def < (that: Any): Boolean = {
    if (!that.isInstanceOf[MyDate])
      error("cannot compare " + that + " with a Date")

    val o = that.asInstanceOf[MyDate]
    (this.year < o.year) ||
    (this.year == o.year && (month < o.month ||
                            (month == o.month && day < o.day)))
  }
}


object UseTrait {
  def main(args: Array[String]) = {
    val date = new MyDate(2016, 4, 6)
    val date2 = new MyDate(2016, 4, 5)
    println("date1 " + date)
    println("date2 " + date2)
    println(date + " > " + date2 + " ? " + (date > date2))

    val date3 = new MyDate(2016, 4, 6)
    println(date + " == " + date3 + " ? " + (date == date3))
  }
}

