package fun.examples.challenges

import org.scalatest.FunSuite


class challenges extends FunSuite {

  test("654"){
    println(' '.isWhitespace)
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

  test("") {

    def operation(a: Int, b: Int, operation: Char): Char = {
      operation match {
        case '+' => (a + b).toString.charAt(0)
        case '-' => (a - b).toString.charAt(0)
        case '*' => (a * b).toString.charAt(0)
        case '/' => (a / b).toString.charAt(0)
      }
    }

    def metodoAux(listNums: List[Char], signo: Char): List[Char] = {
      listNums match {
        case a :: rest =>
          val y = (operation( rest.head.asDigit, a.asDigit , signo) :: rest.tail)
          y
      }
    }
    def operando(operacion:String):String  = {
      val aux = List.empty[Char]
      val y = (operacion foldLeft aux) {
        (a, b) =>
          if (b.isDigit) {
            b :: a
          } else {
            if(!b.isWhitespace)
            metodoAux(a, b)
            else{
              a
            }
          }
      }

      y.head.toString
    }

    println("resultado: " + operando("5 1 2 + 4 * + 3 -"))


  }

}
