package fun.examples.wrappers

class Wrapper[A](value: A) {

  def map[ B](f: A => B): Wrapper[B] = {

    val newInt = f(value)
    new Wrapper(newInt)

  }

  def flatMap[B](f: A => Wrapper[B]): Wrapper[B] = f(value)

  override def toString = value.toString
}

case class Debuggable[A](value:A){

  def map[B](f:A => B):Debuggable[B] = {
    val newValue = f(value)
    new Debuggable(newValue)
  }

  def flatMap[B](f:A => Debuggable[B]):Debuggable[B] = {
    val newValue = f(value)
    newValue
  }

}
