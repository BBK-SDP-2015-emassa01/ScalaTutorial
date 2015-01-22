//import java.util.{Date, Locale} //multiple imports
//import java.text.DateFormat
//import java.text.DateFormat._ _ instead of *



package Tutorial
//everything from java.lang is imported automatically, others need to be explicit

object HelloWorld { //object here = singleton, class with a single instance.
  //this declaration declares the class and an instance, created on demand the first time it's used.
  //rather than declaring as 'static' you declare a singleton object in Scala.

  def main(args: Array[String]) { 
    //main is the name of the method and takes
    //an array of strings as a parameter
    println("Hello, world!")
    //body of method is above.
  }

}