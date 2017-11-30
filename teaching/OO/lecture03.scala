package myScalaCourse

object quickSort {
  /*
   * QuickSort: imperative version
   */
  def sort(xs: Array[Int]) {
    def swap(i: Int, j: Int) {
      val t = xs(i); xs(i) = xs(j); xs(j) = t
    }
    def sort1(l: Int, r: Int) {
      val pivot = xs((l + r) / 2)
      var i = l; var j = r
      while (i <= j) {
        while (xs(i) < pivot) i += 1
        while (xs(j) > pivot) j -= 1
        if (i <= j) {
          swap(i, j)
          i += 1
          j -= 1
        }
      }
      if (l < j) sort1(l, j)
      if (i < r) sort1(i, r)
    }
    sort1(0, xs.length - 1)
  }

  def sortF(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sortF(xs filter (pivot >)),
        xs filter (pivot ==),
        sortF(xs filter (pivot <)))
    }
  }
}

object newtonMethod {
  import scala.math.{ abs, pow }

  object impl1 {
    def sqrt(x: Double) = sqrtIter(1.0, x)
    def sqrtIter(guess: Double, x: Double): Double =
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)

    def improve(guess: Double, x: Double) = (guess + x / guess) / 2
    def isGoodEnough(guess: Double, x: Double) = Math.abs(pow(guess, 2) - x) < 0.001
  }

  object impl2 {
    def sqrt(x: Double) = {
      def sqrtIter(guess: Double): Double =
        if (isGoodEnough(guess)) guess
        else sqrtIter(improve(guess))

      def improve(guess: Double) =
        (guess + x / guess) / 2

      def isGoodEnough(guess: Double) =
        abs(pow(guess, 2) - x) < 0.001

      sqrtIter(1.0)
    }

  }

}

object lecture03 {
  import quickSort._
  import newtonMethod.impl1._

  def main(args: Array[String]): Unit = {
    // test quickSort
    val ary = Array(6, 58, 4, 36, 2, 100)
    println(ary.toList)
    //    sort(ary)
    //    println(ary.toList)
    println(sortF(ary).toList)

    // test sqrt method
    println(sqrt(6))

  }

}