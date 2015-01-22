package Tutorial

//While this program is easy to understand, it can be refined a bit. First of all, notice that the 
//function timeFlies is only defined in order to be passed later to the oncePerSecond function. 
//Having to name that function, which is only used once, might seem unnecessary, and it would in 
//fact be nice to be able to construct this function just as it is passed to oncePerSecond. 
//This is possible in Scala using anonymous functions, which are exactly that: functions without a name. 
//The revised version of our timer program using an anonymous function instead of timeFlies looks like that:

object TimerAnonymous {
  def oncePerSecond(callback: () => Unit) {
    while (true) { callback(); Thread sleep 1000 }
  }
  def main(args: Array[String]) {
    oncePerSecond(() =>
      println("time flies like an arrow...!"))
  }
}

//The presence of an anonymous function in this example is revealed by the right arrow => which separates the 
//function’s argument list from its body. In this example, the argument list is empty, as witnessed by the 
//empty pair of parenthesis on the left of the arrow. The body of the function is the same as the one of timeFlies.