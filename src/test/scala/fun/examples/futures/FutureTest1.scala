package fun.examples.futures

import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object FutureTest1 extends App{

  import scala.concurrent.ExecutionContext.Implicits.global

  def futuro1(number:String) = {
    Future{
      Thread.sleep(3000)
      number.toInt / 2
    }
  }

  def futuro2(number:String) = {
    Future{
      Try{
        Thread.sleep(3000)
        number.toInt / 2
      }
    }
  }

  def futureToFutureTry[T](f: Future[T]): Future[Try[T]] =
    f.map(Success(_)).recover({case e => Failure(e)})


  val list =  List("a","2","b","4","c","8")



  val futureList = list.map(x => futuro1(x)).map(futureToFutureTry(_))
  val y = Future.sequence(futureList)

  val a = y.map(_.filter(_.isSuccess))

  val b = y.map(_.filter(_.isFailure))

  a.onComplete{
    case Success(result) => println("exitosos: " + result.toString())
  }

  b.onComplete {
    case Success(result) => println("fallidos: " + result.toString())
  }



  val futureList2 = list.map(x => futuro2(x))

  val c = Future.sequence(futureList2)

  val d = c.map(_.filter(_.isSuccess))

  val e = c.map(_.filter(_.isFailure))


  d.onComplete{
    case Success(result) => println("exitosos 2: " + result.toString())
  }

  e.onComplete {
    case Success(result) => println("fallidos 2: " + result.toString())
  }


  Thread.sleep(120000)



}
