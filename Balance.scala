  def balance(chars: List[Char]): Boolean = {
    def balancePar(chars: List[Char], openStatus: Int): Boolean = {
      if (chars.isEmpty) {
        openStatus == 0
      } else {
        val leftMost = chars.head
        val n =
          if (leftMost == '(') openStatus + 1
          else if (leftMost == ')') openStatus - 1
          else openStatus
        if (n >= 0) balancePar(chars.tail, n)
        else false
      }
    }
 
    balancePar(chars, 0)
  }
