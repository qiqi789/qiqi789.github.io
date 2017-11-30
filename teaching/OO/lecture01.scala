package myScalaCourse

object lecture01 {
  
  /*
   * It separates the logic of computing the winner from the displaying of the result. 
   * Computing the winner in winner is referentially transparent 
   * and the impure part—displaying the result—is kept separate in printWinner. 
   */
  case class Player(name: String, score: Int)
  def winner(p1: Player, p2: Player): Player =
    if (p1.score > p2.score) p1 else p2
  def printWinner(p: Player): Unit =
    println(p.name + " is the winner!")

  def main(args: Array[String]): Unit = {
    val players = List(Player("Sue", 7), Player("Bob", 8), Player("Joe", 4))
    val p = players.reduceLeft(winner)
    printWinner(p)
  }

}