package fun.examples.ninetyninep

import org.scalatest.FunSuite


/**
  * Clase de pruebas  para implementar los 99 ejercicios de
  * http://aperiodic.net/phil/scala/s-99/
  */
class NinetyNineScalaFun extends FunSuite{

  // Find the last element of a list.
  test("P01"){
    def last(list:List[Int]):Int = list.last

    assert(8 == last(List(1,1,2,3,5,8)))

  }

  //Find the last but one element of a list.
  test("P02"){
    def penultimate(list:List[Int]):Int = list.init.last

    assert(5 == penultimate(List(1,1,2,3,5,8)))
  }

  //Find the Kth element of a list.
  test("P03"){
    def nth(n:Int,list: List[Int]):Int = list.find(_.equals(n)).getOrElse(0)

    assert(2 == nth(2 , List(1,1,2,3,5,8)))
  }

  //Find the number of elements of a list.
  test("P04"){
    def length(list: List[Int]):Int = list.size

    assert(6 == length(List(1,1,2,3,5,8)))
  }

  // Reverse a list.
  test("P05"){
    def reverse(list:List[Int]):List[Int] = list.reverse

    assert(List(8,5,3,2,1,1) == reverse(List(1,1,2,3,5,8)))
  }

  //Find out whether a list is a palindrome.
  test("P06"){
    def isPalindrome(list:List[Int]):Boolean = list.equals(list.reverse)

    assert(true == isPalindrome(List(1,2,3,2,1)))
  }

}
