package myScalaCourse

object lecture02 {

  case class Person(name:String, age:Int)
  
  trait Graphs {
    type Node
    type Edge
    def pred(e:Edge): Node
    def succ(e: Edge): Node
    type Graph <: GraphSig
    def newGraph(nodes: Set[Node], edges: Set[Edge]): Graph
    
    trait GraphSig {
      def nodes: Set[Node]
      def edges: Set[Edge]
      def outgoing(n: Node): Set[Edge]
      def incoming(n: Node): Set[Edge]
      def sources: Set[Node]
    }
    
  }
  
  trait AbstractModel extends Graphs {
    class Graph(val nodes: Set[Node], val edges: Set[Edge]) extends GraphSig {
      def outgoing(n: Node) = edges filter (pred(_) == n)
      def incoming(n: Node) = edges filter (succ(_) == n)
      lazy val sources = nodes filter (incoming(_).isEmpty)
    }
    def newGraph(nodes: Set[Node], edges:Set[Edge]) = 
      new Graph(nodes, edges)
  }
  
  trait ConcreteModel extends Graphs {
    type Node = Person
    type Edge = (Person, Person)
    def succ(e: Edge) = e._1
    def pred(e: Edge) = e._2
  }
  
  class MyGraph extends AbstractModel with ConcreteModel
  
  
  def main(args: Array[String]): Unit = {
    val adam = Person("Adam",20)
    val bob = Person("Bob", 26)
    val chad = Person("Chad", 27)
    val friends = Set(adam, bob, chad)
    val links = Set((adam, bob), (adam, chad))

    val mygraphClass = new MyGraph
    val graph = mygraphClass.newGraph(friends, links)
    println(graph.nodes)
    
  }

}