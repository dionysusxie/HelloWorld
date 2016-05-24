
import scala.language.implicitConversions

object ImplicitDemo {
  def display(input:String): Unit = println(input)

  implicit def typeConvertor(input:Int): String = input.toString()

  //implicit def typeConvertor2(input: Int): String = input.toString()

  implicit def typeConvertor(input: Boolean): String = input.toString()

  implicit val ccc:String = "implicit"

  object Param {
    def println(content:String)(implicit prefix:String) {
      Console.println(prefix + ":" + content)
    }
  }

  def main(args: Array[String]) {
    display("1212")
    display(12)
    display(true)
    display(false)
    println

    Param.println("jack")
    Param.println("jack")("hello")
  }
}
