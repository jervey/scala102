package coinchange

import scala.collection.mutable.ListBuffer

object main {

  /*
  def countChange(money: Int, coins: List[Int]): Int = {
    def f(lastMaxCoin_total_coll: List[(Int, Int)], count: Int): Int = {
      if (lastMaxCoin_total_coll.isEmpty) {
        count
      } 
	  else {
        val b = ListBuffer[(Int, Int)]()
        var newCount = count
        for ((lastMaxCoin, total) <- lastMaxCoin_total_coll) {
          if (total < money) {
            for (c <- coins) {
              if (c >= lastMaxCoin) {
                val e = (c, total + c)
                b += e
              }
            }
          } 
		  else if (total == money) {
            newCount += 1
          }
        }
 
        f(b.toList, newCount)
      }
    } 
    val b = coins.map { c => (c, c) }
    f(b, 0)
  }
  */
  
  def countChange(money: Int, coins: List[Int]): Int = {
   def count(capacity: Int, changes: List[Int]): Int = {
     //kung 0 is 1 ang default
      if(capacity == 0) 1
     //kung lapas end 0
      else if(capacity < 0) 0
      else if(changes.isEmpty && capacity>=1 ) 0
      else count(capacity, changes.tail) + count(capacity - changes.head, changes)
   }
   count(money, coins.sortWith(_.compareTo(_) < 0))
}
  
  def main(args: Array[String]):Unit = {
	println("Coin change is:")
	println(countChange(4, List(1,2)))
	println(countChange(70, List(1,5,10)))
	println(countChange(180, List(1,5,10)))
	}
}