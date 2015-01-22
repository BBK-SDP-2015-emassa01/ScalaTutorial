package Tutorial

object Timer {
  def oncePerSecond(callback: () => Unit) {
    while (true) { callback(); Thread sleep 1000 }
  }
  def timeFlies() {
    println("time flies like an arrow...")
  }
  def main(args: Array[String]) {
    oncePerSecond(timeFlies)
  }


//In the following program, the timer function is called oncePerSecond, and it gets a call-back function as argument.
//The type of this function is written () => Unit and is the type of all functions which take no arguments and 
//return nothing (the type Unit is similar to void in C/C++). The main function of this program simply calls this 
//timer function with a call-back which prints a sentence on the terminal. In other words, this program endlessly 
//prints the sentence “time flies like an arrow” every second.
 
}