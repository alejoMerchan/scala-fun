package fun.examples.categorytheory.monads

/**
  * Implementacion ejemplo de la monada identidad ejemplificando que funciona como un envoltorio.
  *
  */
object MainExample extends App {

  // esto es una prueba
  val exampleIdentidad = for{
    x <- Id("Hola ")
    y <- Id("Mundo!")
  } yield x + y

  println(exampleIdentidad)

}
