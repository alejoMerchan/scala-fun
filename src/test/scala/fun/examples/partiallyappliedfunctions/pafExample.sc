def plus(a:Int)(b:Int) = a + b

def plus2 = plus(2)(_)

plus2(2)

def wrap(prefix:String)(html:String)(suffix:String) =  {
  prefix + html + suffix
}

val hello = "hello world"

wrap("<div>")(hello)("</div>")

val otherWrap = wrap("<pre>")(_:String)("</pre>")

otherWrap("testing")
