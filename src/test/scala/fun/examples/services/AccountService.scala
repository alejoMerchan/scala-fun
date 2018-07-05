package fun.examples.services

import java.util.Date

import fun.examples.repositorys.AccoutRepository

import scala.util.Try


trait AccountService[Account, Amount, Balance] {
  def open(no:String, name:String, openingDate:Option[Date]):Try[Account]
  def credit(no:String,amount: Amount):Try[Account]
  def debit(no:String,amount: Amount):Try[Account]
  def balance(no:String):Try[Balance]

}
