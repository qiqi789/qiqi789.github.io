package myScalaCourse

object lecture02_2 {
import scala.util.{Try, Success, Failure}

/*
 * Scala Try using For
 */
  def divide: Try[Int] = {
    val dividend = Try(Console.readLine("Enter an Int that you'd like to divide:\n").toInt)
    val divisor = Try(Console.readLine("Enter an Int as a divisor:\n").toInt)
    val problem = for {
      x <- dividend
      y <- divisor
    } yield x/y
    problem match {
      case Success(v) => println("Result of " + dividend.get + "/" + divisor.get + s" is $v")
    		  Success(v)
      case Failure(e) =>
        		println("some errors occurred.")
        		println("exception info: " + e.getMessage)
        		divide
    }
  }
  
  def main(args: Array[String]): Unit = {
    divide
  }

}