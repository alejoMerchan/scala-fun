package fun.examples.categorytheory.monads.reader

import cats.data.Reader
import cats.syntax.applicative._

object ReaderExample2 extends App {

  case class Db(
                 usernames: Map[Int, String],
                 passwords: Map[String, String]
               )

  type DbReader[A] = Reader[Db, A]


  def findUsername(userId: Int):DbReader[Option[String]] = {
    Reader(db => db.usernames.get(userId))
  }

  def checkPassword(
                   userName:String,
                   password:String
                   ):DbReader[Boolean]  = {

    Reader(db => db.passwords.get(userName).contains(password))
  }


}
