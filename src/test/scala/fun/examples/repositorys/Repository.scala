package fun.examples.repositorys

import scala.util.Try

/**
  * General repository.
  */
trait Repository[A,IdType] {

  def query(idType: IdType):Try[Option[A]]
  def store(a: A):Try[A]

}
