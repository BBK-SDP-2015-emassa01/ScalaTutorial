package Tutorial

abstract class Tree {

  type Environment = String => Int

  case class Sum(l: Tree, r: Tree) extends Tree
  case class Var(n: String) extends Tree
  case class Const(v: Int) extends Tree

  def eval(t: Tree, env: Environment): Int = t match {
    case Sum(l, r) => eval(l, env) + eval(r, env)
    case Var(n) => env(n)
    case Const(v) => v
  }

  def derive(t: Tree, v: String): Tree = t match {
    case Sum(l, r) => Sum(derive(l, v), derive(r, v))
    case Var(n) if (v == n) => Const(1) //case expression has a guard 'if'
    case _ => Const(0)
  }

  //A  simple main function which performs several operations on the expression (x+x)+(7+y): it first 
  //computes its value in the environment { x -> 5, y -> 7 }, then computes its derivative relative to 
  //x and then y.

   def main(args: Array[String]) {
    val exp: Tree = Sum(Sum(Var("x"), Var("x")), Sum(Const(7), Var("y")))
    val env: Environment = { case "x" => 5 case "y" => 7 }
    println("Expression: " + exp)
    println("Evaluation with x=5, y=7: " + eval(exp, env))
    println("Derivative relative to x:\n " + derive(exp, "x"))
    println("Derivative relative to y:\n " + derive(exp, "y"))
  }
  //    By examining the output, we see that the result of the derivative should be simplified before being
  //    presented to the user. Defining a basic simplification function using pattern matching is an interesting 
  //    (but surprisingly tricky) problem, left as an exercise for the reader.

}