package fun.examples.categorytheory.monads.effects

import scala.util.Try

object OptionEffect extends App {


  def parseInt(str:String):Option[Int] = Try(str.toInt).toOption

  def divide(a:Int, b:Int):Option[Int] = if(b == 0) None else Some(a / b)

  def stringDivideBy(aStr:String, bStr:String):Option[Int] = {
    parseInt(aStr).flatMap{
      aNum =>
        println("first flat")
        parseInt(bStr).flatMap{
          bNum =>
            println("second flat")
            divide(aNum,bNum)
        }
    }
  }

  println(stringDivideBy("6" , "2"))
  println("-----------------------")
  println(stringDivideBy("6","0"))


  def stringDivideByFor(aStr:String, bStr:String):Option[Int] = {
    for{
      aNum <- parseInt(aStr)
      bNum <- parseInt(bStr)
      ans <- divide(aNum, bNum)
    } yield ans
  }

  println("-----------------------")
  println(stringDivideByFor("6" , "2"))


}
