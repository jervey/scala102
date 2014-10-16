package union

object MP6 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(506); 
  def main(args: Array[String]) = {

    val t1 = Empty
    val t2 = t1 incl 3 incl 5 incl 4 incl 7
    val t3 = t2 incl 2 incl 4 incl -1
    val s = Empty incl 1 incl 2 incl 4 incl 7
    val t = Empty incl 1 incl 2 incl 5 incl 8

    //println("Empty is denoted as" + t1);
    //println("t2 = " + t2);
    //println("t3 = " + t3);
    //println("S =" + s);
    //println("T =" + t);
    //println("t2 Union t3 = " + (t2 union t3));
    println("S union T =" + (s union t));
  };System.out.println("""main: (args: Array[String])Unit""")}
}

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
  
}

object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  /**************************/
  def union (other:IntSet): IntSet = other
  /*************************/

  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  /************************/
  def union (other:IntSet): IntSet =
    ((left union right) union other) incl elem
  /***********************/
    
  override def toString = "{" + left + elem + right + "}"
}package union

object MP6 {
  println("Welcome to the Scala worksheet")
}
