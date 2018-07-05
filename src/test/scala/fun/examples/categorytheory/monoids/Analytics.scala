package fun.examples.categorytheory.monoids

trait Analytics[Transaction, Balance, Money] {

  def maxDebitOnDay(txns:List[Transaction]):Money

}
