package fun.examples.repositorys

import java.util.Date

import scala.util.Try


/**
  * Repository specialized to  handle Accouts aggregates
  */



trait AccoutRepository extends Repository[Account,String]{

  def query(accountNo:String): Try[Option[Account]]
  def store(a:Account):Try[Account]
  def balance(accountNo:String):Try[Balance]
  def openedOn(date:Date):Try[Seq[Account]]

}
