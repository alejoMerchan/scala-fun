package fun.examples.categorytheory.monads.reader

import cats.data.Reader

object ReaderExample1 extends App{

  case class Cat(name:String, favoriteFood:String)

  val catName:Reader[Cat,String] = Reader(cat => cat.name)

  println(catName.run(Cat("Pedro Perez", "Frijoles")))

  val greetKitty:Reader[Cat, String] = catName.map(name => s"Hello ${name}")

  println(greetKitty.run(Cat("Juan Lopez", "Fajitas")))

  val feedKitty:Reader[Cat,String] = Reader(cat => s"have a nice bowl of ${cat.favoriteFood}")

  val greetAndFeed:Reader[Cat,String] =
    for{
      greet <- greetKitty
      feed <- feedKitty
    } yield s"$greet. $feed"

  println(greetAndFeed(Cat("Lonzo" , "salchipapas")))

}
