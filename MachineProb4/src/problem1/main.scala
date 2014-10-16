package problem1

object main {
  
/* PROBLEM 1
 * Let f and g be two one-argument functions. 
 * The composition f after g is defined to be 
 * the function x => f (g(x)). Define a function 
 * compose that implements composition. 
 * For example, if inc is a procedure that adds 1 
 * to its argument, compose (square, inc) 6 => 49 */
  def inc(x: Int): Int = x + 1
  def square(x: Int): Int = x * x
  def compose(f: Int => Int, g: Int => Int) = { 
    x: Int => f(g(x)) }
  
/* PROBLEM 2
 * create a function "repeated" where n = "positive int" 
 * if f is the function x -> x + 1, then the nth repeated application 
 * of f is the function x   x + n. If f is the operation of 
 * squaring a number, then the nth repeated application of f is the 
 * function that raises its argument to the (2^n)th power.
 * repeated (square 2) 5 => 625... 
 * 
 * HINT: make use of the "compose" higher order function
 * */  
  
  def repeated(f:Int =>Int, n: Int): Int => Int = {
    if (n == 1) f
    else compose(f, repeated(f, n - 1))
  }

  
  def main(args: Array[String]): Unit = {
    println("for problem 1:")
    println("compose(square, inc)(6)=" + compose(square, inc)(6))
    println("compose(square, inc)(17)=" + compose(square, inc)(17))
    println("compose(square, inc)(51)=" + compose(square, inc)(51))
    println("for problem 2:")
    println("((repeated square 2) 5)=" + repeated(square, 2)(5))
    println("((repeated square 3) 4)=" + repeated(square, 3)(4))
    println("((repeated square 4) 3)=" + repeated(square, 4)(3))
  }

}