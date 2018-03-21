package fun.examples.challenges

import org.scalatest.FunSuite


class challenges extends FunSuite {


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
        case s: String => if(s.isEmpty) "Empty String" else s
      }
    }


    println(reduceByPairs(""))
  }

}
