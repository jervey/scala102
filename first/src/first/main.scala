package first

object Main { 
	def main(args: Array[String]) { 
		println("Pascal's Triangle") 
		for (row <- 0 to 10) { 
			for (col <- 0 to row) 
			print(pascal(col, row) + " ") 
		println() 
		} 
	} 
	
	/** Pascal Triangle
	  */
		
	def pascal(c: Int, r: Int): Int = {

		/** kung naa na sya sa pinaka-
		  * daplin sa column iyang i-return 
		  * kay 1.
		  */
		
		if (c == r || c == 0) 1

		/** Kung naa sa tunga i add niya 
		  * ang duwa nga naa sa taas, through recursion
		  * until c||r == 0
		  */

		else pascal(c - 1, r - 1) + pascal(c, r - 1)
	}
}