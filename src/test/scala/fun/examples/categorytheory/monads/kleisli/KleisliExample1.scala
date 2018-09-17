package fun.examples.categorytheory.monads.kleisli

import cats.implicits._
import cats.data.Kleisli

object KleisliExample1 extends App {

  val parse:Kleisli[Option,String,Int] =
    Kleisli((s:String) => if(s.matches("-?[0-9]+")) Some(s.toInt) else None)

  val reciprocal:Kleisli[Option, Int,Double] =
    Kleisli((id:Int) => if(id != 0) Some(1.0 / id) else None)

  val parseAndReciprocal = reciprocal.compose(parse)

  println(parseAndReciprocal.run("5"))

}
