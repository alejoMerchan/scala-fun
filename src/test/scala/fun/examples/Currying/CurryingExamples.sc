def add(x:Int, y:Int) = x + y


// technique to convert a def method into a true function.
(add _).isInstanceOf[Function2[_,_,_]]

// create a "curried" function.
val addCurried = (add _).curried

// apply the curried function.
addCurried(1)(2)

// creating a partially applied function from the curried function.
val addCurried2 = addCurried(2)

addCurried2(10)

