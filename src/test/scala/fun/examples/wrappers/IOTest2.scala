package fun.examples.wrappers

import cats.effect.IO

object IOTest2 extends App{
  val program:IO[Unit] = for{
    _ <- IO{println("welcome to scala,what is your name ?")}
    name <- IO{scala.io.StdIn.readLine}
    namcUC = name.toUpperCase
    _ <- IO{println(s"hello $namcUC")}
  } yield ()


  program.unsafeRunSync()
}
