package Tutorial

import java.util.{Date, Locale}
import java.text.DateFormat._


object DateFormat {
  
  def main(args: Array[String]) {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
    println(df.format(now)); //more verbose way
  }
}