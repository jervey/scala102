package pack_encode

object pack_encode {

  def pack[T](xs: List[T]): List[List[T]] = xs match {
    case Nil => Nil
    case x :: xs1 => {
	  val(finished ,next) = xs span (y=> y==x)
		finished :: pack(next)
      }
    } 


  def encode[T](xs: List[T]): List[(Int, T)] =
    pack(xs) map { 
    e => (e.length, e.head) 
    }
  
  
  def main(args: Array[String]): Unit = {
    val listex1 = List('a', 'a', 'a', 'b', 'c', 'c', 'a')
    val packans = pack (listex1)
    val encodeans = encode(listex1)
    println(packans)
    println(encodeans)
  }

}