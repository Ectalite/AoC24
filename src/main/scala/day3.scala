import os.read
import scala.util.matching.Regex

@main def day3(): Unit =
  val lines = read.lines(os.resource / "input3.txt")

  def findMul(str: String): List[(Int, Int)] =
    val mulPattern: Regex = """mul\((\d+),(\d+)\)""".r
    {
      for patternMatch <- mulPattern.findAllMatchIn(str)
        yield {
          println(s"key: ${patternMatch}, nb1: ${patternMatch.group(1)}, nb2: ${patternMatch.group(2)}")
          (patternMatch.group(1).toInt, patternMatch.group(2).toInt)
        }
    }.toList

  val a = {
    for line <- lines
      yield findMul(line)
  }.flatten

  val results =
    for pair <- a
      yield pair._1 * pair._2

  println(s"Uncorrupt mul result: ${results.sum}")