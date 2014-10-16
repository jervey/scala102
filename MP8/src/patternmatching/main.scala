package patternmatching

object main {
  trait Expr {
      def eval : Int = this match {
          case Number(n) => n
          case Sum(e1, e2) => e1.eval + e2.eval
          case Prod(e1, e2) => e1.eval * e2.eval
          case Minus(e1, e2) => e1.eval - e2.eval
          case Divide(e1, e2) => e1.eval / e2.eval
      }   
   }
  
  case class Number(n:Int) extends Expr
  case class Sum(e1:Expr, e2:Expr) extends Expr
  case class Prod(e1:Expr, e2:Expr) extends Expr
  case class Minus(e1:Expr, e2:Expr) extends Expr
  case class Divide(e1:Expr, e2:Expr) extends Expr
  case class Var(x:Char) extends Expr
  
  object testExpr {
    def show(e:Expr):String = {
      e match {
        case Number(x) => x.toString()
        case Sum(e1, e2) => show(e1) + " + " + show(e2)
        case Minus(e1, e2) => show(e1) + " - " + show(e2)
        case Prod(e1,e2) => 
          val p1 = e1 match {
            case Sum(a,b) => "(" + show(Sum(a,b)) + ")"
            case Minus(a,b) => "(" + show(Minus(a,b)) + ")"
            case _ => show(e1)
          }
          val p2 = e2 match {
            case Sum(a,b) => "(" + show(Sum(a,b)) + ")"
            case Minus(a,b) => "(" + show(Minus(a,b)) + ")"
            case _ => show(e2)
          }
          p1 + " * " + p2
          
        case Divide(e1,e2) => 
          val d1 = e1 match {
            case Sum(a,b) => "(" + show(Sum(a,b)) + ")"
            case Minus(a,b) => "(" + show(Minus(a,b)) + ")"
            case _ => show(e1)
          }
          val d2 = e2 match {
            case Sum(a,b) => "(" + show(Sum(a,b)) + ")"
            case Minus(a,b) => "(" + show(Minus(a,b)) + ")"
            case _ => show(e2)
          }
          d1 + " / " + d2
        
        case Var(x) => x.toString
        
      }
    }
  }

    def main(args: Array[String]): Unit = {
      println(testExpr.show(Prod(Sum(Number(12),Var('i')),Prod(Number(378),Var('k')))))
      println(testExpr.show(Prod(Minus(Number(17),Var('y')),Divide(Var('q'),Var('k')))))
      println(testExpr.show(Minus(Number(15),Number(22))))
      println(testExpr.show(Prod(Sum(Number(17),Var('y')),Sum(Var('q'),Var('k')))))
      println(testExpr.show(Sum(Number(15),Number(22))))
      println("5 * 3 + 2 = " + (Sum(Prod(Number(5),Number(3)),Number(2))).eval)
      println("15 / 5 - 2 = " + (Minus(Divide(Number(15),Number(5)),Number(2))).eval)
      println("5 * 3 = " + (Prod(Number(5),Number(3)).eval))
      println("5 + 3 = " + (Sum(Number(5),Number(3)).eval))      
      println(testExpr.show(Prod(Sum(Number(3),Number(5)), Var('z'))))
      println(testExpr.show(Minus(Minus(Number(13),Number(5)), Var('p'))))
      
    }
  }
