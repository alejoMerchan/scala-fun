package fun.examples.wrappers

import scalaz.effect.IO

object IOTest1 extends App {

  def getLine:IO[String] = IO(scala.io.StdIn.readLine())

  def putStrln(s:String):IO[Unit] = IO(println(s))

  def x:IO[Unit] =  for{
    _ <- putStrln("first name")
    firstName <- getLine
    _ <- putStrln(s"last name?")
    lastName <- getLine
    _ <- putStrln(s"First: $firstName last: $lastName")
  } yield ()

}



