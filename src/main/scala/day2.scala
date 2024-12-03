import os.read

@main def day2(): Unit =
  val lines = read.lines(os.resource / "input2.txt")

  val input =
    for line <- lines
    yield for {
      numStr <- line.split(" ")
    } yield numStr.toInt

  def safeCheck(l: Seq[Int]): Boolean =
    //println(l.sortWith((a,b) => b > a))
    //println(l.sortWith((a,b) => b < a))
    if l.sortWith((a,b) => b > a) == l || l.sortWith((a,b) => b < a) == l then
      val increasing = l.tail.head > l.head
      l.sliding(2).map {
        case Seq(a, b) =>
          if increasing then
            b - a <= 3 && b - a > 0
          else
            a - b <= 3 && a - b > 0
      }.forall(identity)
    else
      false

  //First part
  /*val safe =
    for line <- input
        if safeCheck(line)
    yield {
      println(line.mkString("Array(", ", ", ")"))
      1
    }*/

  //Second part
  val safe = input.iterator.flatMap { line =>
    line.indices.iterator.collectFirst {
      case i if safeCheck(line.patch(i, Nil, 1)) =>
        println(line.mkString("Array(", ", ", ")"))
        1
    }
  }

  println("Nb of safe:" + safe.sum)
