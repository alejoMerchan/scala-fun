package fun.examples.services

import java.util.Date

import fun.examples.repositorys.AccoutRepository

trait AccountService[Account, Amount, Balance] {
  def open(no:String, name:String, openingDate:Option[Date],r:AccoutRepository)

}
