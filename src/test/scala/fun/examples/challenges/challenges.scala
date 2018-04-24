package fun.examples.challenges

import org.scalatest.FunSuite


class challenges extends FunSuite {

  test("654") {
    def isDigit(x:String)=  x.matches("[-+]?\\d+(\\.\\d+)?")
    println(isDigit("3"))
  }

  test("reduce by pairs") {

    def aux(l: String): String = {

      l.span(_ equals (l.head)) match {
        case (s1, s2) =>
          if (s1.isEmpty && s2.isEmpty) ""
          else {
            if (s1.length % 2 == 0) aux(s2) else s1.head + aux(s2)
          }
      }
    }

    def reduceByPairs(s: String): String = {
      aux(aux(s)) match {
        case s: String => if (s.isEmpty) "Empty String" else s
      }
    }


    println(reduceByPairs(""))
  }

  test("Expresion Evaluator") {

    def operation(a: Double, b: Double, operation: String): String = {
      operation match {
        case "+" => (a + b).toString
        case "-" => (a - b).toString
        case "*" => (a * b).toString
        case "/" => (a / b).toString
      }

    }
    def evaluateAux(listNums: List[String], signo: String): List[String] = {
      listNums match {
        case a :: rest =>
          val y = (operation(rest.head.toDouble, a.toDouble, signo) :: rest.tail)
          y
      }
    }

    def isNumber(x:String)=  x.matches("[-+]?\\d+(\\.\\d+)?")

    def evaluate(string: String): Double = {
      val listString = string.split(" ").toList
      val aux = List.empty[String]
      val y = (listString foldLeft aux) {
        (a, b) =>
          if (isNumber(b)) {
            b :: a
          } else {
            evaluateAux(a, b)
          }
      }
     y.head.toDouble
    }


    assert(evaluate("2 5 -")=== -3 )

    assert(evaluate("3 4 5")=== 5 )

    assert(evaluate("9 2 /")=== 4.5 )

    assert(evaluate("10000 2345.67 +")=== 12345.67 )

    assert(evaluate("3 2 1 - *")=== 3 )

    assert(evaluate("5 1 2 + 4 * + 3 -")=== 14 )

    assert(evaluate("7 4 5 + * 3 - 10 /")=== 6 )



  }

}
