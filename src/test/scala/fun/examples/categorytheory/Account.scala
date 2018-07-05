package fun.examples.categorytheory

import java.util.Date


sealed trait TransactionType
case object DR extends TransactionType
case object CR extends TransactionType

sealed trait Currency
case object USD extends Currency
case object JPY extends Currency
case object AUD extends Currency
case object INR extends Currency

case class Money(m: Map[Currency,BigDecimal]){
  def toBaseCurrency:BigDecimal = ???
}

case class Transaction(txid:String, accountNo:String, date:Date, amount: Money, txnType:TransactionType
                      ,status:Boolean)

case class Balance(b:Money)

