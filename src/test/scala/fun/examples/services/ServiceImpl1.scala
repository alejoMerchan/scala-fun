package fun.examples.services

import java.util.Date

import fun.examples.repositorys.common.Amount
import fun.examples.repositorys.{Account, AccoutRepository, Balance}

import scala.util.Try


object ServiceImpl1 extends AccountService[Account,Amount,Balance]{

  def transfer(from:Account, to:Account, amount: Amount):Try[(Account, Account, Amount)] =
    for{
      a <- debit(from.no,amount)
      b <- credit(to.no,amount)
    }yield (a,b,amount)

  override def open(no: String, name: String, openingDate: Option[Date]): Try[Account] = ???

  override def balance(no: String): Try[Balance] = ???

  override def credit(no: String, amount: Amount): Try[Account] = ???

  override def debit(no: String, amount: Amount): Try[Account] = ???
}
