package mergesort2

//
// MERGE SORT NGA NAA SA LIBRO!!
//

object main {
  def main(args: Array[String]): Unit = {
    val nums = List(2, -4, 5, 7, 1)           
    val sorted = mSort(nums)          
    println(sorted)
  }

  def mSort(xs:List[Int]):List[Int] = {
  val n = xs.length/2
  if (n==0) xs
  	else{
  		val(first, second) = xs splitAt n
  		merge(mSort(first),mSort(second) )
		}
  }
  
  def merge(xs: List[Int], ys: List[Int]):List[Int] = {
    (xs, ys) match {
      case (xs, Nil) => xs
      case (Nil, ys) => ys
      case (x :: xs1, y :: ys1) => 
        if (x < y) x :: merge(xs1, ys)
        else y :: merge(xs, ys1) 
    }
  }
  
  /*
  def msort(xs: List[Int]): List[Int] = {
    val n = xs.length/2
    if (n == 0) xs
    else {
      def merge(xs: List[Int], ys: List[Int]) = //???
        xs match {
          case Nil =>
          	ys
          case x :: xs1 =>
          	ys match {
          	  case Nil =>
          	  	xs
          	  case y :: ys1 =>
          	  	if (x < y) x :: merge(xs1, ys)
          	  	else y :: merge(xs, ys1)
          	}
      }
      val (fst, snd) = xs splitAt n
      merge(msort(fst), msort(snd))
    }
  }
   */
}