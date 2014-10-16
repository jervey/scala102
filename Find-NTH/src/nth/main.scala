/*
 * JERVEY R. BENITEZ 	BSCS-IV
 * AUGUST 18, 2014
 * */

package nth
object main {

  def main(args: Array[String]): Unit = {
    println(nth(5, List(1, 1, 2, 3, 5, 8)));
    println(nth(1, List(1, 7, 2, 3, 5, 8)));
    println(nth(0, List(1, 1, 2, 3, 5, 8)));
    
  def nth[A](n: Int, ls: List[A]): A = {
	if (n >= 0) ls(n)
	else throw new IndexOutOfBoundsException
  		}
  
  def nthMeAgain[A](n: Int, ls: List[A]): A = (n, ls) match {
	case (0, target :: _   ) => target
	case (n, _ :: tail) => nthMeAgain(n - 1, tail)
	case (_, Nil      ) => throw new IndexOutOfBoundsException
	    }
  	}
  
}