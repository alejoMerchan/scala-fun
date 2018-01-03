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

  // Flatten a nested list structure
  test("P07"){

    def flatten(list:List[Any]):List[Any] =  {
      list.map{
        elem =>
          elem match {
            case l:List[Any] => flatten(l)
            case n => List(n)
          }
      }.flatten
    }

    assert(List(1, 1, 2, 3, 5, 8) == flatten(List(List(1, 1), 2, List(3, List(5, 8)))))


  }

  //Eliminate consecutive duplicates of list elements.
  test("P08"){
    def compress(list:List[Symbol]):List[Symbol]   = {
      val listCompress = list.last :: List.empty[Symbol]
      (list foldRight  listCompress) {
        (a,b) =>
          if(b.head.equals(a)) b
        else a::b
      }
    }
    assert(List('a, 'b, 'c, 'a, 'd, 'e) == compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  }

  //Pack consecutive duplicates of list elements into sublists.
  test("P09"){

    def aux(list:List[Symbol], listAcum:List[List[Symbol]]): List[List[Symbol]] =  {
      list.span( _ equals(list.head)) match {
        case (list1,list2) => if(list2.isEmpty) list1::listAcum else aux(list2,list1::listAcum)
      }
    }
    def pack(list:List[Symbol]):List[List[Symbol]] = {
      aux(list,List.empty[List[Symbol]]).reverse
    }
    assert(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)) == pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  //Run-length encoding of a list.
  test("P10"){

    //Por Cuestion de comodidad se copia los mismos metodos en lugar de tener una clase que los implemente.

    def aux(list:List[Symbol], listAcum:List[List[Symbol]]): List[List[Symbol]] =  {
      list.span( _ equals(list.head)) match {
        case (list1,list2) => if(list2.isEmpty) list1::listAcum else aux(list2,list1::listAcum)
      }
    }
    def pack(list:List[Symbol]):List[List[Symbol]] = {
      aux(list,List.empty[List[Symbol]]).reverse
    }

    def encode(list:List[Symbol]): List[(Int,Symbol)] = pack(list).map(l => (l.size, l.head))

    assert(List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)) == encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))

  }

}
