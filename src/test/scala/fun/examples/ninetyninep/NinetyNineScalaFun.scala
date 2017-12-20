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



}
