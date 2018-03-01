package fun.examples.categorytheory.monads

/**
  * Ejemplificando la monada Identidad.
  *
  */


trait Monada[M[_]]{
  def unit[A](a:A):M[A]
  def flatMap[A,B](ma:M[A])(f:A => M[B]):M[B]
  def map[A,B](ma:M[A])(f:A => B):M[B] = flatMap (ma) (x => unit(f(x)))
}

case class Id[A](value:A){
  def map[B](f:A => B):Id[B] = Id(f(value))
  def flatMap[B](f:A => Id[B]):Id[B] = f(value)
}

object MonadaId extends Monada[Id]{
  def unit[A](a:A):Id[A] = Id(a)
  def flatMap[A,B](ma:Id[A])(f:A => Id[B]):Id[B] = ma flatMap f
}