package mergesort

//
// MERGE SORT NAKO
//

object main {

  def main(args: Array[String]): Unit = {
    //put example dosort (list:Array[]=list)
    var value1:Array[Int] = List(5,11,8,4,2).toArray
    var value2:Array[Int] = List(9,18,18,2,2,2,15,16,3).toArray
    var value3:Array[Int] = List(2,3,5,9,10,13).toArray
    var value4:Array[Int] = List(17,12,9,8,4,2,0).toArray
    dosort(value1)
    dosort(value2)
    dosort(value3)
    dosort(value4)
    println("(5, 11, 8, 4, 2) = (" + value1.mkString(", ") + ")") 
    println("(9, 18, 18, 2, 2, 2, 15, 16, 3) = (" + value2.mkString(", ") + ")")
    println("(2, 3, 5, 9, 10, 13) = (" + value3.mkString(", ") + ")")
    println("(17, 12, 9, 8, 4, 2, 0) = (" + value4.mkString(", ") + ")")
  }
  
  
  def dosort(array:Array[Int]) {
    if (array.length > 1 ){
      var half = (array.length/2)
      var first:Array[Int] = array.slice(0, half)
      var second:Array[Int] = array.slice(half, array.length)
      dosort(first)
      dosort(second)
      merge(array, first, second)
    }
  }

  def merge(result:Array[Int], first:Array[Int], second:Array[Int]) {
    var i:Int = 0
    var j:Int = 0
    for (k <- 0 until result.length) {
      if(i<first.length && j<second.length){
        if (first(i) < second(j)){
          result(k) = first(i)
          i=i+1
        }   
        else {
          result(k) = second(j)
          j=j+1
        }
      }
      else if(i>=first.length && j<second.length){
        result(k) = second(j)
        j=j+1
      }      
      else {
        result(k) = first(i)
        i=i+1
      }
    }
  }
  
}


