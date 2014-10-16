package balanceme
//Jervey R. Benitez				CSC102 - BALANCING PARENTHESES
object main {
    def balance(chars: List[Char]): Boolean = {
      def balancePar(chars: List[Char], openStatus: Int): Boolean = {
      if (chars.isEmpty) {
        openStatus == 0 //for if openstatus init and wala'y sulod
      } 
      else {
        val leftMost = chars.head
        val count = { 
          if (leftMost == '(') openStatus + 1
          //if daplin naa'y open, openstatus+1 = positive.sobra temp false or balance 
          else if (leftMost == ')') openStatus - 1
          //els if naa'y close, openstatus-1 = negative.sobra = temp false or balanced
          else openStatus
          //if other characters ignore
          }
        if (count >= 0) balancePar(chars.tail, count)
        //leftmost over now check right most if balanced or naa pa'y nabilin
        else false
      	}
      }
    balancePar(chars, 0) 
    }

  def main(args: Array[String]): Unit = {
    println(balance("(FALSE NI DAPAT!)()(naa'y)(sobra na)((open))(()".toList))
    println(balance("(DAPAT TRUE NI!)gwa(po)(balance sya)".toList))
    println(balance("FALSE POD NI!!)puros ra closed))".toList))
  }
}