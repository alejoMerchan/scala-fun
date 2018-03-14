package fun.examples.categorytheory.monads.state


object Golfing extends App{

  case class GolfState(distance:Int)

  def swing(distance:Int):State[GolfState, Int] = State {
    (s:GolfState) =>
      val newDistance = s.distance + distance
      (GolfState(newDistance),newDistance)
  }

  val stateWithNewDistance:State[GolfState, Int] = for{
    _ <- swing(20)
    _ <- swing(15)
    totalDistance <- swing(0)
  } yield totalDistance

  val beginningState = GolfState(1)

  val result:(GolfState, Int) = stateWithNewDistance.run(beginningState)

  println(s"GolfState:  ${result._1}")
  println(s"total distance:  ${result._2}")


}
